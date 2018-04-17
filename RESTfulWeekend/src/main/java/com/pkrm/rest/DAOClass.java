package com.pkrm.rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOClass {
	public int insertPerson(Connection connection,String name,int age) throws SQLException {
		
		CallableStatement call1 = connection.prepareCall("{call person_1(?,?)}");
		
		call1.setString(1, name);
		call1.setInt(2, age);
		call1.execute();
	
		Statement statement2 = connection.createStatement();
		ResultSet resultSet2 = statement2
				.executeQuery("select * from prsn where prsn_name='" + name + "' and prsn_age=" + age);

		int personid = 0;
		while (resultSet2.next()) {
			personid = resultSet2.getInt(2);
		} return personid;
	}
	
	public int insertMainTask(Connection connection,String maintasktitle,String maintaskdescription,int personid) throws SQLException {
	CallableStatement call2 = connection.prepareCall("{call maintask_1(?,?,?)}");
	call2.setString(1, maintasktitle);
	call2.setString(2, maintaskdescription);
	call2.setInt(3, personid);
	call2.execute();
	Statement statement3 = connection.createStatement();
	ResultSet resultSet3 = statement3.executeQuery("select * from m_task where m_task_title='"
			+ maintasktitle + "' and m_task_dscrptn='" + maintaskdescription + "'");

	int maintaskid = 0;
	while (resultSet3.next()) {
		maintaskid = resultSet3.getInt(3);

	}
	call2.setInt(3, maintaskid);

	connection.close();
return maintaskid;	
}


public void insertSubTask(Connection connection,String subtasktitle,String subtaskdescription,int maintaskid,int personid) throws SQLException {
	CallableStatement call3 = connection.prepareCall("{call subtask_1(?,?,?,?)}");
	call3.setString(1, subtasktitle);
	call3.setString(2, subtaskdescription);
	call3.setInt(3, maintaskid);
	call3.setInt(4, personid);
	call3.execute();
	connection.close();

}

}