package com.pkrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pkrm.dao.PersonDaoImpl;
import com.pkrm.personPojo.Person;

@Component
public class Service {
	
	@Autowired
	public PersonDaoImpl personDaoImpl;
	
	public List<Person> getPersons(){
		return personDaoImpl.getUsers();
		
	}
	
	public Person getPerson(int userId) {
		return personDaoImpl.getUser(userId);
		
	}
	
	public Person insertPerson(Person person) {
		return personDaoImpl.addUser(person);

}
	public Person editPerson(Person person) {
		return personDaoImpl.editUser(person);
		
	}
	
	public Person deletePerson(int userId) {
		return personDaoImpl.deleteuser(userId);
	}
}
