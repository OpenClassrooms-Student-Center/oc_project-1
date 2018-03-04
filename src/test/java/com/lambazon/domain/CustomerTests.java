																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.lambazon.API;


public class CustomerTests {
	

	
	
	@Test
	public void create_order_and_validate_customer() {
		Customer c = API.createCustomer("Tesla Motors");
		Order o = API.createOrder(c);
		assertThat(o.getCustomer().getName()).isEqualTo("Tesla Motors");
	}


}
