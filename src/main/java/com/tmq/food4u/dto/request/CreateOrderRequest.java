package com.tmq.food4u.dto.request;

import com.tmq.food4u.dto.item.MenuItemInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Getter
@Setter
public class CreateOrderRequest implements Serializable {

    private static final long serialVersionUID = 3023597845099067674L;

    private Long userId;
    private Long restaurantId;
    private List<MenuItemInfo> items;

}
