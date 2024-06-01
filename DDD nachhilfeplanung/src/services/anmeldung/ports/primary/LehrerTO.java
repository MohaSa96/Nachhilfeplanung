package services.anmeldung.ports.primary;

public class LehrerTO extends AnwenderTO {
	
 String name, vorname;
	
	
	public LehrerTO (String name, String vorname, int benutzerID, String benutzername, String passwort) {
		super( benutzerID,  benutzername,  passwort);
		this.name = name;
		this.vorname = vorname;
		
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
