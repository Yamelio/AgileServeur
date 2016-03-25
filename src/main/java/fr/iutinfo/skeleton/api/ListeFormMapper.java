package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ListeFormMapper implements ResultSetMapper<ListeFormation>
	{
	  public ListeFormation map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		  ListeFormation res=new ListeFormation();
		res.ville=r.getString("ville");
		res.ecole=r.getString("ecole");
		res.domaine=r.getString("domaine");
	    return res;
	  }
	}