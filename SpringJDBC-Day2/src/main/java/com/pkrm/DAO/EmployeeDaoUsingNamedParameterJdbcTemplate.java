package com.pkrm.DAO;

import java.util.List;

import com.pkrm.model.Employee;

public interface EmployeeDaoUsingNamedParameterJdbcTemplate {
	List<Employee> getAllEmployees();
	
	Employee getEmployee(int emp_id);
	
	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee deleteEmployee(int emp_id);



}
