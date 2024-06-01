package services.matching.ports.primary;

public class SchuelerTO {
	 String name, vorname, emailadresse;
	
	
	
public  SchuelerTO(String name, String vorname, String emailadresse) {
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
