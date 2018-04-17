package com.pkrm.model;

public class Employee {
	public String emp_name;
	public int emp_id;
	public int emp_age;
	public int dept_id;
	
	/*public Employee(String emp_name, int emp_id, int emp_age, int dept_id) {
		this.emp_name=emp_name;
		this.emp_id=emp_id;
		this.emp_age=emp_age;
		this.dept_id=dept_id;
	}
	*/
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
   
	public String toString() {
		return "employeeName:"+emp_name+",employeeAge:"+emp_age+",employeeId:"+emp_id+",departmentId:"+dept_id+"";
		
	}
	

}
