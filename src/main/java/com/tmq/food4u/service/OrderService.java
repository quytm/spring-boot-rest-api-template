package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.Order;
import com.tmq.food4u.dto.request.CreateOrderRequest;

import java.util.List;
import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByUserId(Long userId);

    Optional<Order> create(CreateOrderRequest request);

}
