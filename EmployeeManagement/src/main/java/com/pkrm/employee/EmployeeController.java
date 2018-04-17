package com.pkrm.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/class/get")
public class EmployeeController {
	
	@GET
	@Path("/")
	public Response simpleGET() {
		String output = "Welcome to PROKARMA";
		return Response.status(200).entity(output).build();
	
	}
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeDetails() throws ClassNotFoundException, SQLException{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		DBConnection con = new DBConnection();
		Connection connection = DBConnection.main();
		List<Employee> employeeDetails=new ArrayList();
		CommonOutput commonOutput=new CommonOutput();
		Statement statement = connection.createStatement();
		String sql = "Select * from employeedetails";
		ResultSet resultSet = statement.executeQuery(sql);
		try {
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setEmployeeName(resultSet.getString(1));
			employee.setEmployeeId(resultSet.getInt(2));
			employee.setDepartmentId(resultSet.getInt(3));
			employeeDetails.add(employee);
            System.out.println(employeeDetails);
			
				}
		connection.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		commonOutput.setEmployeeDetails(employeeDetails);
		return Response.status(200).entity(employeeDetails).build();
	}
	
    @GET
    @Path("/employeeById/{id:[0-9][0-9][0-9][0-9]}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") int id) throws SQLException{
    	//DBConnection con = new DBConnection();
    	List<Employee> employeeDetails1=new ArrayList();
		try {
			Connection connection = DBConnection.main();
			
			Statement statement1 = connection.createStatement();
			String sql1 = "Select employee_Name from employeedetails where employee_Id= '"+id+" '";
			ResultSet resultSet1 = statement1.executeQuery(sql1);
			while(resultSet1.next()) {
				Employee employee=new Employee();
				employee.setEmployeeName(resultSet1.getString(1));
               //employee.setEmployeeId(resultSet1.getInt(2));
//				employee.setDepartmentId(resultSet1.getInt(3));
				employeeDetails1.add(employee);
				System.out.println(employeeDetails1);
					
			}
			connection.close();	
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return Response.status(200).entity(employeeDetails1.get(0).employeeName).build();
    	
    }
    
    @POST
    @Path("/saveDetails")
    public Response saveDetails(@FormParam("name") String name,@FormParam("e_id") int e_id,@FormParam("d_id") int d_id) {
    	
    	try {
    		Connection connection=DBConnection.main();
    		CallableStatement callableStatement = connection.prepareCall("{call insert into employeedetails values (?,?,?)}");
			callableStatement.setString(1, name);
			callableStatement.setInt(2, e_id);
			callableStatement.setInt(3, d_id);
			callableStatement.execute();
			connection.close();
    	}
    
    catch(Exception e2) {
    		e2.printStackTrace();
    	}
    	return Response.status(200).entity("called").build();
    }
    
    @PUT
    @Path("/update")
    public Response updateDetails(@FormParam("emp_name") String emp_name,@FormParam("emp_id") int emp_id) {
    	try {
    		Connection connection=DBConnection.main();
    		CallableStatement callableStatement1 = connection.prepareCall("{call update employeeDetails set employee_Name=? where employee_Id=?}");
			callableStatement1.setString(1, emp_name);
			callableStatement1.setInt(2, emp_id);
			callableStatement1.execute();
			connection.close();
    		
    	}
    	catch(Exception e3) {
    		e3.printStackTrace();
    	}
    	return Response.status(200).entity("updated employee name").build();
    }
    
    @DELETE
    @Path("/deleterow")
    public Response deleteRow(@FormParam("employee_name") String employee_name) {
    	try {
    		Connection connection=DBConnection.main();
    		CallableStatement callableStatement1 = connection.prepareCall("{call delete employeeDetails where employee_Name=?}");
			callableStatement1.setString(1, employee_name);
			callableStatement1.execute();
			connection.close();
    		
    	}
    	catch(Exception e3) {
    		e3.printStackTrace();
    	}
    	return Response.status(200).entity("row deleted").build();
    }
    
}
