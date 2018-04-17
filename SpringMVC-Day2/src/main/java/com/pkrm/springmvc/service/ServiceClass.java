package com.pkrm.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pkrm.springmvc.dao.DaoImpl;
import com.pkrm.springmvc.model.Employee;

@Service
public class ServiceClass {
	@Autowired
	private DaoImpl dao;
	
	public List<Employee> viewEmployees(){
		return dao.viewEmployees();
	}
	
	public Employee addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}
	
	public Employee getEmpById(int id) {
		Employee list= dao.getEmployeeById(id);
		Employee employee =list; 
		return employee;
	}

	public void deleteEmp(int id) {
		dao.deleteEmployee(id);
	}
	public void updateEmpById(Employee employee) {
		dao.updateEmployee(employee);
	}

}
