package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface LoginDao {
	
	
	@SqlQuery("select CASE WHEN :password in (select u2.password from utilisateur as u2 where 'guillaume.kleinpoort'=u1.login and :login=u2.login)then 1 else 0 end,t.lib from utilisateur as u1,type as t where t.tno=u1.type and u1.login=:login;")
	int checkLogin(@Bind("login") String login,@Bind("password")String password);
	
	
	
	void close();
}
