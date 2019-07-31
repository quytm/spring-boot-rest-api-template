package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.MenuItem;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
public interface MenuItemService {

    List<MenuItem> findByRestaurantId(Long restaurantId);

}
