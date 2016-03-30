package fr.iutinfo.skeleton.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class FormaEtablMapper implements ResultSetMapper<ListeFormaEtabl> {
	public ListeFormaEtabl map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		
		ListeFormaEtabl res = new ListeFormaEtabl();
		res.ville = r.getString("ville");
		res.ecole = r.getString("ecole");
		res.domaine = r.getString("domaine");
		res.feno = r.getInt("feno");
		res.diplome=r.getString("lib");
		return res;
	}
}