package com.pkrm.spring;

public class MyBean {
	private String name1;
	//private int number;
	
	public MyBean(String name) {
		this.name1=name1;
		//this.number=number;
		
		
	}
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}*/
	/*public MyBean(Day day) {
	
		day.getDate();
	}*/
	public void sayHello() {
		System.out.println(name1);
		//System.out.println(number);
	}

}
