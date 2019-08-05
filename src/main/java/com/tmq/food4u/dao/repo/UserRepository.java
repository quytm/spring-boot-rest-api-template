package com.tmq.food4u.dao.repo;

import com.tmq.food4u.dao.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 01, 2019
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
