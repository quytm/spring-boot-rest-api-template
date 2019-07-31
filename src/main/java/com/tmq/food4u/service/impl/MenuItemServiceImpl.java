package com.tmq.food4u.service.impl;

import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.repo.MenuItemRepository;
import com.tmq.food4u.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> findByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

}
