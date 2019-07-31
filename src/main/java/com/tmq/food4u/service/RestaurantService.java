package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
public interface RestaurantService {

    Iterable<Restaurant> findAll();

    List<MenuItem> getMenu(Long restaurantId);

}
