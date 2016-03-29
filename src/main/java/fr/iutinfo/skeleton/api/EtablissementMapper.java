package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class EtablissementMapper implements ResultSetMapper<Etablissement> {
	public Etablissement map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		Etablissement res = new Etablissement();

		res.nom = r.getString("nom");
		res.ville = r.getString("ville");
		try{
		res.eno=r.getInt("eno");
		}
		catch(Exception e){};

		return res;
	}
}