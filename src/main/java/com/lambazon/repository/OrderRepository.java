package com.lambazon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambazon.domain.Order;

/**

 * JPA managed
 * 
 * @author stanlick
 *
 */

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{}
