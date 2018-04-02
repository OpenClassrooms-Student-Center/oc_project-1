package com.lambazon.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private LocalDate createDate = LocalDate.now();
	
	@OneToOne
	private Customer customer;
	
	@OneToMany
	private Set<OrderedProduct> orderedProducts = new HashSet<>();
	
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
