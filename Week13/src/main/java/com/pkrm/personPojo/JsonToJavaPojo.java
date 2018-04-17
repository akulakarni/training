package com.pkrm.personPojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonToJavaPojo {
	@JsonProperty("person")
	Person person;
	@JsonProperty("roles")
	List<String> roles;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
/*	public HashSet<String> getRoles() {
		return roles;
	}
	public void setRoles(HashSet<String> roles) {
		this.roles = roles;
	}*/
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
 public String toString() {
	 return "Person:"+person.getUserId()+","+person.getUserName()+","+person.getFirstName()+","+person.getLastName()+","+roles.toString();
 }
 

}
