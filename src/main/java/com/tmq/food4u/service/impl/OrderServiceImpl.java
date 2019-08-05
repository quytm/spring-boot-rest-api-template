package com.tmq.food4u.service.impl;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Order;
import com.tmq.food4u.dao.entity.OrderMenuItems;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dao.repo.OrderRepository;
import com.tmq.food4u.dto.item.MenuItemInfo;
import com.tmq.food4u.dto.request.CreateOrderRequest;
import com.tmq.food4u.service.MenuItemService;
import com.tmq.food4u.service.OrderMenuItemsService;
import com.tmq.food4u.service.OrderService;
import com.tmq.food4u.service.RestaurantService;
import com.tmq.food4u.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private OrderMenuItemsService orderMenuItemsService;

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Optional<Order> create(CreateOrderRequest request) {
        if (request == null) return Optional.empty();

        // Get User
        Long userId = request.getUserId();
        Optional<User> optUser = userService.findById(userId);
        if (!optUser.isPresent()) return Optional.empty();

        // Get restaurant
        Long restaurantId = request.getRestaurantId();
        Optional<Restaurant> optRestaurant = restaurantService.findById(restaurantId);
        if (!optRestaurant.isPresent()) return Optional.empty();

        List<MenuItemInfo> items = request.getItems();
        items.forEach(item -> {
            Optional<MenuItem> opt = menuItemService.findById(item.getId());
            if (!opt.isPresent()) return;
            item.setMenuItem(opt.get());
        });

        items = items.stream()
                .map(info -> {
                    MenuItemInfo menuItemInfo = new MenuItemInfo();
                    BeanUtils.copyProperties(info, menuItemInfo);

                    Optional<MenuItem> opt = menuItemService.findById(info.getId());
                    if (!opt.isPresent()) return menuItemInfo;

                    menuItemInfo.setMenuItem(opt.get());
                    return menuItemInfo;
                })
                .filter(info -> info.getMenuItem() != null)
                .collect(Collectors.toList());

        long amount = 0L;
        for (MenuItemInfo menuItemInfo : items) {
            MenuItem menuItem = menuItemInfo.getMenuItem();
            amount += menuItemInfo.getQuantity() * menuItem.getPrice();
        }

        // Save order
        Order order = new Order();
        order.setUser(optUser.get());
        order.setRestaurant(optRestaurant.get());
        order.setStatus(Order.Status.WAIT_FOR_PAYMENT);
        order.setAmount(amount);
        order = orderRepository.save(order);

        // Save order_menu
        Order finalOrder = order;
        List<OrderMenuItems> orderMenuItems = items.stream().map(menuInfo -> {
            OrderMenuItems omi = new OrderMenuItems();
            omi.setOrderMenuItemsPk(new OrderMenuItems.OrderMenuItemsPk(finalOrder, menuInfo.getMenuItem()));
            omi.setQuantity(menuInfo.getQuantity());
            return omi;
        }).collect(Collectors.toList());

        orderMenuItemsService.saveAll(orderMenuItems);

        return Optional.ofNullable(order);
    }
}
