package services.matching.core;

import services.matching.ports.primary.NachhilfeangebotTO;
import services.matching.ports.primary.SchuelerTO;

public class Nachhilfeangebot {

	private String fach, jahrgangstufe, fachbeherrschung;
	  private Schueler schueler;
	  private SchuelerTO schuelerTO;
	  
	  
	  public Nachhilfeangebot (String fach, String jahrgangstufe, String fachbeherrschung, SchuelerTO schuelerTO) {
		  
		    this.fach = fach;
		    this.jahrgangstufe = jahrgangstufe;
		    this.fachbeherrschung = fachbeherrschung;
		    this.schuelerTO = schuelerTO;
	  }
	  
	  public Nachhilfeangebot(NachhilfeangebotTO nachhilfeangebotTO ) {
		  
		  
		  this.fach = nachhilfeangebotTO.getFach();
		  this.jahrgangstufe= nachhilfeangebotTO.getJahrgangstufe();
		  this.fachbeherrschung = nachhilfeangebotTO.getFachbeherrschung();
		  this.schuelerTO=nachhilfeangebotTO.getSchuelerTO();
		  
		    
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


	public String getFachbeherrschung() {
		return fachbeherrschung;
	}


	public void setFachbeherrschung(String fachbeherrschung) {
		this.fachbeherrschung = fachbeherrschung;
	}

	public Schueler getSchueler() {
		return schueler;
	}

	public void setSchueler(Schueler schueler) {
		this.schueler = schueler;
	}

	public SchuelerTO getSchuelerTO() {
		return schuelerTO;
	}

	public void setSchuelerTO(SchuelerTO schuelerTO) {
		this.schuelerTO = schuelerTO;
	}




	}


