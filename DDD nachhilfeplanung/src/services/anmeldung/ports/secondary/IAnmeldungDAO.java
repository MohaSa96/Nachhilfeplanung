package services.anmeldung.ports.secondary;

import services.anmeldung.ports.primary.LehrerTO;
import services.anmeldung.ports.primary.SchuelerTO;

public interface IAnmeldungDAO {
	
	
	public void benutzerDatenAnlegen(SchuelerTO schulerTO);
	public void benutzerDatenAnlegen(LehrerTO lehrerTO);
	public boolean benutzerAnmelden(SchuelerTO schulerTO);
	public boolean benutzerAnmelden(LehrerTO lehrerTO);
	public void benutzerDatenAendernBenutzername(SchuelerTO schulerTO1 , SchuelerTO schulerTO2) ;
	public void benutzerDatenAendernPasswort(SchuelerTO schulerTO3 , SchuelerTO schulerTO4);
	public void benutzerDatenAendernBenutzernameUndPasswort(SchuelerTO schulerTO5 , SchuelerTO schulerTO6);
	public void benutzerDatenAendernBenutzername(LehrerTO lehrerTO1 , LehrerTO lehrerTO2);
	public void benutzerDatenAendernPasswort(LehrerTO lehrerTO3 , LehrerTO lehrerTO4);
	public void benutzerDatenAendernBenutzernameUndPasswort(LehrerTO lehrerTO5 , LehrerTO lehrerTO6);
	

}
