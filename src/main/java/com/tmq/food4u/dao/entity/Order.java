package com.tmq.food4u.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 2945675423558091933L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "integer(10) default 0")
    private long amount;

    @Column
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    @CreationTimestamp
    private Timestamp created;

    @Column
    @UpdateTimestamp
    private Timestamp modified;

    // -----------------------------------------------------------------------------------------------------------------
    public static final class Status {

        public static final int WAIT_FOR_PAYMENT = 1;
        public static final int DELIVERING = 2;
        public static final int DELIVERED = 3;

        public static final String WAIT_FOR_PAYMENT_KEY = "WAIT_FOR_PAYMENT";
        public static final String DELIVERING_KEY = "DELIVERING";
        public static final String DELIVERED_KEY = "DELIVERED";

        public static final String WAIT_FOR_PAYMENT_NAME = "Wait for payment";
        public static final String DELIVERING_NAME = "Delivering";
        public static final String DELIVERED_NAME = "Delivered";

    }
}
