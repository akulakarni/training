package com.pkrm.jms;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ContextListener implements ServletContextListener {

   
    public ContextListener() {

    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
       AbstractApplicationContext context=(AbstractApplicationContext) sce.getServletContext().getAttribute("name");
       context.close();
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
       AbstractApplicationContext context=new ClassPathXmlApplicationContext("jmsContext.xml");
      sce.getServletContext().setAttribute("name",context);
    }
	
}
