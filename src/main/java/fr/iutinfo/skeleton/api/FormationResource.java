package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.auth.AuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/formation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FormationResource {

	private static FormationDao dao = BDDFactory.getDbi().open(FormationDao.class);
	final static Logger logger = LoggerFactory.getLogger(SecureResource.class);
	Gson gson = new Gson();

	@GET
	@Path("/diplome")
	public Response getDiplomes() {
		List<String> reponse = dao.getDiplomes();
		return Response.status(200).entity(gson.toJson(reponse)).build();

	}

	@GET
	public Response addVoeuTo(@QueryParam("login") String login,@QueryParam("feno") int feno) {
		dao.addVoeuTo(login, feno);
		return Response.status(200).entity(gson.toJson(login)).build();
	}
	/*
	 * @DELETE public Voeu removeVoeuTo(String login,Voeu voeu) { return
	 * dao.removeVoeuTo(login,voeu); }
	 */
}
