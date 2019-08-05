package com.tmq.food4u.converter;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;
import com.tmq.food4u.dto.request.SignInRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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

}
