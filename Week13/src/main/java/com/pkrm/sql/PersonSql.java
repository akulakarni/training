package com.pkrm.sql;

public class PersonSql {
	  public static final String CREATE_USER = insertUserSql();

		private static String insertUserSql() {
			 final StringBuilder sql = new StringBuilder();
		        sql.append("insert into Person (\n");
		        sql.append("userId,\n");
		        sql.append("userName,\n");
		        sql.append("firstName,\n");
		        sql.append("lastName,\n");
		      
		        sql.append("values (:userId, :userName, :firstName, :lastName)");
		        return sql.toString();
			
		}


}
