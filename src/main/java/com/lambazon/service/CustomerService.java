package com.lambazon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lambazon.domain.Customer;
import com.lambazon.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Inject
	private CustomerRepository customerRepository;
	
	public List<Customer> customers() {
		return customerRepository.customers();
	}

	public Customer customer(Long id) {
		return customerRepository.customer(id);
	}
}
