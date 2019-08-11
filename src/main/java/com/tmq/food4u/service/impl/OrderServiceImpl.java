package com.tmq.food4u.service.impl;

import com.tmq.food4u.common.exception.F4uBusinessException;
import com.tmq.food4u.converter.F4uMapper;
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
public class OrderServiceImpl extends BaseServiceImpl<OrderRepository, Order, Long> implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private OrderMenuItemsService orderMenuItemsService;

    @Autowired
    private F4uMapper mapper;

    @Override
    public List<Order> findByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public Optional<Order> create(CreateOrderRequest request) {
        if (request == null) throw new F4uBusinessException.InvalidInputException("Request for Creating order is invalid");

        // Get User
        Long userId = request.getUserId();
        Optional<User> optUser = userService.findById(userId);
        if (!optUser.isPresent()) throw new F4uBusinessException.NotFoundEntityException("User not found");

        // Get restaurant
        Long restaurantId = request.getRestaurantId();
        Optional<Restaurant> optRestaurant = restaurantService.findById(restaurantId);
        if (!optRestaurant.isPresent()) throw new F4uBusinessException.NotFoundEntityException("Restaurant not found");

        // Get MenuItem entity
        List<MenuItemInfo> items = request.getItems();
        items.forEach(item -> {
            Optional<MenuItem> opt = menuItemService.findById(item.getId());
            if (!opt.isPresent()) return;
            item.setMenuItem(opt.get());
        });
        items = items.stream()
                .filter(info -> info.getMenuItem() != null)
                .collect(Collectors.toList());

        // Create order and save
        Order order = mapper.toOrder(optUser.get(), optRestaurant.get(), items);
        order = repo.save(order);

        // Save order_menu
        Order finalOrder = order;
        List<OrderMenuItems> orderMenuItems = items.stream()
            .map(menuInfo -> mapper.toOrderMenuItems(finalOrder, menuInfo))
            .collect(Collectors.toList());
        orderMenuItemsService.saveAll(orderMenuItems);

        // return result
        return Optional.ofNullable(order);
    }
}
