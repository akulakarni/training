package com.prokarma.week11;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prokarma.week11.DBConnectionManager;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */

public class AppContextListener implements ServletContextListener {
	
	  public void contextInitialized(ServletContextEvent servletContextEvent)  { 
		  ServletContext ctx = servletContextEvent.getServletContext();
	    	
		  ApplicationContext context  = new ClassPathXmlApplicationContext("week.xml");
			DBConnectionManager dbConnectionManager= (DBConnectionManager) context.getBean("dbonnection");	    		
					ctx.setAttribute("DBManager", dbConnectionManager);
					System.out.println("DB Connection initialized successfully.");
	    }
	        
	    
		
   
    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    	ServletContext ctx = servletContextEvent.getServletContext();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
    	try {
			dbManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println("Database connection closed for Application.");
    }
   
    }

  

