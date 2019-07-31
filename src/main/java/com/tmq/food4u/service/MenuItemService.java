package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dto.request.CreateMenuRequest;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
public interface MenuItemService {

    List<MenuItem> findByRestaurantId(Long restaurantId);

    Optional<MenuItem> createNewMenu(Restaurant restaurant, CreateMenuRequest request);

}
