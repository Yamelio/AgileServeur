package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class DiplomeMapper implements ResultSetMapper<Diplome>
	{
	  public Diplome map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		Diplome res=new Diplome();
		res.dno=r.getInt("dno");
		res.lib=r.getString("lib");
	    return res;
	  }
	}