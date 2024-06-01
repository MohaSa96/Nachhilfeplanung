package services.anmeldung.ports.primary;

public class SchuelerTO  extends AnwenderTO{
	 String name, vorname, emailadresse;
	
	
	
public SchuelerTO(String name, String vorname, String emailadresse, int benutzerID, String benutzername, String passwort) {
	super( benutzerID,  benutzername,  passwort);
	this.name = name;
	this.vorname = vorname;
	this.emailadresse = emailadresse;
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
