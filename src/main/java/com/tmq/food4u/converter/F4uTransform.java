package com.tmq.food4u.converter;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dto.response.MenuItemResponse;
import com.tmq.food4u.dto.response.RestaurantInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Component
public class F4uTransform {

    public RestaurantInfo toResponse(Restaurant restaurant) {
        RestaurantInfo response = new RestaurantInfo();
        BeanUtils.copyProperties(restaurant, response);

        return response;
    }

    public List<RestaurantInfo> toResponse(Iterable<Restaurant> restaurants) {
        List<RestaurantInfo> responses = new LinkedList<>();
        for (Restaurant restaurant : restaurants) responses.add(toResponse(restaurant));
        return responses;
    }

    public MenuItemResponse toResponse(MenuItem menuItem) {
        MenuItemResponse response = new MenuItemResponse();
        BeanUtils.copyProperties(menuItem, response);
        response.setCategoryName(menuItem.getCategory() == null ? "" : toMenuItemCategory(menuItem.getCategory()));

        return response;
    }

    public List<MenuItemResponse> toMenuItemResponse(List<MenuItem> menuItems) {
        return menuItems.stream().map(this::toResponse).collect(Collectors.toList());
    }

    private String toMenuItemCategory(int category) {
        switch (category) {
            case MenuItem.Category.DRINK:
                return MenuItem.Category.DRINK_NAME;
            case MenuItem.Category.FOOD:
                return MenuItem.Category.FOOD_NAME;
        }

        return "";
    }

}
