package co.com.emil5.test.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import co.com.emil5.test.entity.Client;
import co.com.emil5.test.excepcion.DatosExcepcion;
import co.com.emil5.test.service.facade.IClientService;

@Path("/client")
public class ClientController {

	@EJB
	private IClientService clientService;

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(Client client) {
		try {
			return Response.ok(this.clientService.save(client)).build();
		} catch (DatosExcepcion e) {
			return Response.status(Status.PRECONDITION_FAILED).entity(e).build();
		}
	}

}
