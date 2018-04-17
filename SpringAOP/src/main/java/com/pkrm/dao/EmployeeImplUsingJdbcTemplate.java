package com.pkrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pkrm.model.Employee;

public class EmployeeImplUsingJdbcTemplate implements EmployeeUsingJdbcTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> getAllEmployees() {
		  final String sql = "Select * from Employee";
	        final List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
	            public Employee mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	                Employee employee = new Employee();
	                employee.setEmp_name(resultSet.getString("emp_name"));
	                employee.setEmp_id(resultSet.getInt("emp_id"));
	                employee.setEmp_age(resultSet.getInt("emp_age"));
	                employee.setDept_id(resultSet.getInt("dept_id"));
	                //System.out.println(resultSet.getInt("emp_id"));
	                return employee;
	            }
	        });
	        System.out.println(employees);
	        return employees;

	}

	public Employee getEmployee(int emp_id) {
		  String sql = "Select * from Employee where emp_id =" + emp_id;
		   Employee employee = jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
	

	            public Employee mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	                final Employee employee = new Employee();
	                employee.setEmp_name(resultSet.getString("emp_name"));
	                employee.setEmp_id(resultSet.getInt("emp_id"));
	                employee.setEmp_age(resultSet.getInt("emp_age"));
	                employee.setDept_id(resultSet.getInt("dept_id"));
	                return employee;
	            } 
	        });
		   System.out.println(employee);
		return employee;
	
	}

}
