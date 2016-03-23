package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.auth.AuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/voeux")
public class VoeuxResource {
	
	private static VoeuxDao dao = BDDFactory.getDbi().open(VoeuxDao.class);
    final static Logger logger = LoggerFactory.getLogger(SecureResource.class);

    @GET
    public List<Voeu> getVoeux(String login) {
    	//dao.getVoeuxByLogin(login);
    	return null;
    }

    @PUT
    public boolean addVoeuTo(String login, Voeu voeu) {
        //dao.addVoeuTo(login,voeu);
        return false;
    }

    @DELETE
    public Voeu removeVoeuTo(String login,Voeu voeu) {
        //dao.removeVoeuTo(login,voeu);
    	return null;
    }

}
