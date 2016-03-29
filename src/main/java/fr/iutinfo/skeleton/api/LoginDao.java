package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

public interface LoginDao {
	
	
	@SqlQuery(";")
	@RegisterMapper(VoeuMapper.class)
	List<Voeu>getVoeuxByLogin(@Bind("login") String login);
	
	
	
	void close();
}
