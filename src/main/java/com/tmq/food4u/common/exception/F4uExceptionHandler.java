package com.tmq.food4u.common.exception;

import com.tmq.food4u.common.constant.F4UErrorCode;
import com.tmq.food4u.dto.response.F4uResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 07, 2019
 */
@ControllerAdvice
@Slf4j
public class F4uExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<F4uResponse<String>> handleException(final HttpServletRequest request,
                                                               final Exception e) {
        log.info(e.getMessage(), e);

        F4uResponse<String> response = new F4uResponse<>();
        response.setCode(F4UErrorCode.UNKNOWN_ERROR);
        response.setMessage(F4UErrorCode.UNKNOWN_ERROR_MESSAGE);

        return new ResponseEntity<>(response, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(F4uBusinessException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(final HttpServletRequest request,
                                                                        final Exception e) {
        log.info(e.getMessage(), e);

        F4uBusinessException exception = (F4uBusinessException) e;

        F4uResponse<String> response = new F4uResponse<>();
        response.setCode(exception.getCode());
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }
}
