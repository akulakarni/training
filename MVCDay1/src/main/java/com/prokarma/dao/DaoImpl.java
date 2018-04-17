package com.prokarma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.prokarma.pojo.Employee;

public class DaoImpl implements Dao{
@Autowired
JdbcTemplate jdbcTemplate;
	
	public void addUser(Employee employee) {
		jdbcTemplate.update("insert into allemployees values(?,?,?)",new Object[] {employee.getName(),employee.getSalary(),employee.getDesignation()});
		
	}

	public List<Employee> allUsers() {
		
		return jdbcTemplate.query("select * from allemployees", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee employee=new Employee();
				employee.setName(rs.getString(1));
				employee.setSalary(rs.getInt(2));
				employee.setDesignation(rs.getString(3));
				return employee;
			}
			
		});
	}

}
