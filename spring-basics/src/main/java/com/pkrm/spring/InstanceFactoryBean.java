package com.pkrm.spring;

public class InstanceFactoryBean {
	private static InstanceFactoryBean instanceFactoryBean=null;
	public String welcomeMessage="Welcome to my world";
	
	private InstanceFactoryBean() {
	System.out.println(instanceFactoryBean+" instance");	
	}
	
	public InstanceFactoryBean createInstance() {
		instanceFactoryBean = new InstanceFactoryBean();
		return instanceFactoryBean;
	}

}
