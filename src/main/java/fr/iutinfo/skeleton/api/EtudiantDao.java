package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

import javax.ws.rs.QueryParam;

public interface EtudiantDao {
	
	
	@SqlQuery("select u.prenom,u.nom,u.login,CASE WHEN u.login in (select v1.login from voeux as v1) then (select count(*) from voeux as v2  where v2.login=u.login) else 0 end from utilisateur as u, type as t where u.type=t.tno and t.lib='etudiant';")
	@RegisterMapper(EtudiantMapper.class)
	List<Etudiant>getEtudiants();
	
	
	@SqlQuery("select prenom,nom,login,CASE WHEN login in (select login from voeux) then 1 else 0 end from utilisateur as u, type as t where u.type=t.tno and t.lib='etudiant' and login=:login;")
	@RegisterMapper(EtudiantMapper.class)
	Etudiant getEtudiantByLogin(@Bind("login")String login);
	
	
	
	void close();
}
