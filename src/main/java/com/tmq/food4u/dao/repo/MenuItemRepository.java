package com.tmq.food4u.dao.repo;

import com.tmq.food4u.dao.entity.MenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Jul 31, 2019
 */
@Repository
public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, Long> {

    List<MenuItem> findByRestaurantId(Long restaurantId);

}
