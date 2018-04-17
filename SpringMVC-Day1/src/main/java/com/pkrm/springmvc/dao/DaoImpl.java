package com.pkrm.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pkrm.springmvc.model.Employee;


public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public Employee addEmployee(Employee employee) {
		String sql="insert into viewemployees values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {employee.getId(),employee.getName(),employee.getSalary(),employee.getDesignation()});
		return employee;			
	}
	
      public List<Employee> viewEmployees() {
		
		return jdbcTemplate.query("select * from viewemployees", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				employee.setDesignation(rs.getString(4));
				return employee;
			}
			
		});
	}

}
