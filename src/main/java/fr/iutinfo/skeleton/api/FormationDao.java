package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;
public interface FormationDao {
	
	
	@SqlQuery("select * from diplome;")
	@RegisterMapper(DiplomeMapper.class)
	List<Diplome>getDiplomes();
	
	
	@SqlUpdate("")
	void addVoeuTo(@Bind("login") String login, @Bind("feno") int feno);
	
	/*
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	void removeVoeuTo(String login,Voeu voeu);
	*/
	
	void close();
}
