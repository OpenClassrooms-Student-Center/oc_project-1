package com.lambazon.domain;

import java.util.Collection;
import java.util.HashSet;

public class Order {
	
	private Customer customer;
	private HashSet<Product> orderedProducts = new HashSet<>();
	
	public Order(Customer customer) {
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public boolean addProduct(Product product) {
		return orderedProducts.add(product);
	}

	public boolean remove(Product product) {
		return orderedProducts.remove(product);
	}
	
	public Collection<Product> getOrderedProducts() {
		return orderedProducts;
	}
	
	
	public double getOrderTotalPrice() {
		return orderedProducts.stream()
							  .mapToDouble(p-> p.getQuantity()*p.getPrice())
							  .sum();		
	}
}
