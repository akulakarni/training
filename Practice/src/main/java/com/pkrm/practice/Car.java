package com.pkrm.practice;

public class Car {
	public static Car car=new Car();
 public static String name;
 
 
 
 public static Car myCar() {
	 if(name=="Audi") {
		 Car audi=new Audi();
		
	 }
	                                                   
	else if(name=="Hyundai") {
		Car hyundai=new Hyundai();
	}
	 return car;  
	}
 }

