package com.tmq.food4u.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Getter
@Setter
@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, unique = true)
    private String code;

    @Column(length = 100)
    private String name;

    @Column
    private Integer category;

    @Column(columnDefinition = "integer(10) default 0")
    private Integer price;

    @Column(columnDefinition = "integer(10) default 0")
    private Integer quantityStock;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
