package com.pkrm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext springContext=new ClassPathXmlApplicationContext("application-beans.xml");
		
		  //springContext.getBean(MyBean.class);
		/*  
		  NewBean newBean=springContext.getBean(NewBean.class);
		  System.out.println(newBean.toString());
		  
		  NewBean newBean1=springContext.getBean(NewBean.class);
		  System.out.println(newBean1.toString());*/
	/*	MyBean myBean= springContext.getBean(MyBean.class);
		myBean.sayHello();*/
		/*AbstractClass abstractClass=(AbstractClass) springContext.getBean("myAbstract");
		abstractClass.displayName();
		*/
		/*MyAbstract myAbstract=(MyAbstract) springContext.getBean("myAbstract");
		myAbstract.displayName();*/
		/*StaticFactoryBean staticFactoryBean= (StaticFactoryBean) springContext.getBean("abc");
		System.out.println(staticFactoryBean);
		
		InstanceFactoryBean instanceFactoryBean= (InstanceFactoryBean) springContext.getBean("instanceFactoryBean");
		System.out.println(instanceFactoryBean);
		
		StaticFactoryBean staticFactoryBean1= (StaticFactoryBean) springContext.getBean("abc");
		System.out.println(staticFactoryBean1);
		
		InstanceFactoryBean instanceFactoryBean1= (InstanceFactoryBean) springContext.getBean("instanceFactoryBean");
		System.out.println(instanceFactoryBean1);*/
		
	    // springContext.getBean(EmployeeUsingAutowired.class).employee();
		
	}

}
