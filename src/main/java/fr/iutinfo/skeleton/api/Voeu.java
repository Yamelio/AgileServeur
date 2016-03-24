package fr.iutinfo.skeleton.api;


public class Voeu {

	private User user;
	private FormaEtabl formaEtabl;
	
	public Voeu(){};
	public Voeu(User user,FormaEtabl formaEtabl){
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public FormaEtabl getFormaEtabl() {
		return formaEtabl;
	}
	public void setFormaEtabl(FormaEtabl formaEtabl) {
		this.formaEtabl = formaEtabl;
	}
	@Override
	public String toString() {
		return "Voeu [user=" + user + ", formaEtabl=" + formaEtabl + "]";
	}
		
}
