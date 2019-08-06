package com.tmq.food4u.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Getter
@Setter
public class CreateRestaurantRequest implements Serializable {

    private static final long serialVersionUID = -1204499229264515060L;

    private String name;
    private String summary;
    private String image;
    private String cover;
    private String address;
    private String openTime;
    private String closeTime;

}
