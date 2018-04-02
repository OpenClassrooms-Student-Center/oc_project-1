package com.lambazon.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	//----------
	//Properties
	//----------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	// TODO You need to model and implement the following properties
	// 
	// shipping address
	@Embedded
	@AttributeOverrides( {
        @AttributeOverride(name="city", column = @Column(name="shipping_city") ),
        @AttributeOverride(name="state", column = @Column(name="shipping_state") ) 
	} )
	private Address shippingAddress;
	
	// billing address
	@Embedded
	@AttributeOverrides( {
        @AttributeOverride(name="city", column = @Column(name="billing_city") ),
        @AttributeOverride(name="state", column = @Column(name="billing_state") ) 
	} )
	private Address billingAddress;
	
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
		this.id=id;
	}

	public Long getId() {
		return id;
	}
	
	// TODO You need to write methods to allow the reading/writing of your new properties. 
	
	public String getShippingAddress() {
		// TODO Added to complete web page.  Replace with your implementation of Address
		return "123 Anywhere USA";
	}
	
	public String getPhoneNumber() {
		// TODO Added to complete web page.  Replace with your implementation of PhoneNumber
		return "(555)123-4567";
	}

	public void setShippingAddress(Address address) {
		this.shippingAddress=address;
	}
	public void setBillingAddress(Address address) {
		this.billingAddress=address;
	}

}
