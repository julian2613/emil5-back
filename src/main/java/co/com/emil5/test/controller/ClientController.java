package co.com.emil5.test.controller;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import co.com.emil5.test.service.ClientService;

@Path("/client")
public class ClientController {
	
	@EJB
	private ClientService clientService;

	@GET
	@Path("/")
	public void get() {
		System.out.println("SOY UN GET");
	}

	@POST
	@Path("/")
	public void post() {
		clientService.save();
	}

}
