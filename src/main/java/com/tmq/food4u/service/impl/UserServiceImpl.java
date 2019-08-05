package com.tmq.food4u.service.impl;

import com.tmq.food4u.converter.F4uMapper;
import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dao.repo.UserRepository;
import com.tmq.food4u.dto.request.SignInRequest;
import com.tmq.food4u.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private F4uMapper mapper;

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> addNew(SignInRequest request) {
        User user = mapper.toUser(request);
        User savedUser = userRepository.save(user);

        return Optional.ofNullable(savedUser);
    }
}
