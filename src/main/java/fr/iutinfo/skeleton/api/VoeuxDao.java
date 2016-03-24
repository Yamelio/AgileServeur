package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

public interface VoeuxDao {
	
	
	@SqlQuery("select u.login,u.prenom,u.nom,f.diplome,f.domaine,e.eno,f.fno,e.nom as etablissement,e.ville from utilisateur as u,formation as f,etablissement as e, voeux as v, formEtabl as fe where u.login=v.login and v.feno=fe.feno and fe.fno=f.fno and fe.eno=e.eno;")
	@RegisterMapper(VoeuMapper.class)
	List<Voeu>getVoeuxByLogin(String login);
	
	@SqlQuery("")
	boolean addVoeuTo(String login,Voeu voeu);
	
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	Voeu removeVoeuTo(String login,Voeu voeu);
	
	
	void close();
}
