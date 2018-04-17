package com.prokarma.mvccontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.prokarma.dao.Dao;
import com.prokarma.pojo.Employee;

public class AllUsers implements Controller{
@Autowired
Dao daoimpl;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Employee emp= new Employee();
  System.out.println(request.getParameter("name")+(request.getParameter("salary"))+request.getParameter("designation"));
		emp.setName(request.getParameter("name"));
		emp.setSalary(Integer.parseInt(request.getParameter("salary")));
		emp.setDesignation(request.getParameter("designation"));
		daoimpl.addUser(emp);
		return new ModelAndView("empList","employees",daoimpl.allUsers());
	}

}
