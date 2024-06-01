package services.matching.core;

import services.matching.ports.primary.NachhilfegesuchTO;
import services.matching.ports.primary.SchuelerTO;

public class Nachhilfegesuch {

	private String fach, jahrgangstufe;
	private Schueler schueler;
	private SchuelerTO schuelerTO;
	
	public SchuelerTO getSchuelerTO() {
		return schuelerTO;
	}


	public void setSchuelerTO(SchuelerTO schuelerTO) {
		this.schuelerTO = schuelerTO;
	}


	public Nachhilfegesuch (String fach, String jahrgangstufe, SchuelerTO schuelerTO) {
		
		this.fach = fach;
		this.jahrgangstufe = jahrgangstufe;
		this.schuelerTO = schuelerTO;
			
	}
	
	
	public Nachhilfegesuch(NachhilfegesuchTO nachhilfegesuchTO) {
		
		this.fach=nachhilfegesuchTO.getFach();
		this.jahrgangstufe=nachhilfegesuchTO.getJahrgangstufe();
		this.schuelerTO=nachhilfegesuchTO.getSchuelerTO();
				
		
		
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public String getJahrgangstufe() {
		return jahrgangstufe;
	}

	public void setJahrgangstufe(String jahrgangstufe) {
		this.jahrgangstufe = jahrgangstufe;
	}

	public Schueler getSchueler() {
		return schueler;
	}

	public void setSchueler(Schueler schueler) {
		this.schueler = schueler;
	}

}
