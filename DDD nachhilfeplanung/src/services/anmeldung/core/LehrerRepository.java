package services.anmeldung.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LehrerRepository {

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
		Statement stmt = aConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		aResultSet =  stmt.executeQuery(aStatement);
		
		return aResultSet;
	}
	
public void getAllSchueler() {
		
	}
	
	public void addSchueler(){
		
	}
}
