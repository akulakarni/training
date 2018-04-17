package com.pkrm.rest;

import java.io.IOException;
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
public class Rest {

	@POST
	@Path("/insertmaintask/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMaintask(MainTask maintask) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.connect();
		try {
			DAOClass daoclass = new DAOClass();
			if (maintask.getAssigneeAge() < 30) {
				connection.close();
				System.out.println("connection closed");
				return Response.status(200).entity("main person age invalid").build();
			} else if (maintask.getAssigneeAge() > 30) {
				int headid = daoclass.insertPerson(connection, maintask.getMainTaskAssignee(),
						maintask.getAssigneeAge());
				System.out.println("head details entered");
				int mainid = daoclass.insertMainTask(connection, maintask.getMainTaskTitle(),
						maintask.getMainTaskDescription(), headid);
				System.out.println("maintask entered");

			}
		} catch (SQLException e) {
			connection.rollback();
			connection.close();
			return Response.status(200).entity("Sql exception").build();
		} finally {
		}
		connection.close();
		return Response.status(200).entity("success").build();

	}

	@PUT
	@Path("/updateMainTask")

	public Response updateDetails(@FormParam("mTaskTitle") String mTaskTitle,
			@FormParam("mTaskDescription") String mTaskDescription, @FormParam("mtaskid") int mtaskid)
			throws ClassNotFoundException, SQLException {
		int maintaskid = 0;
		Connection connection = DBConnection.connect();

		Statement statement1 = connection.createStatement();

		ResultSet resultSet1 = statement1
				.executeQuery("Select m_task_id from m_task where m_task_id='" + mtaskid + "'");

		while (resultSet1.next()) {
			maintaskid = resultSet1.getInt(1);
		}

		if (mtaskid == maintaskid) {
			try {
				// Connection connection = DBConnection.connect();
				CallableStatement callableStatement1 = connection
						.prepareCall("{call update m_task set m_task_title=?,M_TASK_DSCRPTN=?` where m_task_id=?}");
				callableStatement1.setString(1, mTaskTitle);
				callableStatement1.setString(2, mTaskDescription);
				callableStatement1.setInt(3, mtaskid);
				System.out.println(callableStatement1.executeUpdate());
				connection.close();
			}

			catch (Exception e3) {
				e3.printStackTrace();
			}
			return Response.status(200).entity("updated maintask").build();
		}

		else {
			return Response.status(200).entity("main task id not found").build();

		}

	}

	@DELETE
	@Path("/deleteMainTask")
	public Response deleteRow(@FormParam("personid") String personid) {
		try {
			Connection connection = DBConnection.connect();
			CallableStatement callableStatement1 = connection.prepareCall("{call delete from m_task where prsn_id=?}");
			callableStatement1.setString(1, personid);
			callableStatement1.execute();
			connection.close();

		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return Response.status(200).entity("row deleted").build();
	}

	@GET
	@Path("/getMainTask/{mtaskid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMainTask(@PathParam("mtaskid") int mtaskid) throws SQLException {

		List<MainTask> mainTask = new ArrayList();
		// DBConnection con = new DBConnection();

		try {
			Connection connection = DBConnection.connect();

			Statement statement1 = connection.createStatement();

			ResultSet resultSet1 = statement1.executeQuery(
					"Select m.m_task_title,m.m_task_dscrptn,p.prsn_name,p.prsn_age from m_task m,prsn p where m.prsn_id=p.prsn_id and m.m_task_id= '"
							+ mtaskid + "'");
			while (resultSet1.next()) {
				MainTask maintask = new MainTask();
				maintask.setMainTaskTitle(resultSet1.getString(1));
				maintask.setMainTaskDescription(resultSet1.getString(2));
				maintask.setMainTaskAssignee(resultSet1.getString(3));
				maintask.setAssigneeAge(resultSet1.getInt(4));

				mainTask.add(maintask);

				System.out.println(maintask);

			}
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return Response.status(200).entity(mainTask).build();

	}

}
