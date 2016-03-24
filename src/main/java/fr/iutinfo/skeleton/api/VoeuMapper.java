package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class VoeuMapper implements ResultSetMapper<Voeu>
	{
	  public Voeu map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		Voeu res=new Voeu();
		User user = new User();
		FormaEtabl fe = new FormaEtabl();
		
		user.setLogin(login);
		user.setName(name);
		user.setPrenom(prenom);
		user.setPassword(password);
		
		fe.setDiplome(diplome);
		fe.setDomaine(domaine);
		fe.setEtaId(etaId);
		fe.setFormaId(formaId);
		fe.setNom(nom); //de l'établissement
		fe.setVille(ville);
		
		
		res.setFormaEtabl(fe);
		res.setUser(user);		
	    return res;
	  }
	}