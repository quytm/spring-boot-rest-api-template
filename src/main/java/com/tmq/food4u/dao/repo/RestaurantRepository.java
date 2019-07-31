package com.tmq.food4u.dao.repo;

import com.tmq.food4u.dao.entity.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
}
