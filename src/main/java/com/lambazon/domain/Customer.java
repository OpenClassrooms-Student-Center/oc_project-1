package com.lambazon.domain;

public class Customer {
	
	//----------
	//Properties
	//----------
	private Long id;
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
	public Customer() {
		super();
	}
	
	public Customer(String name) {
		this.name=name;
	}

	
	//----------
	//Behaviors
	//----------
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id=id;;
	}

	public Long getId() {
		return id;
	}
	
	// TODO You need to write methods to allow the reading/writing of your new properties. 
	
	public String getAddress() {
		// TODO Added to complete web page.  Replace with your implementation of Address
		return "123 Anywhere USA";
	}
	
	public String getPhoneNumber() {
		// TODO Added to complete web page.  Replace with your implementation of PhoneNumber
		return "(555)123-4567";
	}

}
