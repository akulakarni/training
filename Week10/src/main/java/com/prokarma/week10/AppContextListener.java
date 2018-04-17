package com.prokarma.week10;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
public class AppContextListener implements ServletContextListener {
	
	  public void contextInitialized(ServletContextEvent servletContextEvent)  { 
		  ServletContext ctx = servletContextEvent.getServletContext();
	    	
	    	//initialize DB Connection
	    	String dbURL = ctx.getInitParameter("dbURL");
	    	String user = ctx.getInitParameter("dbUser");
	    	String pwd = ctx.getInitParameter("dbPassword");
	    	try {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
				DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, pwd);
				ctx.setAttribute("DBManager", connectionManager);
				System.out.println("DB Connection initialized successfully.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
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

  

