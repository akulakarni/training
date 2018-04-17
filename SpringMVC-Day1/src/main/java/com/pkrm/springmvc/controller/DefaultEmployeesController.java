package com.pkrm.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pkrm.springmvc.dao.Dao;

public class DefaultEmployeesController implements Controller{
	@Autowired
	Dao dao;

	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		return new ModelAndView("ViewEmployees","employees",dao.viewEmployees());
	}

}
