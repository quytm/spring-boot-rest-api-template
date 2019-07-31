package com.tmq.food4u.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Getter
@Setter
public class CreateMenuRequest implements Serializable {

    private String name;
    private int category;
    private int price;

}
