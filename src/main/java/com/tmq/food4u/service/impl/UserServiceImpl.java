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
public class UserServiceImpl extends BaseServiceImpl<UserRepository, User, Long> implements UserService {

    @Autowired
    private F4uMapper mapper;

    @Override
    public Optional<User> addNew(SignInRequest request) {
        User user = mapper.toUser(request);
        return save(user);
    }

}
