package services.matching.ports.secondary;

import services.matching.ports.primary.LehrerTO;
import services.matching.ports.primary.NachhilfeangebotTO;
import services.matching.ports.primary.NachhilfegesuchTO;

public interface IMatchingDAO {
	
	public void nachhilfeangebotMachen(NachhilfeangebotTO nachhilfeangebotTO);
	public void nachhilfegesuchAufgeben(NachhilfegesuchTO nachhilfeangesuchTO);
	

	public void nachhilfeangebotSehen();
	public void nachhilfegesuchSehen();
	public void nachhilfeangebotzuNachhilfegesuchMatchen(LehrerTO lehrerTO, int gesuchID ,int angebotID );
	public void gematchteAngebotUndGesucheSehen();

}
