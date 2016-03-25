package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class EtudiantMapper implements ResultSetMapper<Etudiant>
	{
	  public Etudiant map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		Etudiant res=new Etudiant();
		
		res.prenom=r.getString("prenom");
		res.nom=r.getString("nom");
		res.login=r.getString("login");
		res.hasVoeu=r.getInt("case");
		
	    return res;
	  }
	}