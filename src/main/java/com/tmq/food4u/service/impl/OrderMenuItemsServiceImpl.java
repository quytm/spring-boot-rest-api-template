package com.tmq.food4u.service.impl;

import com.tmq.food4u.dao.entity.OrderMenuItems;
import com.tmq.food4u.dao.entity.OrderMenuItems.OrderMenuItemsPk;
import com.tmq.food4u.dao.repo.OrderMenuItemsRepository;
import com.tmq.food4u.service.OrderMenuItemsService;
import org.springframework.stereotype.Service;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Service("orderMenuItemsService")
public class OrderMenuItemsServiceImpl extends BaseServiceImpl<OrderMenuItemsRepository, OrderMenuItems, OrderMenuItemsPk> implements OrderMenuItemsService {
}
