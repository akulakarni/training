package com.pkrm.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.pkrm.model.Employee;
import com.pkrm.sql.EmployeeSQL;

public class EmployeeDAOImplUsingJdbcTemplate implements EmployeeDAOUsingJdbcTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> getAllEmployees(){
		  final String sql = "Select * from Employee";
	        final List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
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
		return employee;
	}
	
	

	public List<Employee> getEmployeeUsingBeanPropertyRowMapper() {
		  final String sql = EmployeeSQL.GET_ALL_EMPLOYEES;
	       
	        final List<Employee> players = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	        return players;
		
	}

	public Employee createEmployee(Employee employee) {
		 try {
	           
	            final String sql = "insert into Employee  values (?,?,?,?)";
	            jdbcTemplate.update(
	                    sql,
	                    new Object[]{employee.getEmp_name(), employee.getEmp_id(),employee.getEmp_age(),employee.getDept_id()});
	            System.out.println("Created Record for Name = " + employee.getEmp_name() + " Age = " + employee.getEmp_age());
	        } catch (final DataAccessException exp) {
	            exp.printStackTrace();
	            System.err.println("Exception occured" + exp);
	        }
	        return null;
	    }
	

	public Employee updateEmployee(Employee employee) {
		  try {
	            final String sql = "update Employee set emp_name= ?, emp_id=?, emp_age= ?, dept_id= ? where emp_id=?";
	            jdbcTemplate.update(
	                    sql,
	                    new Object[]{employee.getEmp_name(),employee.getEmp_id(),employee.getEmp_age(),employee.getDept_id(),employee.getEmp_id()});
	            System.out.println("Update Record for Name = " + employee.getEmp_name()+ " Age = " + employee.getEmp_age());
	        } catch (final DataAccessException exp) {
	            
	            exp.printStackTrace();
	            System.err.println("Exception occured" + exp);
	        }
	        return null;

	
	}

	public Employee deleteEmployee(int emp_id) {
		  try {
	            final String sql = "delete from Employee where emp_id = ?";
	            jdbcTemplate.update(sql, new Object[]{emp_id});
	            System.out.println("Deleted Record for employee with emp_id = " + emp_id);
	        } catch (final DataAccessException exp) {
	     
	            exp.printStackTrace();
	            System.err.println("Exception occured" + exp);
	        }
		
		return null;
	}


	public Employee insertBatch(final List<Employee> employees) {
		  String sql = "insert into Employee values (?, ?, ?,?)";
		  
			List<Object[]> parameters = new ArrayList<Object[]>();

			for (Employee employee : employees) {
		        parameters.add(new Object[] {employee.getEmp_name(),employee.getEmp_id(),employee.getEmp_age(),employee.getDept_id()}
		        );
		    }
			//one way of doing...
		    jdbcTemplate.batchUpdate(sql, parameters);
		    
		    //The other way of doing it...
		    jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Employee employee = new Employee();
					ps.setString(1,employees.get(i).getEmp_name());
					ps.setInt(2, employees.get(i).getEmp_id());
					ps.setInt(3, employees.get(i).getEmp_age());
					ps.setInt(4, employees.get(i).getDept_id())					
				}
				
				public int getBatchSize() {
					return employees.size();
				}
			});
		
			  
return null;
}
}

