package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.OrderMenuItems;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
public interface OrderMenuItemsService {

    Iterable<OrderMenuItems> saveAll(List<OrderMenuItems> orderMenuItems);

}
