package com.lambazon.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author stanlick
 *
 *   This class will demonstrate Integration Testing once learner has advanced to the TDD phase of the Java EE learning path
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {
	
	@Inject
	private TestRestTemplate restTemplate;

	@Test
	public void request_home() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void request_detail() {
		ResponseEntity<String> response = restTemplate.getForEntity("/products/1/details", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void request_list_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/api/products", String.class);
		assertThat(body).contains("{\"id\":2");
		
	}
	
	@Test
	public void request_product_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/api/products/{id}/details", String.class, 1);
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> products = parser.parseList("[" + body + "]");
		assertThat(products.size()).isEqualTo(1);
	}
}
