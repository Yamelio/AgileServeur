package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;
public interface FormationDao {
	
	
	@SqlQuery("select * from diplome;")
	@RegisterMapper(DiplomeMapper.class)
	List<Diplome>getDiplomes();
	
	
	@SqlQuery("select f.domaine, e.nom as ecole, e.ville, fe.feno from formetabl as fe, formation as f, diplome as d, etablissement as e where fe.fno=f.fno and f.diplome=d.dno and e.eno=fe.eno and d.lib= :lib ;")
	@RegisterMapper(ListeFormMapper.class)
	List<ListeFormation> getFormetablByDiplome(@Bind("lib") String diplome);
	
	
	@SqlQuery("select f.domaine, e.nom as ecole, e.ville, fe.feno, d.lib from formetabl as fe, formation as f, diplome as d, etablissement as e where fe.fno=f.fno and f.diplome=d.dno and e.eno=fe.eno order by d.lib;")
	@RegisterMapper(FormaEtablMapper.class)
	List<ListeFormaEtabl> getFormetabl();

	
	@SqlQuery("select f.fno,f.domaine from formation as f,diplome as d where f.diplome=d.dno and d.lib=:lib;")
    @RegisterMapper(FormationMapper.class)
	List<Formation> getDomaineByDiplome(@Bind("lib") String lib);

	@SqlUpdate("insert into formation (domaine,diplome) values(:domaine,(select dno from diplome where lib=:lib));")
	void addDomaineByDiplome(@Bind("lib") String lib, @Bind("domaine") String domaine);
	
	/*
	@SqlQuery("")
	@RegisterMapper(VoeuMapper.class)
	void removeVoeuTo(String login,Voeu voeu);
	*/
	
	@SqlUpdate("insert into formEtabl(fno,eno) select :fno,:eno "
			+ "where not exists"
			+ "(select eno,fno from formEtabl where eno=:eno and fno=:fno);")
	void addFormEtabl(@Bind("fno")int fno, @Bind("eno") int eno);


	@SqlUpdate("delete from formEtabl where feno=:feno")
	void removeFormEtabl(@Bind("feno")int feno);

	void close();
}
