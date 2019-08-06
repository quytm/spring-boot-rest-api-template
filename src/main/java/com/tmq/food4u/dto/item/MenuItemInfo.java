package com.tmq.food4u.dto.item;

import com.tmq.food4u.dao.entity.MenuItem;
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
public class MenuItemInfo implements Serializable {

    private Long id;
    private int quantity;
    private String note;

    // bonus
    private transient MenuItem menuItem;

}
