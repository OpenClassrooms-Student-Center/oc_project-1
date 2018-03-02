package com.lambazon.domain;

public class Customer {
	
	private Long id = System.nanoTime();
	private String name;
	
	// TODO You need to model and implement the following properties
	// 
	// shipping address
	// billing address
	// email
	// phone number

	public Customer(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}
	
	// TODO You need to write get/set methods to allow the reading/writing of your new properties 
}
