package services.matching.core;

import services.matching.ports.primary.LehrerTO;

public class Lehrer {
	private String name, vorname;
	
	
	public Lehrer (String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
		
	}
	
public Lehrer(LehrerTO lehrerTO) {
		
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
