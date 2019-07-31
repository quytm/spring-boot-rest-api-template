package com.tmq.food4u.service.impl;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.repo.RestaurantRepository;
import com.tmq.food4u.service.MenuItemService;
import com.tmq.food4u.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemService menuItemService;

    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<MenuItem> getMenu(Long restaurantId) {
        return menuItemService.findByRestaurantId(restaurantId);
    }
}
