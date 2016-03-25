package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

import javax.ws.rs.QueryParam;

public interface EtudiantDao {
	
	
	@SqlQuery("select prenom,nom,login,CASE WHEN login in (select login from voeux) then 1 else 0 end from utilisateur as u, type as t where u.type=t.tno and t.lib='etudiant';")
	@RegisterMapper(EtudiantMapper.class)
	List<Etudiant>getEtudiants();
	
	
	@SqlUpdate("insert into voeux values(:login, :feno );")
	void addVoeuTo(@Bind("login") String login, @Bind("feno") int feno);
	
	
	@SqlUpdate("delete from voeux where login=:login and feno=:feno;")
	void removeVoeuTo(@Bind("login")String login,@Bind("feno")int feno);
	
	
	void close();
}
