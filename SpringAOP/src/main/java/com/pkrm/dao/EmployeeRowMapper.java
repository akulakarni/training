package com.pkrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pkrm.model.Employee;

public class EmployeeRowMapper implements RowMapper {
	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		 final Employee employee = new Employee();
		 employee.setEmp_name(resultSet.getString("emp_name"));
		 employee.setEmp_id(resultSet.getInt("emp_id"));
		 employee.setEmp_age(resultSet.getInt("emp_age"));
		 employee.setDept_id(resultSet.getInt("dept_id"));
	        return employee;

	}

	

}
