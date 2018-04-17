package com.pkrm.dao;

import java.util.List;

import com.pkrm.model.Employee;

public interface EmployeeUsingJdbcTemplate {
	List<Employee> getAllEmployees();
	Employee getEmployee(int emp_id);

}
