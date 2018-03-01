																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.lambazon.domain.Product;


public class DomainTests {
	
//	@Test
//	public void test_minimum_quantity_validation_for_product() {
//		Product p = new Product(0, -5, 0, null, null);
//		assertThat(p.getQuantity()).isEqualTo(0);
//	}
//	
//	@Test
//	public void test_valid_quantity_validation_for_product() {
//		Product p = new Product(0, 50, 0, null, null);
//		assertThat(p.getQuantity()).isEqualTo(50);
//	}
//
//	@Test
//	public void test_minimum_price_validation_for_product() {
//		Product p = new Product(0, 50, 0, null, null);
//		assertThat(p.getPrice()).isEqualTo(0);
//	}
//
//	@Test
//	public void test_maximum_price_validation_for_product() {
//		Product p = new Product(0, 0, 1500, null, null);
//		assertThat(p.getPrice()).isEqualTo(1000);
//	}
//
//	@Test
//	public void test_valid_price_validation_for_product() {
//		Product p = new Product(0, 0, 1000, null, null);
//		assertThat(p.getPrice()).isEqualTo(1000);
//	}
}
