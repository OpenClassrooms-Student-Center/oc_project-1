package com.lambazon.controller;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lambazon.domain.Customer;

public class CustomerControllerIntegrationTests {

	HttpHeaders headers;
	RestTemplate restTemplate;
	String CUSTOMERS = "http://localhost:8080/rest/customers";
	
	
	@Before
	public void beforeEach() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		restTemplate = new RestTemplate();
		clear();
	}
	
	@Test
	public void database_should_be_empty() {
		assertThat(getAll(), is(empty()));
	}	
	
	@Test
	public void add_new_customer_followed_by_findById() {
		URI uri = add(new Customer("Scott Stanlick"));
		long id = extractIdFromPath(uri);
		Customer customer = getById(id);
		assertNotNull(customer);
		assertThat(customer.getName(), is(equalTo("Scott Stanlick")));
	}
	
	@Test
	public void add_10_new_customers_and_query_all() {
		for (int i = 0; i < 10; i++) {
			URI uri = add(new Customer("Scott Stanlick " + i));
		}
		assertThat(getAll().size(), is(10));
	}	
	
	
	
	
	


	public Customer getById(long id) {
		String url = CUSTOMERS+"/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,	Customer.class, id);
		Customer customer = responseEntity.getBody();
		return customer;
	}


	public List<Customer> getAll() {
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(CUSTOMERS, HttpMethod.GET, requestEntity,Customer[].class);
		return Arrays.asList(responseEntity.getBody());
	}


	public URI add(Customer customer) {
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, headers);
		URI uri = restTemplate.postForLocation(CUSTOMERS, requestEntity);
		return uri;
	}

	public void update(Customer customer) {
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, headers);
		restTemplate.put(CUSTOMERS, requestEntity);
	}

	public void delete(long id) {
		String url = CUSTOMERS+"/{id}";
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);
	}
	
	public void clear() {
		String url = CUSTOMERS+"/deleteAll";
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class);
	}
	
	public long extractIdFromPath(URI uri) {
		String[] segments = uri.getPath().split("/");
		String idStr = segments[segments.length-1];
		return Long.parseLong(idStr);
	}

}
