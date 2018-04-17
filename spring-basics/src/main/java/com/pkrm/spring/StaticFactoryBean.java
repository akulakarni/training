package com.pkrm.spring;

public class StaticFactoryBean {
	private static StaticFactoryBean staticFactoryBean=null;
	public String name="Welcome to my world";
	
	private StaticFactoryBean() {
		System.out.println(staticFactoryBean+" static");
	}
	
	public static StaticFactoryBean createInstance() {
		staticFactoryBean=new StaticFactoryBean();
		return staticFactoryBean;
	}

}
