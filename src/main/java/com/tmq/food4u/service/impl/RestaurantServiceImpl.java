package com.tmq.food4u.service.impl;

import com.tmq.food4u.common.exception.F4uBusinessException;
import com.tmq.food4u.converter.F4uMapper;
import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.repo.RestaurantRepository;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;
import com.tmq.food4u.service.MenuItemService;
import com.tmq.food4u.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Service("restaurantService")
@CacheConfig(cacheNames = {"RESTAURANT_CACHE"})
public class RestaurantServiceImpl extends BaseServiceImpl<RestaurantRepository, Restaurant, Long> implements RestaurantService {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private F4uMapper mapper;

    @Override
    public Optional<Restaurant> createNew(CreateRestaurantRequest request) {
        Restaurant restaurant = mapper.toRestaurant(request);
        return save(restaurant);
    }

    @Override
    @Cacheable(key = "'getMenu_' + #restaurantId")
    public List<MenuItem> getMenu(Long restaurantId) {
        return menuItemService.findByRestaurantId(restaurantId);
    }

    @Override
    public Optional<MenuItem> createNewMenu(Long restaurantId, CreateMenuRequest request) {
        Optional<Restaurant> opt = findById(restaurantId);
        if (!opt.isPresent()) throw new F4uBusinessException.NotFoundEntityException("Restaurant not found");

        Restaurant restaurant = opt.get();
        return menuItemService.createNewMenu(restaurant, request);
    }
}
