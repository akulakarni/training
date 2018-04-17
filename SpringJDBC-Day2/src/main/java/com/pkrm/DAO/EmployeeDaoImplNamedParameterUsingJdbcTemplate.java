package com.pkrm.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.pkrm.model.Employee;
import com.pkrm.sql.EmployeeSQL;

public class EmployeeDaoImplNamedParameterUsingJdbcTemplate implements EmployeeDaoUsingNamedParameterJdbcTemplate {
	  @Autowired
	    private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	  @Autowired
	    private EmployeeRowMapper employeeRowMapper;
	  
	public List<Employee> getAllEmployees(){
		  final String sql = "Select * from Employee";
	        final List<Employee> employees = namedParameterJdbcTemplate.query(sql, new RowMapper<Employee>() {
	            public Employee mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	                Employee employee = new Employee();
	                employee.setEmp_name(resultSet.getString("emp_name"));
	                employee.setEmp_id(resultSet.getInt("emp_id"));
	                employee.setEmp_age(resultSet.getInt("emp_age"));
	                employee.setDept_id(resultSet.getInt("dept_id"));
	                return employee;
	            }
	        });
	        return employees;
	
		
	}
	

	
	public Employee getEmployee(int emp_id) {
		
		  final String sql = EmployeeSQL.GET_EMPLOYEE;
	        final MapSqlParameterSource params = new MapSqlParameterSource();
	        params.addValue("emp_id", emp_id);
	        return namedParameterJdbcTemplate.queryForObject(sql, params,  employeeRowMapper);
	}
	
	



	public Employee createEmployee(Employee employee) {

	           
			 final String sql = EmployeeSQL.CREATE_EMPLOYEE;
		        final MapSqlParameterSource params = new MapSqlParameterSource();
		        params.addValue("emp_name", employee.getEmp_name());
		        params.addValue("emp_id", employee.getEmp_id());
		        params.addValue("emp_age", employee.getEmp_age());
		        params.addValue("dep_id", employee.getDept_id());
		     
		        final int i = namedParameterJdbcTemplate.update(sql, params);
		        if (i == 0) {
		           
		            System.out.println("Failed to insert Record for Name = " + employee.getEmp_name() + " Age = " + employee.getEmp_age());// dont use sysout
		        }
		        System.out.println("Created Record for Name = " + employee.getEmp_name() + " Age = " + employee.getEmp_age());// dont use sysout
		        return null;
	    }
	

	public Employee updateEmployee(Employee employee) {
		 final String sql = EmployeeSQL.UPDATE_EMPLOYEE;
	        final MapSqlParameterSource params = new MapSqlParameterSource();
	        params.addValue("emp_name", employee.getEmp_name());
	        params.addValue("emp_id", employee.getEmp_id());
	        params.addValue("emp_age", employee.getEmp_age());
	        params.addValue("dept_id", employee.getDept_id());
	      
	        final int i = namedParameterJdbcTemplate.update(sql, params);
	        if (i == 0) {
	    
	            System.out.println("Failed to update Record for Name = " + employee.getEmp_name() + " Age = " +  employee.getEmp_id());// dont use sysout
	        }
	        System.out.println("updated Record for Name = " + employee.getEmp_name() + " Age = " + employee.getEmp_id());// dont use sysout
	        return null;

	
	}

	public Employee deleteEmployee(int emp_id) {
		 final String sql = EmployeeSQL.DELETE_EMPLOYEE;
	        final MapSqlParameterSource params = new MapSqlParameterSource();
	        params.addValue("emp_id", emp_id);
	        final int i = namedParameterJdbcTemplate.update(sql, params);
	        if (i == 0) {
	           
	            System.out.println("Failed to delete Record for employee with id = " + emp_id);
	        }
	        System.out.println("Deleted Record for employee with id = " + emp_id);

	        return null;
	    }
		
	
	}


