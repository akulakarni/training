package com.pkrm.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pkrm.springmvc.dao.Dao;
import com.pkrm.springmvc.model.Employee;


public class ViewEmployeesController implements Controller {
	@Autowired
	Dao dao;

	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Employee employee= new Employee();
		  System.out.println(request.getParameter("id")+request.getParameter("name")+(request.getParameter("salary"))+request.getParameter("designation"));
				employee.setId(Integer.parseInt(request.getParameter("id")));
		        employee.setName(request.getParameter("name"));
				employee.setSalary(Integer.parseInt(request.getParameter("salary")));
				employee.setDesignation(request.getParameter("designation"));
				dao.addEmployee(employee);
				return new ModelAndView("ViewEmployees","employees",dao.viewEmployees());
			}
	
	}


