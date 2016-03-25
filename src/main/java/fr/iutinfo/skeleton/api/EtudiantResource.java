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

@Path("/etudiant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EtudiantResource {

	private static EtudiantDao dao = BDDFactory.getDbi().open(EtudiantDao.class);
	final static Logger logger = LoggerFactory.getLogger(SecureResource.class);
	Gson gson = new Gson();

	@GET
	public Response getEtudiants() {
		List<Etudiant> reponse = dao.getEtudiants();
		return Response.status(200).entity(gson.toJson(reponse)).build();
	}
	
	@GET
	@Path("{login}")
	public Response getEtudiantByLogin(@PathParam("login") String login) {
		Etudiant reponse = dao.getEtudiantByLogin(login);
		return Response.status(200).entity(gson.toJson(reponse)).build();
	}
}
