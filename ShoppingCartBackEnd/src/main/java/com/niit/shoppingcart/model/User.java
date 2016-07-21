package com.niit.shoppingcart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;
import org.springframework.stereotype.Component;
@Entity

@Component
public class User {
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress() {
		return address;	
}
}
