package com.jersey.rest.demo;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/demo/get")
public class GETExamples {
	@GET
	@Path("/")
	public Response simpleGET() {
		String output = "Welcome to RESTful session";
		return Response.status(200).entity(output).build();
	}

	 @GET
	 @Path("/message/{msg}")
	 public Response getMsg(@DefaultValue("Nothing") @PathParam("msg")  String msg)
	 {
	 String output="You just said:"+msg;
	 return Response.status(200).entity(output).build();
	 }
    
	 @GET
	 @Path("/messageQuery")
	 public Response getMsgQuery(@DefaultValue("Nothing")@QueryParam("name") String name) {
		 String output="You just said:"+name;
		 return Response.status(200).entity(output).build();
	 }
}
