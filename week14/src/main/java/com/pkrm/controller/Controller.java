package com.pkrm.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.dao.PersonDao;
import com.pkrm.dao.PersonDaoImpl;
import com.pkrm.personPojo.Person;
import com.pkrm.service.Service;


@Path("/")
public class Controller {
	@Autowired
	public Service service;
	
	
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		//PersonDao personDaoImpl=context.getBean(PersonDaoImpl.class);
		List<Person> person=context.getBean(Service.class).getPersons();
		//List<Person> person=service.getPersons();
		//System.out.println(person);
		return Response.status(200).entity(person).build();
		
	}
	
	@GET
	@Path("/getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId")int userId) {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		//PersonDao personDaoImpl=(PersonDao) context.getBean("personDao");
		Person person=context.getBean(Service.class).getPerson(userId);
		return Response.status(200).entity(person).build();
		
	}
   
	
  @POST
  @Path("/addUser")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addUser(Person person) {
	  ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	 // PersonDao personDaoImpl=(PersonDao) context.getBean("personDao");
	  Person addPerson=context.getBean(Service.class).insertPerson(person);
	  System.out.println(person);
	  return Response.status(200).entity("new user inserted into database").build();
  }
  
  @POST
  @Path("/editUser")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response editUser(Person person) {
	  ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	 // PersonDao personDaoImpl=(PersonDao) context.getBean("personDao");
	  Person updatePerson=context.getBean(Service.class).editPerson(person);
	  return Response.status(200).entity("updated existing user").build();
  }
  
  @POST
  @Path("/deleteUser")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteUser(Person person) {
	  ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	 // PersonDao personDaoImpl=(PersonDao) context.getBean("personDao");
	  Person deletePerson=context.getBean(Service.class).deletePerson(person.getUserId());
	  return Response.status(200).entity("current user deleted").build();
  }
  
}
