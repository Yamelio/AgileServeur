package fr.iutinfo.skeleton.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	private static LoginDao dao = BDDFactory.getDbi().open(LoginDao.class);
	final static Logger logger = LoggerFactory.getLogger(SecureResource.class);
	Gson gson = new Gson();

	@POST
	public Response checkLogin(@FormParam("login") String login,@FormParam("password")String password) {
		int reponse = dao.checkLogin(login,password);
		logger.debug(login);
		logger.debug(password);
		logger.debug(""+reponse);
		return Response.status(200).entity(gson.toJson(reponse)).build();

	}

}
