package com.pkrm.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pkrm.springmvc.dao.Dao;
import com.pkrm.springmvc.model.Employee;
import com.pkrm.springmvc.service.ServiceClass;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private ServiceClass service;
	
	@RequestMapping("/")
	public ModelAndView EmployeeMenu() {		
		return new  ModelAndView("welcome");
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee() {		
		return new  ModelAndView("AddEmployee","emp",new Employee());
	}
	@RequestMapping("/viewEmployees")
	public ModelAndView viewEmployees(){
		List<Employee> list=service.viewEmployees();
		return new ModelAndView("ViewEmployees","list",list);
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.addEmployee(employee);
		return new ModelAndView("redirect:/viewEmployees");
	}
	@RequestMapping(value="/getEmp/{id}")  
    public ModelAndView getEmpById(@PathVariable int id){  
		Employee employee=service.getEmpById(id);   
        return new ModelAndView("updateEmployee","command",employee);  
    } 
	@RequestMapping(value="/deleteEmp/{id}")  
    public ModelAndView deleteEmp(@PathVariable int id){  
		service.deleteEmp(id);
		return new ModelAndView("redirect:/viewEmployees");
    }
	
	
	@RequestMapping(value="/getEmp/update",method=RequestMethod.POST)  
    public ModelAndView editEmp(@ModelAttribute("employee") Employee employee){  
		service.updateEmpById(employee);
		return new ModelAndView("redirect:/viewEmployees");
    }
	
	

}
