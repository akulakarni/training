package com.prokarma.dao;

import java.util.List;

import com.prokarma.pojo.Employee;

public interface Dao {
public void addUser(Employee employee);
public List<Employee> allUsers();
}
