package com.pkrm.springmvc.dao;

import java.util.List;

import com.pkrm.springmvc.model.Employee;

public interface Dao {
	public Employee addEmployee(Employee employee);
	 public List<Employee> viewEmployees();
		
	

}
