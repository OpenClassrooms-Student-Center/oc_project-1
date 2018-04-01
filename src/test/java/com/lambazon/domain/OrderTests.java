																																																		package com.lambazon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class OrderTests {
	
	
	private Customer customer;
	private Product aProduct;
	private Product bProduct;
	
	private OrderedProduct aOrderedProduct;
	private OrderedProduct bOrderedProduct;

	
	@Before
	public void beforeEachTest() {
		customer = new Customer("Tesla Motors");
		aProduct = new Product(10, 92.50, "Name", "Description");
		bProduct = new Product(20, 50.00, "Another Name", "Another Description");
		
		aOrderedProduct = new OrderedProduct(aProduct, 10);
		bOrderedProduct = new OrderedProduct(bProduct, 20);
	}
	
	
	@Test
	public void create_order_and_validate_customer() {
		Order o = new Order(customer);
		assertThat(o.getCustomer().getName()).isEqualTo("Tesla Motors");
	}

	
	@Test
	public void create_order_and_add_two_products() {
		Order o = new Order(customer);
		o.addProduct(aOrderedProduct);
		o.addProduct(bOrderedProduct);
		assertThat(o.getOrderedProducts()).contains(aOrderedProduct, bOrderedProduct);
	}
	
	@Test
	public void create_order_and_add_two_products_then_remove_product() {
		Order o = new Order(customer);
		o.addProduct(aOrderedProduct);
		o.addProduct(bOrderedProduct);
		o.remove(aOrderedProduct);
		assertThat(o.getOrderedProducts()).doesNotContain(aOrderedProduct);
		assertThat(o.getOrderedProducts()).contains(bOrderedProduct);
	}

	@Test
	public void create_order_and_add_two_products_then_request_total_price() {
		Order o = new Order(customer);
		o.addProduct(aOrderedProduct);
		o.addProduct(bOrderedProduct);
										//10*92.50 =  925
										//20*50.00 = 1000 
		assertThat(o.getOrderTotalPrice()).isEqualTo(1925);
	}
	
	@Test
	public void create_order_and_add_two_products_then_remove_product_then_request_total_price() {
		Order o = new Order(customer);
		o.addProduct(aOrderedProduct);
		o.addProduct(bOrderedProduct);
		o.remove(aOrderedProduct);
										//20*50.00 = 1000 
		assertThat(o.getOrderTotalPrice()).isEqualTo(1000);
	}
	
	@Test
	public void create_order_and_attemp_to_add_same_product_second_time_to_order_set() {
		Order o = new Order(customer);

		assertThat(o.addProduct(aOrderedProduct)).isTrue();
		assertThat(o.addProduct(aOrderedProduct)).isFalse();
	}
}
