package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.auth.AuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/voeux")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoeuxResource {

	private static VoeuxDao dao = BDDFactory.getDbi().open(VoeuxDao.class);
	final static Logger logger = LoggerFactory.getLogger(SecureResource.class);

	@GET
	@Path("{login}")
	public Response getVoeux(@PathParam("login") String login) {
		List<Voeu> reponse = dao.getVoeuxByLogin(login);
		return Response.status(200).entity(reponse.toString()).build();

	}

	/*
	 * @PUT public boolean addVoeuTo(String login, Voeu voeu) { return
	 * dao.addVoeuTo(login,voeu);
	 * 
	 * }
	 * 
	 * @DELETE public Voeu removeVoeuTo(String login,Voeu voeu) { return
	 * dao.removeVoeuTo(login,voeu); }
	 */
}
