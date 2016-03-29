package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class FormationMapper implements ResultSetMapper<Formation>
	{
	  public Formation map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		Formation res=new Formation();
		
		res.domaine=r.getString("domaine");
		res.fno=r.getInt("fno");
				
	    return res;
	  }
	}