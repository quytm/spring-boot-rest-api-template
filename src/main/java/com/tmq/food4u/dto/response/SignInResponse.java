package com.tmq.food4u.dto.response;

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
public class SignInResponse implements Serializable {

    private static final long serialVersionUID = 3022891922960171387L;

    private String username;

}
