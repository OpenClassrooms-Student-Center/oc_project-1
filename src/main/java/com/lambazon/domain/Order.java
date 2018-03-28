package com.lambazon.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Order {
	
	private Long id;
	private LocalDate createDate = LocalDate.now();
	private Customer customer;
	private HashSet<OrderedProduct> orderedProducts = new HashSet<>();
	
	public Order(Customer customer) {
		this.customer=customer;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public boolean addProduct(OrderedProduct product) {
		return orderedProducts.add(product);
	}

	public boolean remove(OrderedProduct product) {
		return orderedProducts.remove(product);
	}
	
	public Collection<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}
	
	
	public double getOrderTotalPrice() {
		return orderedProducts.stream()
							  .mapToDouble(o-> o.getOrderedQuantity()*o.getProduct().getPrice())
							  .sum();		
	}

}
