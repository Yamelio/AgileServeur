package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

public interface VoeuxDao {
	
	
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	List<Voeu>getVoeuxByLogin(String login);
	
	@SqlQuery("")
	boolean addVoeuTo(String login,Voeu voeu);
	
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	Voeu removeVoeuTo(String login,Voeu voeu);
	
	
	void close();
}
