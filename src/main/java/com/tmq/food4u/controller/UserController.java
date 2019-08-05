package com.tmq.food4u.controller;

import com.tmq.food4u.converter.F4uTransform;
import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dto.request.SignInRequest;
import com.tmq.food4u.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 05, 2019
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private F4uTransform transform;

    @PostMapping("/signIn")
    private ResponseEntity signIn(@RequestBody SignInRequest request) {
        Optional<User> opt = userService.addNew(request);

        if (!opt.isPresent()) return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(transform.toSignInResponse(opt.get()));
    }

}
