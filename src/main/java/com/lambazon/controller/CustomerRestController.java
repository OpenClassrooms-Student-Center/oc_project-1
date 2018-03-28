package com.lambazon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.lambazon.domain.Customer;
import com.lambazon.service.CustomerService;

@Controller
public class CustomerRestController {

	@Inject
	private CustomerService customerService;
	@GetMapping("rest/customers/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Long id) {
		Customer customer = customerService.customer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("rest/customers")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list = customerService.customers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@PostMapping("rest/customers")
	public ResponseEntity<Void> add(@RequestBody Customer customer, UriComponentsBuilder builder) {
		customer = customerService.create(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("rest/customers")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		customerService.update(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping("rest/customers/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		customerService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("rest/customers/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		customerService.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
