package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

import javax.ws.rs.QueryParam;

public interface EtudiantDao {
	
	
	@SqlQuery("select prenom,nom,login,CASE WHEN login in (select login from voeux) then 1 else 0 end from utilisateur as u, type as t where u.type=t.tno and t.lib='etudiant' order by login asc;")
	@RegisterMapper(EtudiantMapper.class)
	List<Etudiant>getEtudiants();
	
	
	@SqlQuery("select prenom,nom,login,CASE WHEN login in (select login from voeux) then 1 else 0 end from utilisateur as u, type as t where u.type=t.tno and t.lib='etudiant' and login=:login;")
	@RegisterMapper(EtudiantMapper.class)
	Etudiant getEtudiantByLogin(@Bind("login")String login);
	
	
	
	void close();
}
