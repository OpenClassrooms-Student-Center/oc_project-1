package com.lambazon.domain;

public class OrderedProduct {

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
