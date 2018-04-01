package com.lambazon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Product product;
	
	private int orderedQuantity;

	public OrderedProduct(Product product, int orderedQuantity) {
		this.product=product;
		this.orderedQuantity=orderedQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	
	
}
