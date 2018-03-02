																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.lambazon.API;


public class ProductTests {
	
	@Test
	public void test_minimum_quantity_validation_for_product() {
		Product p = API.createProduct(0, -5, 0, null, null);
		assertThat(p.getQuantity()).isEqualTo(0);
	}
	
	@Test
	public void test_valid_quantity_validation_for_product() {
		Product p = API.createProduct(0, 50, 0, null, null);
		assertThat(p.getQuantity()).isEqualTo(50);
	}

	@Test
	public void test_minimum_price_validation_for_product() {
		Product p = API.createProduct(0, 50, 0, null, null);
		assertThat(p.getPrice()).isEqualTo(0);
	}

	@Test
	public void test_maximum_price_validation_for_product() {
		Product p = API.createProduct(0, 0, 1500, null, null);
		assertThat(p.getPrice()).isEqualTo(1000);
	}

	@Test
	public void test_valid_price_validation_for_product() {
		Product p = API.createProduct(0, 0, 1000, null, null);
		assertThat(p.getPrice()).isEqualTo(1000);
	}
}
