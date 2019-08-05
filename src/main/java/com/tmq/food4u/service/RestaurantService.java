package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
public interface RestaurantService {

    Iterable<Restaurant> findAll();

    Optional<Restaurant> findById(Long restaurantId);

    List<MenuItem> getMenu(Long restaurantId);

    Optional<Restaurant> createNew(CreateRestaurantRequest request);

    Optional<MenuItem> createNewMenu(Long restaurantId, CreateMenuRequest request);

}
