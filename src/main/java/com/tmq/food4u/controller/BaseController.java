package com.tmq.food4u.controller;

import com.tmq.food4u.common.constant.F4UErrorCode;
import com.tmq.food4u.common.exception.F4uBusinessException;
import com.tmq.food4u.dto.response.F4uResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 11, 2019
 */
public abstract class BaseController<S, T> {

    @Autowired
    protected S service;// each Controller only call a service

    @Autowired
    protected T transform;

    protected <D> ResponseEntity<F4uResponse<D>> response(D data) {
        F4uResponse<D> response = toResult(data);
        return ResponseEntity.ok(response);
    }

    private <D> F4uResponse<D> toResult(D data) {
        if (data == null) throw new F4uBusinessException.NotFoundEntityException();

        F4uResponse<D> response = new F4uResponse<>();
        response.setCode(F4UErrorCode.SUCCESS);
        response.setMessage(F4UErrorCode.SUCCESS_DESCRIPTION);
        response.setData(data);

        return response;
    }

}
