package com.tmq.food4u.service.impl;

import com.tmq.food4u.converter.F4uMapper;
import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.repo.RestaurantRepository;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;
import com.tmq.food4u.service.MenuItemService;
import com.tmq.food4u.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private F4uMapper mapper;

    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> createNew(CreateRestaurantRequest request) {

        Restaurant restaurant = mapper.toRestaurant(request);
        Restaurant newRestaurant = restaurantRepository.save(restaurant);

        return Optional.ofNullable(newRestaurant);
    }

    @Override
    public List<MenuItem> getMenu(Long restaurantId) {
        return menuItemService.findByRestaurantId(restaurantId);
    }

    @Override
    public Optional<MenuItem> createNewMenu(Long restaurantId, CreateMenuRequest request) {
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
        if (!opt.isPresent()) return Optional.empty();

        Restaurant restaurant = opt.get();
        return menuItemService.createNewMenu(restaurant, request);
    }
}
