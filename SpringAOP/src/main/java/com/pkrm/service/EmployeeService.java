package com.pkrm.service;

import java.util.List;

import com.pkrm.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployee(int emp_id);

}
