package infrastructure.datastore.anmeldung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import services.anmeldung.ports.primary.LehrerTO;
import services.anmeldung.ports.primary.SchuelerTO;
import services.anmeldung.ports.secondary.IAnmeldungDAO;

public class AnmeldungDAO implements IAnmeldungDAO {
	
	private static AnmeldungDAO instance; 
	
		public static Connection getConnection(){
			
			Connection aConnection = null;
			
			try {
				/*
				 * Hier den Namen des JDBC-Treibers angeben. Damit der auch gefunden wird, muss
				 * das jar-File in Eclipse unter 
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
//			System.out.println(aStatement);
			Statement stmt = aConnection.createStatement();
			stmt.executeUpdate(aStatement);
			
		}
		
		public static ResultSet executeQueryStatement(Connection aConnection, String aStatement) throws SQLException{
			ResultSet aResultSet = null;
//			System.out.println("DEBUG: "+aStatement);
			Statement stmt = aConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			aResultSet =  stmt.executeQuery(aStatement);
			
			return aResultSet;
		}
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
		public static AnmeldungDAO getInstance() {
			return (instance == null? new AnmeldungDAO(): instance);
		}
		
	public void benutzerDatenAnlegen(SchuelerTO schulerTO) {

		
		try {
		
			String sql ="select * from schuler where benutzername = '"+ schulerTO.getBenutzername()+"' ";
			
			ResultSet rset = executeQueryStatement(getConnection(),sql);
	
			
			 if (rset.next()) {
	               
				 
	               System.out.println("\nDer Benutzername ist schon vorhanden, wählen Sie bitte einen anderen aus.");
	                
	            } else {
	         
	            	String sql1 = " insert into schuler values(null,'"+ schulerTO.getBenutzername()+"','"+ schulerTO.getPasswort()+"')";
	    			executeUpdateStatement(getConnection(),sql1);
	    			
	    			System.out.println("\nSie sind erfolgreich registriert");
			
		}
			 }
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public void benutzerDatenAnlegen(LehrerTO lehrerTO) {

		
		try {
			
String sql ="select * from lehrer where benutzername = '"+ lehrerTO.getBenutzername()+"' ";
			
			ResultSet rset = executeQueryStatement(getConnection(),sql);
	
			
			 if (rset.next()) {
	  
				 
	                System.out.println("\nDer Benutzername ist schon vorhanden, wählen Sie bitte einen anderen aus.");
	                
	            } else {
	         
	            	String sql1 = " insert into lehrer values(null,'"+ lehrerTO.getBenutzername()+"','"+ lehrerTO.getPasswort()+"')";
	    			executeUpdateStatement(getConnection(),sql1);
	    			
	    			System.out.println("\nSie sind erfolgreich registriert");
			
			}

			}catch (SQLException e) {
			e.printStackTrace();
		}
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public boolean benutzerAnmelden(SchuelerTO schulerTO) {
	
	try {
		
		String sql="select * from schuler";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		while(rset.next()) {

		if( schulerTO.getBenutzername().equals(rset.getString("benutzername")) && schulerTO.getPasswort().equals(rset.getString("passwort")) ) {
				
			System.out.println("Sie haben sich erfolgreich angemeldet.");
			return true;		}
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	System.out.println("falsche Benutzerdaten, bitte melden sie sich erneut an");
	return false;
	
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public boolean benutzerAnmelden(LehrerTO lehrerTO) {
	
	try {
		
		String sql="select * from lehrer";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		while(rset.next()) {

		if( lehrerTO.getBenutzername().equals(rset.getString("benutzername")) && lehrerTO.getPasswort().equals(rset.getString("passwort")) ) {
				
			System.out.println("Sie haben sich erfolgreich angemeldet.");
			return true;		}
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	System.out.println("falsche Benutzerdaten, bitte melden sie sich erneut an");
	return false;
	
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//SCHULER
//BENUTZERNAME

public void benutzerDatenAendernBenutzername(SchuelerTO schulerTO1 , SchuelerTO schulerTO2) {

	try {
		
		String sql= "select * from schuler where benutzername = '"+ schulerTO1.getBenutzername() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	
		while(rset.next()) {
			
			if(schulerTO2.getBenutzername().equals(schulerTO1.getBenutzername())){
				
				 System.out.println("\nDer Benutzername ist schon vorhanden, wählen Sie bitte einen anderen aus.");	
				 break;
			}
	      
        else {
     
		 String sql1 = "update schuler set benutzername ='"+ schulerTO2.getBenutzername() +"'"+" where benutzername  ='" + schulerTO1.getBenutzername()+"'";
			executeUpdateStatement(getConnection(),sql1);
			System.out.println("\nder Benutzername wurde erfolgreich geändert");
			break;
			
			}
	}
		}
		
	
	catch (SQLException e) {
		
		e.printStackTrace();
	}
}




// PASSWORT

public void benutzerDatenAendernPasswort(SchuelerTO schulerTO3 , SchuelerTO schulerTO4) {

	try {
		
		String sql= "select * from schuler where passwort = '"+ schulerTO3.getPasswort() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	    
		if(rset.next()) {
			
			if(schulerTO3.getPasswort().equals(schulerTO4.getPasswort())){
				
				 System.out.println("\nDas Passwort ist schon vorhanden, wählen Sie bitte einen anderen aus.");	
			}
	      
        else {
     
		 String sql1 = "update schuler set passwort ='"+ schulerTO4.getPasswort() +"'"+" where passwort  ='" + schulerTO3.getPasswort()+"'";
			executeUpdateStatement(getConnection(),sql1);
			System.out.println("\ndas Passwort wurde erfolgreich geändert");
		
			
			}
	}
		}
		
		
	
	catch (SQLException e) {
		
		e.printStackTrace();
	}
}



//PASSWORT UND BENUTZERNAME


public void benutzerDatenAendernBenutzernameUndPasswort(SchuelerTO schulerTO5 , SchuelerTO schulerTO6) {

	try {
		
		String sql= "select * from schuler where benutzername = '"+ schulerTO5.getBenutzername() +"' and passwort = '" + schulerTO5.getPasswort() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	    
		if(rset.next()) {
			
			if(schulerTO5.getBenutzername().equals(schulerTO6.getBenutzername()) && schulerTO5.getPasswort().equals(schulerTO6.getPasswort())){
				
				 System.out.println("\n Der Benutzername und das Passwort sind schon vorhanden, wählen Sie bitte anderen aus.");	
			}
	      
        else {
     
		 String sql1 = "update schuler set benutzername ='"+ schulerTO6.getBenutzername() +"'"+", passwort ='"+ schulerTO6.getPasswort() +"'"+" where benutzername  ='" + 
		 schulerTO5.getBenutzername()+"'"+"and passwort ='"+schulerTO5.getPasswort()+"'";
		 
			executeUpdateStatement(getConnection(),sql1);
			
			System.out.println("\nder Benutzer Name sowie das Passwort wurden erfolgreich geändert");
		
			
			}
	}
		}
		
		
	
	catch (SQLException e) {
		
		e.printStackTrace();
	}
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Lehrer
//BENUTZERNAME

public void benutzerDatenAendernBenutzername(LehrerTO lehrerTO1 , LehrerTO lehrerTO2) {

	try {
		
		String sql= "select * from lehrer where benutzername = '"+ lehrerTO1.getBenutzername() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	
		while(rset.next()) {
			
			if(lehrerTO2.getBenutzername().equals(lehrerTO1.getBenutzername())){
				
				 System.out.println("\nDer Benutzername ist schon vorhanden, wählen Sie bitte einen anderen aus.");	
				 break;
			}
	      
      else {
   
		 String sql1 = "update lehrer set benutzername ='"+ lehrerTO2.getBenutzername() +"'"+" where benutzername  ='" + lehrerTO1.getBenutzername()+"'";
			executeUpdateStatement(getConnection(),sql1);
			System.out.println("\nder Benutzername wurde erfolgreich geändert");
			break;
			
			}
	}
		}
		
		
	
	catch (SQLException e) {
		
		e.printStackTrace();
	}
}




//PASSWORT

public void benutzerDatenAendernPasswort(LehrerTO lehrerTO3 , LehrerTO lehrerTO4) {

	try {
		
		String sql= "select * from lehrer where passwort = '"+ lehrerTO3.getPasswort() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	    
		if(rset.next()) {
			
			if(lehrerTO3.getPasswort().equals(lehrerTO4.getPasswort())){
				
				 System.out.println("\nDas Passwort ist schon vorhanden, wählen Sie bitte einen anderen aus.");	
			}
	      
      else {
   
		 String sql1 = "update lehrer set passwort ='"+ lehrerTO4.getPasswort() +"'"+" where passwort  ='" + lehrerTO3.getPasswort()+"'";
			executeUpdateStatement(getConnection(),sql1);
			System.out.println("\ndas Passwort wurde erfolgreich geändert");
		
			
			}
	}
		}
		
		
	
	catch (SQLException e) {
		
		e.printStackTrace();
	}
}



//PASSWORT UND BENUTZERNAME


public void benutzerDatenAendernBenutzernameUndPasswort(LehrerTO lehrerTO5 , LehrerTO lehrerTO6) {

	try {
		
		String sql= "select * from lehrer where benutzername = '"+ lehrerTO5.getBenutzername() +"' and passwort = '" + lehrerTO5.getPasswort() +"'";
		
		ResultSet rset = executeQueryStatement(getConnection(),sql);
		
		
	    
		if(rset.next()) {
			
			if(lehrerTO5.getBenutzername().equals(lehrerTO6.getBenutzername()) && lehrerTO5.getPasswort().equals(lehrerTO6.getPasswort())){
				
				 System.out.println("\n Der Benutzername und das Passwort sind schon vorhanden, wählen Sie bitte anderen aus.");	
			}
	      
      else {
   
		 String sql1 = "update lehrer set benutzername ='"+ lehrerTO6.getBenutzername() +"'"+", passwort ='"+ lehrerTO6.getPasswort() +"'"+" where benutzername  ='" + 
				 lehrerTO5.getBenutzername()+"'"+"and passwort ='"+lehrerTO5.getPasswort()+"'";
		 
			executeUpdateStatement(getConnection(),sql1);
			
			System.out.println("\nder Benutzer Name sowie das Passwort wurden erfolgreich geändert");
		
			
			}
					}
		}	
		
	catch (SQLException e) {
		
		e.printStackTrace();
							}
																									}
}