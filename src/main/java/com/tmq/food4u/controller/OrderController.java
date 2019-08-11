package com.tmq.food4u.controller;

import com.tmq.food4u.common.exception.F4uBusinessException;
import com.tmq.food4u.converter.F4uTransform;
import com.tmq.food4u.dao.entity.Order;
import com.tmq.food4u.dto.request.CreateOrderRequest;
import com.tmq.food4u.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private F4uTransform transform;

    @GetMapping("")
    public ResponseEntity getAll(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody CreateOrderRequest request) {
        Optional<Order> opt = orderService.create(request);

        if (!opt.isPresent()) throw new F4uBusinessException.FailedToExecuteException("Cannot create Order");

        return ResponseEntity.ok(transform.toCreateOrderResponse(opt.get()));
    }

}
