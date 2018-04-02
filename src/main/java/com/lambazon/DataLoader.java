package com.lambazon;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

import com.lambazon.domain.Address;
import com.lambazon.domain.Customer;


@Configuration
public class DataLoader {

	
	// Initialize database

	@Inject
	API api;

	@PostConstruct
	public void init() {
		api.deleteAll();
		populateCustomers();
		populateProducts();
	}

	private void populateProducts() {
		api.createProduct(10, 92.50, "Echo Dot", "(2nd Generation) - Black");
		api.createProduct(20, 9.99, "Anker 3ft / 0.9m Nylon Braided", "Tangle-Free Micro USB Cable");
		api.createProduct(30, 69.99, "JVC HAFX8R Headphone", "Riptidz, In-Ear");
		api.createProduct(40, 32.50, "VTech CS6114 DECT 6.0", "Cordless Phone");
		api.createProduct(50, 895.00, "NOKIA OEM BL-5J", "Cell Phone");
	}
	
	
	
	
	/**
	 * 
	 *   THIS IS WHERE YOU WILL CREATE INSTANCES OF YOUR NEWLY REMODELED CUSTOMER CLASSES! 
	 * 
	 */

	private void populateCustomers() {
		Customer customer = api.createCustomer("Donald Trump");
		customer.setShippingAddress(new Address("1600 Pennsylvania Ave NW"));
		customer.setBillingAddress(new Address("Billing Address"));
		// customer.setPhoneNumber(...);
		// set remaining required properties
		api.updateCustomer(customer);
		
		customer = api.createCustomer("Scott Stanlick");
		customer.setShippingAddress(new Address("516 West Antelope"));
		customer.setBillingAddress(new Address("Billing Address"));
		// customer.setPhoneNumber(...);
		// set remaining required properties
		api.updateCustomer(customer);
	}
     

	
}
