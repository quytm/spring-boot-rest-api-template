package com.tmq.food4u.service.impl;

import com.tmq.food4u.converter.F4uMapper;
import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dao.repo.MenuItemRepository;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private F4uMapper mapper;

    @Override
    public Optional<MenuItem> findById(Long id) {
        return menuItemRepository.findById(id);
    }

    @Override
    public List<MenuItem> findByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Optional<MenuItem> createNewMenu(Restaurant restaurant, CreateMenuRequest request) {
        if (request == null) return Optional.empty();

        MenuItem menuItem = mapper.toMenuItem(restaurant, request);

        return Optional.ofNullable(menuItemRepository.save(menuItem));
    }
}
