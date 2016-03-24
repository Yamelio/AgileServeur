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
		
		user.setLogin(r.getString("login"));
		user.setName(r.getString("nom"));
		user.setPrenom(r.getString("prenom"));
		user.setRole(r.getString("role"));
		
		fe.setDiplome(r.getString("diplome"));
		fe.setDomaine(r.getString("domaine"));
		fe.setEtaId(r.getInt("eno"));
		fe.setFormaId(r.getInt("fno"));
		fe.setNom(r.getString("etablissement")); //de l'établissement
		fe.setVille(r.getString("ville"));
		
		
		res.setFormaEtabl(fe);
		res.setUser(user);		
	    return res;
	  }
	}