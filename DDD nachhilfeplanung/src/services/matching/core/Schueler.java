package services.matching.core;

import services.matching.ports.primary.SchuelerTO;

public class Schueler {
	private String name, vorname, emailadresse;
	
	
	
	public  Schueler(String name, String vorname, String emailadresse) {
		this.name = name;
		this.vorname = vorname;
		this.emailadresse = emailadresse;
	}

public Schueler(SchuelerTO schuelerTO) {
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
