																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class CustomerTests {
	
	@Test
	public void create_and_validate_customer() {
		Customer c = new Customer("Tesla Motors");
		assertThat(c.getName()).isEqualTo("Tesla Motors");
	}


}
