package com.prokarma.week11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	/*public String dbURL;
	public String user;
	public String password;*/
	private Connection connection;

	public DBConnectionManager(String dbUrl, String user, String password) throws ClassNotFoundException {
		super();
		/*this.dbURL = dbUrl;
		this.user = user;
		this.password = password;
	*/

	connection=null;
	try { 
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  connection= DriverManager.getConnection(dbUrl, user, password);
	  System.out.println("Connection established");
	  connection.setAutoCommit(false);
	}
	catch(SQLException e) {
		System.out.println("Connection failed!");
		e.printStackTrace();
	}
	 
	 }
	 

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
		System.out.println("Connection closed");
	}
}
