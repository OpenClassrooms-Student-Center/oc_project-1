package com.lambazon;

import com.lambazon.domain.Customer;
import com.lambazon.domain.Order;
import com.lambazon.domain.Product;

public class API {

	/**
	 * 
	 * Create a Customer with given argument
	 * 
	 * @param name
	 * @return Customer
	 */
	public static Customer createCustomer(String name) {
		return new Customer(name);
	}

	/**
	 * 
	 * Create a Product with given arguments
	 * 
	 * @param id
	 * @param quantity
	 * @param price
	 * @param name
	 * @param description
	 * @return Product
	 */
	public static Product createProduct(long id, int quantity, double price, String name, String description) {
		return new Product(id, quantity, price, name, description);
	}

	/**
	 * 
	 * Create an Order given argument
	 * 
	 * @param customer
	 * @return Order
	 */

	public static Order createOrder(Customer customer) {
		return new Order(customer);
	}

}
