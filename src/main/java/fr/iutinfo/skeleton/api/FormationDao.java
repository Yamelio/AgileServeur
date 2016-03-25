package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;
public interface FormationDao {
	
	
	@SqlQuery("select * from diplome;")
	@RegisterMapper(DiplomeMapper.class)
	List<Diplome>getDiplomes();
	
	
	@SqlQuery("select f.domaine, e.nom as ecole, e.ville, fe.feno from formetabl as fe, formation as f, diplome as d, etablissement as e where fe.fno=f.fno and f.diplome=d.dno and e.eno=fe.eno and d.lib= :lib ;")
	@RegisterMapper(ListeFormMapper.class)
	List<ListeFormation> getFormetablByDiplome(@Bind("lib") String diplome);
	
	/*
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	void removeVoeuTo(String login,Voeu voeu);
	*/
	
	void close();
}
