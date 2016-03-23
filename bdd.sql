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
	uno SERIAL,
	prenom TEXT,
	nom TEXT,
	login TEXT,
	password TEXT,
	type INTEGER,
	CONSTRAINT pk_uno PRIMARY KEY(uno),
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

CREATE TABLE voeux (
	uno integer,
	fno integer,
	numero_voeu integer,
	CONSTRAINT fk_uno FOREIGN KEY(uno) REFERENCES utilisateur(uno),
	CONSTRAINT fk_fno FOREIGN KEY(fno) REFERENCES formation(fno),
	CONSTRAINT pk_vno PRIMARY KEY(uno,fno)
);
	
