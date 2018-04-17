package com.pkrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pkrm.DAO.EmployeeDAOUsingJdbcTemplate;
import com.pkrm.model.Employee;


public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAOUsingJdbcTemplate employeeDaoUsingJdbcTemplate;

	public List<Employee> getAllEmployees() {
	  return employeeDaoUsingJdbcTemplate.getAllEmployees();
	}

	public Employee createEmployee(Employee employee) {
		return employeeDaoUsingJdbcTemplate.createEmployee(employee);
		
	}

	public Employee updateEmployee(Employee employee) {
	    return employeeDaoUsingJdbcTemplate.updateEmployee(employee);
	
	}

	public Employee deleteEmployee(int emp_id) {
		return employeeDaoUsingJdbcTemplate.deleteEmployee(emp_id);
	
	}

	public Employee getEmployee(int emp_id) {
	    return employeeDaoUsingJdbcTemplate.getEmployee(emp_id);
	
	}

}
