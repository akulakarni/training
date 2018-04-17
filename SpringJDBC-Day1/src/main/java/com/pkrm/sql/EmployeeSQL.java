package com.pkrm.sql;

public class EmployeeSQL {
	  public static final String GET_ALL_EMPLOYEES = getAllEmployeesSelectSql();
	    public static final String GET_EMPLOYEE = getEmployeeSelectSql();
	    public static final String CREATE_EMPLOYEE = employeeInsertSql();
	    public static final String UPDATE_EMPLOYEE = employeeUpdateSql();
	    public static final String DELETE_EMPLOYEE = employeeDeleteSql();

	    private static String getAllEmployeesSelectSql() {
	        final StringBuilder sql = new StringBuilder();
	        sql.append("select * from Employee");
	        return sql.toString();
	    }

	    private static String employeeDeleteSql() {
	        final StringBuilder sql = new StringBuilder();
	        sql.append("delete from Employee\n");
	        sql.append("where emp_id = :emp_id");
	        return sql.toString();
	    }

	    private static String employeeUpdateSql() {
	        final StringBuilder sql = new StringBuilder();
	        sql.append("update Employee set \n");
	        sql.append("emp_name = :emp_name,\n");
	        sql.append("emp_id = :emp_id,\n");
	        sql.append("emp_age = :emp_age,\n");
	        sql.append("dept_id = :dept_id,\n");
	        sql.append("where emp_id = :emp_id");
	        return sql.toString();
	    }

	    private static String employeeInsertSql() {
	        final StringBuilder sql = new StringBuilder();
	        sql.append("insert into Employee (\n");
	        sql.append("emp_name,\n");
	        sql.append("emp_id,\n");
	        sql.append("emp_age,\n");
	        sql.append("dept_id,\n");
	      
	        sql.append("values (:emp_name, :emp_id, :emp_age, :dept_id)");
	        return sql.toString();
	    }
	    private static String getEmployeeSelectSql() {
	        final StringBuilder sql = new StringBuilder();
	        sql.append("select * from Employee\n");
	        sql.append("where emp_id = :emp_id");
	        return sql.toString();
	    }
	

}
