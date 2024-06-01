package services.anmeldung.core;

import services.anmeldung.ports.primary.LehrerTO;

public class Lehrer extends Anwender {
	private String name, vorname;
	
	
	public Lehrer (String name, String vorname,int benutzerID, String benutzername, String passwort) {
		super (benutzerID,benutzername,passwort);
		this.name = name;
		this.vorname = vorname;
		
	}

public Lehrer(LehrerTO lehrerTO , int benutzerID, String benutzername, String passwort ) {
	super (benutzerID,benutzername,passwort);
		
		this.name=lehrerTO.getName();
		this.vorname=lehrerTO.getVorname();
		
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
	

}
