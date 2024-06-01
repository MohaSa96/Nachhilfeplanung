package services.anmeldung.core;

import services.anmeldung.ports.primary.SchuelerTO;

public class Schueler extends Anwender {
	private String name, vorname, emailadresse;
	
	
	
	public  Schueler(String name, String vorname, String emailadresse,int benutzerID, String benutzername, String passwort) {
		super (benutzerID,benutzername,passwort);
		this.name = name;
		this.vorname = vorname;
		this.emailadresse = emailadresse;
	}
	
   public Schueler(SchuelerTO schuelerTO,String emailadresse,int benutzerID, String benutzername, String passwort) {
	super (benutzerID,benutzername,passwort);
		this.name = schuelerTO.getName();
		this.vorname = schuelerTO.getVorname();
		this.emailadresse =schuelerTO.getEmailadresse();	
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getEmailadresse() {
		return emailadresse;
	}


	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}



}
