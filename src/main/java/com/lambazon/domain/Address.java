package com.lambazon.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	
	public Address(){}
	
	public Address(String city){
		setCity(city);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
