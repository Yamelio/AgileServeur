package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

import javax.ws.rs.QueryParam;

public interface VoeuxDao {
	
	
	@SqlQuery("select u.login,u.prenom,u.nom,t.lib as role,d.lib as diplome,f.domaine,e.eno,f.fno,e.nom as etablissement,e.ville "
			+ "from utilisateur as u,formation as f,etablissement as e, voeux as v, formEtabl as fe, type as t, diplome as d "
			+ "where u.login=v.login and v.feno=fe.feno and fe.fno=f.fno and fe.eno=e.eno and t.tno=u.type and u.login=:login and f.diplome=d.dno;")
	@RegisterMapper(VoeuMapper.class)
	List<Voeu>getVoeuxByLogin(@Bind("login") String login);
	
	
	@SqlUpdate("insert into voeux values(:login, :feno );")
	void addVoeuTo(@Bind("login") String login, @Bind("feno") int feno);
	
	/*
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	void removeVoeuTo(String login,Voeu voeu);
	*/
	
	void close();
}
