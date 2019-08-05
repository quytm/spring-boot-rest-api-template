package com.tmq.food4u.util;

import com.tmq.food4u.dao.entity.User;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 05, 2019
 */
public class Generator {

    public static String generateToke(User user) {
        return user.getId() + "_" + user.getUsername();
    }

}
