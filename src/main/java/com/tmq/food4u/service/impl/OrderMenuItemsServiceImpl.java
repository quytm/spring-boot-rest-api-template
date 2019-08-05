package com.tmq.food4u.service.impl;

import com.tmq.food4u.dao.entity.OrderMenuItems;
import com.tmq.food4u.dao.repo.OrderMenuItemsRepository;
import com.tmq.food4u.service.OrderMenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Service("orderMenuItemsService")
public class OrderMenuItemsServiceImpl implements OrderMenuItemsService {

    @Autowired
    private OrderMenuItemsRepository orderMenuItemsRepository;

    @Override
    public Iterable<OrderMenuItems> saveAll(List<OrderMenuItems> orderMenuItems) {
        return orderMenuItemsRepository.saveAll(orderMenuItems);
    }
}
