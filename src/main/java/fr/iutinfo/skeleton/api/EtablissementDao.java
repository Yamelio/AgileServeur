package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

public interface EtablissementDao {
		
	
	@SqlUpdate("insert into etablissement (nom,ville) values(:nom ,:ville);")
	void addEtablissement(@Bind("nom") String nom, @Bind("ville") String ville);

	
	void close();


	@SqlQuery("select * from etablissement")
	@RegisterMapper(EtablissementMapper.class)
	List<Etablissement> getEtablissements();


}
