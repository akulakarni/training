package com.pkrm.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pkrm.springmvc.model.Employee;
@Component
public class DaoImpl implements Dao{
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
     
	public Employee getEmployeeById(int id) {
  		String sql = "select * from viewemployees where emp_id="+id;
  	
  		return jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
			public Employee mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
				final Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setSalary(resultSet.getInt(3));
				employee.setDesignation(resultSet.getString(4));
			
				return employee;
			}
		});
  		}
  	public void deleteEmployee(int id) {
  		String sql = "delete from viewemployees where emp_id = " +id;
  		jdbcTemplate.update(sql);
		System.out.println("deleted person with userId=" + id);
	
  	}
  	public void updateEmployee(Employee employee) {
  		String sql = "update employeetable set id=?,name=? ,salary=?,designation=? where id =?";
  		jdbcTemplate.update(sql,
				new Object[] { employee.getId(),employee.getName(),employee.getSalary(),employee.getDesignation() });
		System.out.println("updated record for userId:" + employee.getId());
	
  	}


}
