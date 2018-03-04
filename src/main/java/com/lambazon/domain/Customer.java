package com.lambazon.domain;

public class Customer {
	
	//----------
	//Properties
	//----------
	private Long id = System.nanoTime();
	private String name;
	
	// TODO You need to model and implement the following properties
	// 
	// shipping address
	// billing address
	// email
	// phone number
	// social security number (Consider how you are legally required to store this)  HINT: Look at com.lambazon.util.EncryptionUtility

	
	
	//------------
	//Constructors
	//------------
	public Customer(String name) {
		this.name=name;
	}

	
	//----------
	//Behaviors
	//----------
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	
	// TODO You need to write methods to allow the reading/writing of your new properties.  
}
