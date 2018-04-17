package com.pkrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.pkrm.dao.EmployeeUsingJdbcTemplate;
import com.pkrm.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeUsingJdbcTemplate employeeDaoUsingJdbcTemplate;

	public List<Employee> getAllEmployees() {

		return employeeDaoUsingJdbcTemplate.getAllEmployees();
	}

	public Employee getEmployee(int emp_id) {
		
		return employeeDaoUsingJdbcTemplate.getEmployee(emp_id);
	}

}
