package com.pkrm.personPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	@JsonProperty("userId")
	public int userId;
	@JsonProperty("userName")
	public String userName;
	@JsonProperty("firstName")
	public String firstName;
	@JsonProperty("lastName")
	public String lastName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
