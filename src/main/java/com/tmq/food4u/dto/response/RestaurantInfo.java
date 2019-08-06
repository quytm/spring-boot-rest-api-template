package com.tmq.food4u.dto.response;

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
public class RestaurantInfo implements Serializable {

    private static final long serialVersionUID = 3384588469747152123L;

    private String name;
    private String summary;
    private String image;
    private String address;
    private Double rating;

}
