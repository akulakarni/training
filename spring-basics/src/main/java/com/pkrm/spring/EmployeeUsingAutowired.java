package com.pkrm.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeUsingAutowired {
	
	@Autowired
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
 public EmployeeUsingAutowired() {
	 
 }
 
 public EmployeeUsingAutowired(Address address) {
	 this.address=address;
 }
 
 public void employee() {
	 System.out.println(address.myAddress);
 }
}
