package infrastructure.datastore.matching;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import services.matching.ports.primary.LehrerTO;
import services.matching.ports.primary.NachhilfeangebotTO;
import services.matching.ports.primary.NachhilfegesuchTO;
import services.matching.ports.secondary.IMatchingDAO;




public class MatchingDAO implements IMatchingDAO {
	

	public static Connection getConnection(){
		Connection aConnection = null;
		
		
		try {
			/*
			 * Hier den Namen des JDBC-Treibers angeben. Damit der auch gefunden wird, muss
			 * das jar-File in Eclipde unter 
			 * "Project->Properties->Java Build Path->Libraries->Add External Jars" angegeben werden
			 */
			Class.forName ("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		try {
			/* 
			 * Form: @Rechnername:Port, "Db-User", "Password"
			 */
			aConnection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Benutzer", "softwareentwurf", "01020300");
			aConnection.setAutoCommit(true);
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return(aConnection);	
	}
	
	public static void closeConnection(Connection aConnection){
		try {
			aConnection.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
	
	public static void commitConnection(Connection aConnection){
		try {
			aConnection.commit();
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
	
	
	public static void executeUpdateStatement(Connection aConnection, String aStatement) throws SQLException{
//		System.out.println(aStatement);
		Statement stmt = aConnection.createStatement();
		stmt.executeUpdate(aStatement);
		
	}
	
	public static ResultSet executeQueryStatement(Connection aConnection, String aStatement) throws SQLException{
		ResultSet aResultSet = null;
//		System.out.println("DEBUG: "+aStatement);
		Statement stmt = aConnection.createStatement();
		aResultSet =  stmt.executeQuery(aStatement);
		
		return aResultSet;
	}
	

public void nachhilfeangebotMachen(NachhilfeangebotTO nachhilfeangebotTO){
	
	
	try {
		
		String sql ="insert into nachhilfeangebot (fach , jahrgangstufe, fachbeherrschung ) values ( '" + nachhilfeangebotTO.getFach() + "', '" + nachhilfeangebotTO.getJahrgangstufe() + "' "
				+ ", '" + nachhilfeangebotTO.getFachbeherrschung() +"')";
		
		executeUpdateStatement(getConnection(),sql);
		
		String sql2 ="insert into schulerdaten values (null,'" + nachhilfeangebotTO.getSchuelerTO().getName() + "', '" +  nachhilfeangebotTO.getSchuelerTO().getVorname()  + "', '" +  nachhilfeangebotTO.getSchuelerTO().getEmailadresse()  + "', (select max(nachhilfeangebotid) from nachhilfeangebot) ,null) ";	
		executeUpdateStatement(getConnection(),sql2);

		System.out.println("\nDie Nachhilfeangebot wurde erfolgreich erstellt.");

		
		 }
	catch (SQLException e) {
		e.printStackTrace();
	}
	}


public void nachhilfegesuchAufgeben(NachhilfegesuchTO nachhilfeangesuchTO){
	
try {
		
		String sql ="insert into nachhilfegesuch (fach , jahrgangstufe) values ('" + nachhilfeangesuchTO.getFach() + "', '" + nachhilfeangesuchTO.getJahrgangstufe() + "')";
		executeUpdateStatement(getConnection(),sql);
		
		
		String sql2 ="insert into schulerdaten values (null,'" + nachhilfeangesuchTO.getSchuelerTO().getName() + "', '" +  nachhilfeangesuchTO.getSchuelerTO().getVorname()  + "', '" +  nachhilfeangesuchTO.getSchuelerTO().getEmailadresse()  + "', null , (select max(nachhilfegesuchid) from nachhilfegesuch)) ";	
		executeUpdateStatement(getConnection(),sql2);


		System.out.println("\nDie Nachhilfegesuch wurde erfolgreich aufgegeben.");

		
		 }
	catch (SQLException e) {
		e.printStackTrace();
	}
	}

	


public void nachhilfeangebotSehen(){

try {
		
		String sql ="select * from nachhilfeangebot join schulerdaten on schulerdaten.nachhilfeangebotid = nachhilfeangebot.nachhilfeangebotid";	
		ResultSet rset = executeQueryStatement(getConnection(),sql);

		//System.out.println("\nDie Nachhilfangebot sind folgendes:");
		
	while(rset.next()) {

		System.out.println("aufgebender Schüler :\n");
		System.out.println("	Name : "+rset.getString("schulername"));
		System.out.println("	Vorname: "+rset.getString("schulervorname"));
		System.out.println("	Emailadresse : "+rset.getString("schuleremailadresse"));
		System.out.println("	Fach : "+rset.getString("fach"));
		System.out.println("	Jahrgangstufe : "+rset.getString("jahrgangstufe"));
		System.out.println("	Fachbeherrschung : "+rset.getString("Fachbeherrschung"));
		System.out.println("	NachhilfeangebotID: "+rset.getString("nachhilfeangebotid")+"\n");

		
			}
	   
		
		 }
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	


public void nachhilfegesuchSehen(){

try {
		
	String sql ="select * from nachhilfegesuch join schulerdaten on schulerdaten.nachhilfegesuchid = nachhilfegesuch.nachhilfegesuchid";	
	ResultSet rset = executeQueryStatement(getConnection(),sql);
	
while(rset.next()) {

	System.out.println("suchender Schüler :\n");
	System.out.println("	Name : "+rset.getString("schulername"));
	System.out.println("	Vorname: "+rset.getString("schulervorname"));
	System.out.println("	Emailadresse : "+rset.getString("schuleremailadresse"));
	System.out.println("	Fach : "+rset.getString("fach"));
	System.out.println("	Jahrgangstufe : "+rset.getString("jahrgangstufe"));
	System.out.println("	NachhilfegesuchID: "+rset.getString("nachhilfegesuchid")+"\n");

	
		}

		
		 }
	catch (SQLException e) {
		e.printStackTrace();
	}
	}


public void nachhilfeangebotzuNachhilfegesuchMatchen(LehrerTO lehrerTO, int gesuchID ,int angebotID ){
	
	try {
		
		String sql = "insert into lehrerdaten values (null, '" + lehrerTO.getName() + "', '" + lehrerTO.getVorname() + "' , '" + angebotID+ "'  ,'" + gesuchID + "' )"; 
		executeUpdateStatement(getConnection(),sql);
		
		System.out.println("Matching erfolgreich ^.^");
	
	
}
	catch (SQLException e) {
		e.printStackTrace();
	}
}




public void gematchteAngebotUndGesucheSehen() {
	
try {
		
		String sql = "select lehrername , schulername as \"suchender Schüler Name\" , schulervorname as \"suchender Schüler Vorname\", schuleremailadresse from lehrerdaten "
				+ "join schulerdaten on lehrerdaten.nachhilfegesuchid = schulerdaten.nachhilfegesuchid join nachhilfeangebot on lehrerdaten.nachhilfeangebotid = nachhilfeangebot.nachhilfeangebotid";
		
		String sql1 = "select lehrername , schulername as \"anbietender Schüler Name\" , schulervorname as \"anbietender Schüler Vorname\", schuleremailadresse from lehrerdaten "
				+ "join schulerdaten on lehrerdaten.nachhilfeangebotid = schulerdaten.nachhilfeangebotid join nachhilfegesuch on lehrerdaten.nachhilfegesuchid = nachhilfegesuch.nachhilfegesuchid";
		
		
		executeQueryStatement(getConnection(),sql);
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
		executeQueryStatement(getConnection(),sql1);
		ResultSet rset1 = executeQueryStatement(getConnection(),sql1);

		
		
		while(rset.next() && rset1.next()) {
	 		
	  System.out.println("\n"+"Der Lehrer "+ rset.getString("lehrername")+" hat den folgenden Nachhilfegesuch zum Nachhilfeangebot gematchet:"+"\n" );
	  
	  
	  System.out.println("Nachhilfegesuch :");
      System.out.println("\n"+"suchender Schüler Name : " + rset.getString("suchender Schüler Name"));
      System.out.println("suchender Schüler Vorname : " + rset.getString("suchender Schüler Vorname"));
      System.out.println("suchender Schüler Email-Adresse : "+ rset.getString("schuleremailadresse")+"\n");
      
      System.out.println("Nachhilfeangebot :");
      System.out.println("\n"+"anbietender Schüler Name :"+rset1.getString("anbietender Schüler Name"));
      System.out.println("anbietender Schüler Vorname : " + rset1.getString("anbietender Schüler Vorname"));
      System.out.println("anbietender Schüler Email-Adresse : "+rset1.getString("schuleremailadresse")+"\n");
}


		     
}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}




}
