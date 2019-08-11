package com.tmq.food4u.controller;

import com.tmq.food4u.common.constant.F4UErrorCode;
import com.tmq.food4u.common.exception.F4uBusinessException;
import com.tmq.food4u.dao.entity.MenuItem;
import com.tmq.food4u.dao.entity.Restaurant;
import com.tmq.food4u.dto.request.CreateMenuRequest;
import com.tmq.food4u.dto.request.CreateRestaurantRequest;
import com.tmq.food4u.dto.response.F4uResponse;
import com.tmq.food4u.service.RestaurantService;
import com.tmq.food4u.converter.F4uTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private F4uTransform transform;

    @GetMapping("")
    public ResponseEntity getAll() {
        Iterable<Restaurant> restaurants = restaurantService.findAll();
        return response(toResult(transform.toResponse(restaurants)));
    }

    @PostMapping("")
    public ResponseEntity addNew(@RequestBody CreateRestaurantRequest request) {
        Optional<Restaurant> opt = restaurantService.createNew(request);

        if (!opt.isPresent()) throw new F4uBusinessException.FailedToExecuteException("Cannot add new Restaurant");

        return response(toResult(transform.toResponse(opt.get())));
    }

    @GetMapping("/{id}/menu")
    public ResponseEntity getMenu(@PathVariable("id") Long restaurantId) {
        List<MenuItem> menuItems = restaurantService.getMenu(restaurantId);
        return response(toResult(transform.toMenuItemResponse(menuItems)));
    }

    @PostMapping("/{id}/menu")
    public ResponseEntity addNewMenu(@PathVariable("id") Long restaurantId,
                                     @RequestBody CreateMenuRequest request) {
        Optional<MenuItem> opt = restaurantService.createNewMenu(restaurantId, request);

        if (!opt.isPresent()) throw new F4uBusinessException.FailedToExecuteException("Cannot add new Menu");

        return response(toResult(transform.toResponse(opt.get())));
    }

    // private method

    private <T> ResponseEntity<F4uResponse<T>> response(F4uResponse<T> data) {
        return ResponseEntity.ok(data);
    }

    private <T> F4uResponse<T> toResult(T data) {
        F4uResponse<T> response = new F4uResponse<>();
        response.setCode(F4UErrorCode.SUCCESS);
        response.setMessage(F4UErrorCode.SUCCESS_DESCRIPTION);
        response.setData(data);
        return response;
    }

}
