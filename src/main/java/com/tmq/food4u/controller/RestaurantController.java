package com.tmq.food4u.controller;

import com.tmq.food4u.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@RestController()
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @GetMapping("/{id}/menu")
    public ResponseEntity getMenu(@PathVariable("id") Long restaurantId) {
        return ResponseEntity.ok(restaurantService.getMenu(restaurantId));
    }

}
