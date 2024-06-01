package services.matching.ports.primary;


public class NachhilfegesuchTO {
	 String fach, jahrgangstufe;
	 SchuelerTO schuelerTO;
	
	public NachhilfegesuchTO (String fach, String jahrgangstufe, SchuelerTO schuelerTO) {
		
		this.fach = fach;
		this.jahrgangstufe = jahrgangstufe;
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

	public SchuelerTO getSchuelerTO() {
		return schuelerTO;
	}

	public void setSchuelerTO(SchuelerTO schuelerTO) {
		this.schuelerTO = schuelerTO;
	}

}
