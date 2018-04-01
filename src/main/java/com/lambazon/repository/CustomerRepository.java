package com.lambazon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambazon.domain.Customer;

/**
 * 
 * JPA managed
 * 
 * @author stanlick
 *
 */

@Repository
public interface  CustomerRepository extends CrudRepository<Customer, Long>{}
