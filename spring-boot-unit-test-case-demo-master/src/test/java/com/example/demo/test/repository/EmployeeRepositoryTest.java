package com.example.demo.test.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.SpringBootUnitTestCaseDemoApplication;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=SpringBootUnitTestCaseDemoApplication.class)
//@ContextConfiguration("spring.xml")//if we are using xml based 
public class EmployeeRepositoryTest {
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
		Employee alex=new Employee();
		alex.setId(1l);
		alex.setName("alex");
		employeeRepository.saveAndFlush(alex);
		
		Employee found=employeeRepository.findByName(alex.getName());
		
		assertEquals(found.getName(),"alex");
	}
}
