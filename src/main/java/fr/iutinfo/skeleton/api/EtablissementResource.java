package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@Path("/etablissement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EtablissementResource {

	private static EtablissementDao dao = BDDFactory.getDbi().open(EtablissementDao.class);
	final static Logger logger = LoggerFactory.getLogger(SecureResource.class);
	Gson gson = new Gson();

	@PUT
	public Response addEtablissement(@QueryParam("nom") String nom, @QueryParam("ville") String ville) {
		dao.addEtablissement(nom, ville);
		return Response.status(200).entity(gson.toJson(nom)).build();
	}
	
	@GET
	public Response getEtablissements(){
		List<Etablissement> res = dao.getEtablissements();
		return Response.status(200).entity(gson.toJson(res)).build();
	}

}
