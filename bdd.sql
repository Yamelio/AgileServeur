-- psql -h psqlserv -U post_iut_user post_iut

DROP TABLE if exists utilisateur CASCADE;
DROP TABLE if exists type CASCADE;
DROP TABLE if exists formation CASCADE;
DROP TABLE if exists etablissement CASCADE;

CREATE TABLE type(
	tno SERIAL,
	lib TEXT,
	CONSTRAINT pk_tno PRIMARY KEY(tno)
);
INSERT INTO type (lib) VALUES('admin');
INSERT INTO type (lib) VALUES('etudiant');
INSERT INTO type (lib) VALUES('secretaire');
INSERT INTO type (lib) VALUES('jury');


CREATE TABLE utilisateur(
	login TEXT,
	prenom TEXT,
	nom TEXT,
	password TEXT,
	type INTEGER,
	CONSTRAINT pk_login PRIMARY KEY(login),
	CONSTRAINT fk_type FOREIGN KEY(type) REFERENCES type(tno)
);
-- Types : 0 = admin , 1 = etudiant , 2  = secretaire , 3 = Jury
INSERT INTO utilisateur (prenom,nom,login,password,type) VALUES('Omar','Al yasini','omar.al-yasini','omaromar','1');
INSERT INTO utilisateur (prenom,nom,login,password,type) VALUES('Guillaume','Kleinpoort','guillaume.kleinpoort','guillaume','1');
INSERT INTO utilisateur (prenom,nom,login,password,type) VALUES('aaaa','aaaa','aaaa.aaaa','aaaa','2');
INSERT INTO utilisateur (prenom,nom,login,password,type) VALUES('bbbb','bbbb','bbbb.bbbb','bbbb','2');

	
CREATE TABLE formation(
	fno SERIAL,
	domaine TEXT,
	diplome TEXT,
	CONSTRAINT pk_fno PRIMARY KEY(fno)
);
	
CREATE TABLE etablissement(
	eno SERIAL,
	ville TEXT,
	nom TEXT,
	CONSTRAINT pk_eno PRIMARY KEY(eno)
);

CREATE TABLE formEtabl(
	fno Integer,
	eno Integer,
	feno serial,
	CONSTRAINT fk_fno FOREIGN KEY(fno) REFERENCES formation(fno),
	CONSTRAINT fk_eno FOREIGN KEY(eno) REFERENCES etablissement(eno),
	CONSTRAINT pk_feno PRIMARY KEY(feno)
);

CREATE TABLE voeux (
	login text,
	feno integer,
	CONSTRAINT fk_login FOREIGN KEY(login) REFERENCES utilisateur(login),
	CONSTRAINT fk_feno FOREIGN KEY(feno) REFERENCES formEtabl(feno),
	CONSTRAINT pk_vno PRIMARY KEY(login,feno)
);

--Select voeux par login
select u.login,u.prenom,u.nom,f.diplome,f.domaine,e.eno,f.fno,e.nom,e.ville
from utilisateur as u,formation as f,etablissement as e, voeux as v, formEtabl as fe
where u.login=v.login and v.feno=fe.feno and fe.fno=f.fno and fe.eno=e.eno;



	
