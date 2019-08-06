package com.tmq.food4u.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 07, 2019
 */
@Getter
@Setter
public class F4uResponse<T> implements Serializable {

    private static final long serialVersionUID = 5489598869007278721L;

    protected String code;
    protected String message;
    protected T data;

}
