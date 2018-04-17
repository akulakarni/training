package com.pkrm.main;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.dao.EmployeeUsingJdbcTemplate;
import com.pkrm.model.Employee;



public class EmployeeMain {
	public static void main(final String[] args) throws SQLException {

        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("springAop.xml"); 
        final EmployeeUsingJdbcTemplate employeeDAOUsingJDBCTemplate = (EmployeeUsingJdbcTemplate) context
				.getBean("employeeDAOUsingJDBCTemplate");
        
      // final List<Employee> employees = employeeDAOUsingJDBCTemplate.getAllEmployees();
       employeeDAOUsingJDBCTemplate.getEmployee(4217);
        
      
	}
	

}
