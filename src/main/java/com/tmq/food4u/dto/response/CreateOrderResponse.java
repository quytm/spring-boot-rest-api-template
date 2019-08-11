package com.tmq.food4u.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 10, 2019
 */
@Getter
@Setter
public class CreateOrderResponse implements Serializable {

    private static final long serialVersionUID = 664798552357279593L;

    private Long id;

    private Long amount;

}
