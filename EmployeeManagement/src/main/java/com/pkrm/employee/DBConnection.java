package com.pkrm.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection main() throws ClassNotFoundException  {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.203.151:1521:traindb", "akulakarni",
					"prokarma");
			System.out.println("connection established");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return connection;
	}
	}





