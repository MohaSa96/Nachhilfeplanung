package services.anmeldung.core;



public class Anwender {

	private String benutzername, passwort;
	private int benutzerID;
	
	
	public  Anwender(int benutzerID, String benutzername, String passwort) {
		this.benutzerID = benutzerID;
		this.benutzername = benutzername;
		this.passwort = passwort;
	}
	
	
	public String getBenutzername() {
		return benutzername;
	}


	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}


	public String getPasswort() {
		return passwort;
	}


	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


	public int getBenutzerID() {
		return benutzerID;
	}


	public void setBenutzerID(int benutzerID) {
		this.benutzerID = benutzerID;
	}
	
}
