package com.pkrm.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.DAO.EmployeeDAOUsingJdbcTemplate;
import com.pkrm.model.Employee;



public class EmployeeMain {
	public static void main(final String[] args) throws SQLException {

        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
        final EmployeeDAOUsingJdbcTemplate employeeDAOUsingJDBCTemplate = (EmployeeDAOUsingJdbcTemplate) context
                .getBean("employeeDAOUsingJDBCTemplate");
      
      /* 
        Scanner sc=new Scanner(System.in);
        boolean con=true;
		int myChoice=0;
		
		do {
			System.out.println("CHOICES");
			System.out.println("1.Get all employees");
			System.out.println("2.Get employee");		
			System.out.println("3.Create Employee");
			System.out.println("4.Update Employee");
			System.out.println("5.Delete Employee");
			System.out.println("6.Exit");
			myChoice=sc.nextInt();
			switch(myChoice) {
			case 1:{
				final List<Employee> employees = employeeDAOUsingJDBCTemplate.getAllEmployees();
		        for (final Employee employee1 : employees) {
		            System.out.println(employee1);
		            con=true;
		            break;
		        }
			}
		    case 2:{
		    	System.out.println("enter the employee id of the employee");
	    	    //employee.setEmp_id(sc.nextInt());
		    	employeeDAOUsingJDBCTemplate.getEmployee(sc.nextInt());
		    	System.out.println(employee.toString());
		    	con=true;
		    	break;
		    }
		    case 3:{
		    	System.out.println("enter the name of the employee");
		    	employee.setEmp_name(sc.next());
		    	System.out.println("enter the id of the employee ");
		    	employee.setEmp_id(sc.nextInt());
		    	System.out.println("enter the age of the employee");
		    	employee.setEmp_age(sc.nextInt());
		    	System.out.println("enter the department id of the employee");
		    	employee.setDept_id(sc.nextInt());
		    	employeeDAOUsingJDBCTemplate.createEmployee(employee);
		    	con=true;
		    	break;
		    }
		    case 4:{
		    	System.out.println("enter the name of the employee");
		    	employee.setEmp_name(sc.next());
		    	System.out.println("enter the id of the employee");
		    	employee.setEmp_id(sc.nextInt());
		    	System.out.println("enter the age of the employee");
		    	employee.setEmp_age(sc.nextInt());
		    	System.out.println("enter the department of the employee");
		    	employee.setDept_id(sc.nextInt());
		    	employeeDAOUsingJDBCTemplate.updateEmployee(employee);
		    	con=true;
		    	break;
		    }
		    case 5:{
		    	System.out.println("enter the id of the employee");
		    	employee.setEmp_id(sc.nextInt());
		    	employeeDAOUsingJDBCTemplate.deleteEmployee(sc.nextInt());
		    	System.out.println(employee.toString());
		    	con=true;
		    	break;
		    }
		    case 6:{
		    	System.exit(0);
		    	con=false;
		    	break;
		    }
		    default:
		    	System.out.println("Invalid input");
		       
		    	
		    }
		
	}while(myChoice!=0);
}
}*/
      //---To get All Employees-------     
      final List<Employee> employees = employeeDAOUsingJDBCTemplate.getAllEmployees();
        for (final Employee employee1: employees) {
            System.out.println(employee1);
        }
      
        //-----Inserting Employee------
/*   Employee employee=new Employee();
        employee.setEmp_name("vishal");
        employee.setEmp_age(23);
        employee.setEmp_id(4330);
        employee.setDept_id(40);
       employeeDAOUsingJDBCTemplate.createEmployee(employee);
        System.out.println("inserted");
    	  */
        
        //------Update Employee---
        
     /* Employee employee1=new Employee();
        employee1.setEmp_name("karthik");
        employee1.setEmp_age(25);
        employee1.setDept_id(60);
        employee1.setEmp_id(4330);
        employeeDAOUsingJDBCTemplate.updateEmployee(employee1);
        System.out.println("updated");
       }*/
        
        //-----Delete Employee--------
	/*  Employee deletemployee=new Employee();
	  deletemployee.setEmp_id(4330);
	  employeeDAOUsingJDBCTemplate.deleteEmployee(4330);*/
        
        //-----Get Employee  
	/*  Employee getEmployee=employeeDAOUsingJDBCTemplate.getEmployee(4217);
	  System.out.println(getEmployee);
	} */
        
        
        //------Inserting using BatchUpdate--------
      /*Employee insertEmployee1=new Employee();
        insertEmployee1.setEmp_name("Ishika");
        insertEmployee1.setEmp_id(1);
        insertEmployee1.setEmp_age(20);
        insertEmployee1.setDept_id(70);

        Employee insertEmployee2=new Employee();
        insertEmployee2.setEmp_name("Rishika");
        insertEmployee2.setEmp_id(2);
        insertEmployee2.setEmp_age(21);
        insertEmployee2.setDept_id(80);
        
        Employee insertEmployee3=new Employee();
        insertEmployee3.setEmp_name("Rithika");
        insertEmployee3.setEmp_id(3);
        insertEmployee3.setEmp_age(22);
        insertEmployee3.setDept_id(90);
        
        
        List<Employee> listOfEmployees=new ArrayList<Employee>();
        listOfEmployees.add(insertEmployee1);
        listOfEmployees.add(insertEmployee2);
        listOfEmployees.add(insertEmployee3);
        
        
        employeeDAOUsingJDBCTemplate.insertBatch(listOfEmployees);
        
        System.out.println("inserted");*/
	}
}

