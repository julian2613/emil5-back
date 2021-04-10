package co.com.emil5.test.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.emil5.test.excepcion.DatosExcepcion;
import co.com.emil5.test.service.facade.ITokenService;

@Path("/token")
public class TokenController {

	@EJB
	private ITokenService tokenService;

	@POST
	@Path("/validate/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validate(@PathParam("id") String id) {
		return Response.ok(this.tokenService.validate(id)).build();
	}

	@POST
	@Path("{email}/generate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response generate(@PathParam("email") String email) throws DatosExcepcion {
		return Response.ok(this.tokenService.generate(email)).build();
	}

}
