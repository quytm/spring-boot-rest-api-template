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
public class MenuItemResponse implements Serializable {

    private static final long serialVersionUID = -36318278912946008L;

    private Long id;
    private String name;
    private Integer category;
    private String categoryName;
    private Integer price;

}
