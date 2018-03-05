package com.lambazon.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lambazon.API;
import com.lambazon.domain.Customer;

@Repository
public class CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<>();

	private static void generateData() {
		customers.add(API.createCustomer("Scott Stanlick"));
		customers.add(API.createCustomer("Donald Trump"));
	}
	
	
	public List<Customer> customers() {
		
		if (customers.isEmpty()) {
			generateData();
		}
		
		return customers
				.stream()
				.sorted(Comparator.comparing(Customer::getName))
				.collect(Collectors.toList());
	}
	
	public Customer customer(Long id) {
		return customers.stream()
						.filter(c->c.getId()==id)
						.findFirst()
						.get();
	}
	
	public Customer save(Customer customer) {
		return customers.set(customers.indexOf(customer), customer);
	}

}
