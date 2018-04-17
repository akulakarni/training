package com.pkrm.dao;

import java.util.List;

import com.pkrm.personPojo.Person;

;

public interface PersonDao {
	public Person addUser(Person person); 
	public Person editUser(Person person);
	public Person deleteuser(int userId);
	public List<Person> getUsers();
	public Person getUser(int userId);
}
