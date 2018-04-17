package com.pkrm.DAO;

import java.util.List;

import com.pkrm.model.Employee;


public interface EmployeeDAOUsingJdbcTemplate {
	List<Employee> getAllEmployees();

	Employee getEmployee(int emp_id);

	List<Employee> getEmployeeUsingBeanPropertyRowMapper();

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee deleteEmployee(int emp_id);
	
	Employee insertBatch(List<Employee> employees);

}
