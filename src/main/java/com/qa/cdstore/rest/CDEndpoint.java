package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDServiceImpl;

@Path("/cdstore")
public class CDEndpoint {

	@Inject
	private CDServiceImpl cdService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getCDAsJson(){
		return cdService.getAllCDs();
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewCDToMap(String cdJson){
		return cdService.addNewCD(cdJson);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteCDFromCDStore(@PathParam("id")int id, String cdJson){
		return cdService.updateCD(id, cdJson);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateCDFromCDStore(@PathParam("id") int id, String cdJson){
		return cdService.updateCD(id, cdJson);
	}
}
