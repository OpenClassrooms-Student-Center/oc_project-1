																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.lambazon.API;


public class CustomerTests {
	
	@Test
	public void create_and_validate_customer() {
		Customer c = API.createCustomer("Tesla Motors");
		assertThat(c.getName()).isEqualTo("Tesla Motors");
	}


}
