package com.pkrm.service;

import java.util.List;

import com.pkrm.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee deleteEmployee(int emp_id);
	Employee getEmployee(int emp_id);
 
}
