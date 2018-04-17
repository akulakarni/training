package com.pkrm.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pkrm.springmvc.model.Employee;
@Component
public interface Dao {
	public Employee addEmployee(Employee employee);
	 public List<Employee> viewEmployees();
	 public Employee getEmployeeById(int id);
	 public void deleteEmployee(int id);
	 public void updateEmployee(Employee employee);
		

}
