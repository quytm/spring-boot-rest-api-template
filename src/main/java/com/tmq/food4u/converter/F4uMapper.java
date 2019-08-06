package com.tmq.food4u.converter;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Order;
import com.tmq.food4u.dao.entity.OrderMenuItems;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dto.item.MenuItemInfo;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;
import com.tmq.food4u.dto.request.SignInRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Component
public class F4uMapper {

    public Restaurant toRestaurant(CreateRestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(request, restaurant);
        return restaurant;
    }

    public MenuItem toMenuItem(Restaurant restaurant, CreateMenuRequest request) {
        MenuItem menu = new MenuItem();

        BeanUtils.copyProperties(request, menu);
        menu.setRestaurant(restaurant);

        return menu;
    }

    public User toUser(SignInRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        return user;
    }

    public Order toOrder(User user, Restaurant restaurant, List<MenuItemInfo> items) {
        long amount = 0L;
        for (MenuItemInfo menuItemInfo : items) {
            MenuItem menuItem = menuItemInfo.getMenuItem();
            amount += menuItemInfo.getQuantity() * menuItem.getPrice();
        }

        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setStatus(Order.Status.WAIT_FOR_PAYMENT);
        order.setAmount(amount);
        return order;
    }

    public OrderMenuItems toOrderMenuItems(Order order, MenuItemInfo menuInfo) {
        OrderMenuItems omi = new OrderMenuItems();
        omi.setOrderMenuItemsPk(new OrderMenuItems.OrderMenuItemsPk(order, menuInfo.getMenuItem()));
        omi.setQuantity(menuInfo.getQuantity());
        return omi;
    }

}
