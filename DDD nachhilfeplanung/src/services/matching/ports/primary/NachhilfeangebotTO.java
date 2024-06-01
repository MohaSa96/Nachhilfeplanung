package services.matching.ports.primary;

public class NachhilfeangebotTO {
	   String fach, jahrgangstufe, fachbeherrschung;
	   SchuelerTO schuelerTO;
	  
	  
	  public NachhilfeangebotTO (String fach, String jahrgangstufe, String fachbeherrschung, SchuelerTO schuelerTO) {
		  
		    this.fach = fach;
		    this.jahrgangstufe = jahrgangstufe;
		    this.fachbeherrschung = fachbeherrschung;
		    this.schuelerTO = schuelerTO;
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


	public SchuelerTO getSchuelerTO() {
		return schuelerTO;
	}


	public void setSchuelerTO(SchuelerTO schuelerTO) {
		this.schuelerTO = schuelerTO;
	}



}
