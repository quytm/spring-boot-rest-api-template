package com.tmq.food4u.service;

import com.tmq.food4u.dao.entity.User;
import com.tmq.food4u.dto.request.SignInRequest;

import java.util.Optional;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
public interface UserService extends BaseService<User, Long> {

    Optional<User> addNew(SignInRequest request);

}
