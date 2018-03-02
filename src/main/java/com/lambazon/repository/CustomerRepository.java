package com.lambazon.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lambazon.domain.Customer;

@Repository
public class CustomerRepository {
	
	private Map<Long, Customer> customers = new HashMap<>();

	
	public List<Customer> customers() {
		
		return customers.values()
				.stream()
				.sorted(Comparator.comparing(Customer::getName))
				.collect(Collectors.toList());
	}
	
	public Customer customer(Long id) {
		return customers.get(id);
	}
	
	public Customer save(Customer customer) {
		return customers.put(customer.getId(), customer);
	}

}
