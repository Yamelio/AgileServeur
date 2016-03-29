package fr.iutinfo.skeleton.api;

public class FormaEtabl {

	private int formaId;
	private int etaId;
	private int feno;
	private String domaine;
	private String diplome;
	private String ville;
	private String nom;
	
	public FormaEtabl(){};
	
	public int getFormaId() {
		return formaId;
	}
	public void setFormaId(int formaId) {
		this.formaId = formaId;
	}
	public int getEtaId() {
		return etaId;
	}
	public void setEtaId(int etaId) {
		this.etaId = etaId;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "FormaEtabl [formaId=" + formaId + ", etaId=" + etaId + ", domaine=" + domaine + ", diplome=" + diplome
				+ ", ville=" + ville + ", nom=" + nom + "]";
	}

	public int getFeno() {
		return this.feno;
	}
	
	public void setFeno(int feno) {
		this.feno=feno;
	}
	
	
	
}
