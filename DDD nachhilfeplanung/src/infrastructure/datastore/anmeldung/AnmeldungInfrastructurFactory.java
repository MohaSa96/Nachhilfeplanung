package infrastructure.datastore.anmeldung;

public class AnmeldungInfrastructurFactory {


	public AnmeldungDAO getAnmeldungDAO(){
		return new AnmeldungDAO();
	}

}
