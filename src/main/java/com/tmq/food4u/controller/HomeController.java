package com.tmq.food4u.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@RestController
@RequestMapping
public class HomeController {

    @GetMapping("")
    public ResponseEntity home() {
        return ResponseEntity.ok("Welcome to Food4U");
    }

}
