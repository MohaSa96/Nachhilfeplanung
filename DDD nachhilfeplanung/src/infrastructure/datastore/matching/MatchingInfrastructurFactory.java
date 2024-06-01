package infrastructure.datastore.matching;

import infrastructure.datastore.anmeldung.AnmeldungDAO;

public class MatchingInfrastructurFactory {
	
	public MatchingDAO getMatchinggDAO(){
		return new MatchingDAO();
		
	}


}
