package com.pkrm.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/class/company")
public class CompanyController {
	
	
    @GET
    @Path("/getDept/{dept_id:[0-9][0-9]}")
	public Response getDepartment(@PathParam("dept_id") int dept_id) throws SQLException {
    	List<Department> departmentDetails=new ArrayList();
		try {
			Connection connection = DBConnection.main();
			
			Statement statement1 = connection.createStatement();
			String sql1 = "Select department_Name from employeedepartment where department_Id= '"+dept_id+" '";
			ResultSet resultSet1 = statement1.executeQuery(sql1);
			while(resultSet1.next()) {
				Department department=new Department();
				department.setDepartmentName(resultSet1.getString(1));
//				employee.setEmployeeId(resultSet1.getInt(2));
//				employee.setDepartmentId(resultSet1.getInt(3));
				departmentDetails.add(department);
				System.out.println(departmentDetails);
					
			}
			connection.close();	
			
		} catch (ClassNotFoundException e) {
				
			e.printStackTrace();
		}
		return Response.status(200).entity(departmentDetails.get(0).departmentName).build();
    }
    
    @DELETE
    @Path("/deletedepartment")
    public Response deleteRow(@FormParam("department_name") String department_name) {
    	try {
    		Connection connection=DBConnection.main();
    		CallableStatement callableStatement = connection.prepareCall("{call delete employeedepartment where department_Name=?}");
			callableStatement.setString(1, department_name);
			callableStatement.execute();
			connection.close();
    		
    	}
    	catch(Exception e3) {
    		e3.printStackTrace();
    	}
    	return Response.status(200).entity("department deleted").build();
    }

}
