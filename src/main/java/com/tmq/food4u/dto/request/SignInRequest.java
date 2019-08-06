package com.tmq.food4u.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 05, 2019
 */
@Getter
@Setter
public class SignInRequest implements Serializable {

    private static final long serialVersionUID = -3983565377004298039L;

    private String username;
    private String password;
    private String passwordConfirmation;

}
