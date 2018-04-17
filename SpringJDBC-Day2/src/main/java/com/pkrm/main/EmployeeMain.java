package com.pkrm.main;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.DAO.EmployeeDaoUsingNamedParameterJdbcTemplate;
import com.pkrm.model.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		
	
	   final AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       

       
       final EmployeeDaoUsingNamedParameterJdbcTemplate employeeDAOUsingNamedParameterJDBCTemplate = (EmployeeDaoUsingNamedParameterJdbcTemplate) context
               .getBean("employeeDAOUsingNamedParameterJDBCTemplate");

     /* final List<Employee> employees = employeeDAOUsingJDBCTemplate.getAllEmployees();
       for (final Employee employee : employees) {
           System.out.println(employee);
       }*/
       
/*        Employee employee=new Employee();
       employee.setEmp_name("vishal");
       employee.setEmp_age(23);
       employee.setEmp_id(4330);
       employee.setDept_id(40);*/
      /* employeeDAOUsingJDBCTemplate.createEmployee(employee);
       System.out.println("inserted");*/
   	  
       
    /*   Employee employee1=new Employee();
       employee1.setEmp_name("karthik");
       employee1.setEmp_age(25);
       employee1.setDept_id(60);
       employee1.setEmp_id(4330);
       employeeDAOUsingJDBCTemplate.updateEmployee(employee1);
       System.out.println("updated");
      }*/
	/*  Employee deletemployee=new Employee();
	  deletemployee.setEmp_id(4330);*/
       employeeDAOUsingNamedParameterJDBCTemplate.deleteEmployee(4218);
	  
	  Employee getEmployee=employeeDAOUsingNamedParameterJDBCTemplate.getEmployee(4217);
	  System.out.println(getEmployee);
	} 
}

