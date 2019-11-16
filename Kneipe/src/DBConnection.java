
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static int bar_id = 0;
	private static Statement stmt = null;
	private static Connection con = null;
	
	public static void initializeDB(String adresse, String benutzer, String password) { 
		//
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(adresse, benutzer, password);
		System.out.println("Verbunden!" + con.getMetaData().getDatabaseProductName());
		stmt = con.createStatement();
		
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeDB() {
		 try {
			if (stmt != null)
			 	stmt.close();
			if (con != null)
		   		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	   		
	   		con = null;
	   		stmt = null;
	}
	
	public static int registerBar(String name, String street, String place, String plz, String password) {
														//TODO
		//initializeDB();
		try {
			//neuer Eintrag für Kneipe in Tabelle Kneipen erstellen
			stmt.executeUpdate("INSERT INTO Kneipen(name, street, place, plz) VALUES (" + "\"" + name + "\"" + ", " + "\"" + street + "\"" + ", " 
			+ "\"" + place + "\"" + ", " + "\"" + plz + "\"" + ", " + "\"" + password + "\"" + ");");
			
			//bar_id holen
			ResultSet res = stmt.executeQuery("SELECT * FROM Kneipen WHERE name = " + "\"" + name + "\"" + "AND password = " + "\"" + password + "\"" + ";");
			while (res.next()) {
				bar_id = res.getInt("bar_id");
			}
			res.close();
			//closeDB();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bar_id;
	}
	
	public static boolean checkIfBarExistent(int barId, String password) {
		//Prüft beim Login, ob Bar registriert ist 
		bar_id = barId; 
		boolean existent = false;
		

		try {
			ResultSet res = stmt.executeQuery("SELECT * FROM Kneipen WHERE id = " + barId + "AND password = " + "\"" + password + "\"" + ";");
			if ( res.next()) {
				existent = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existent;
	}
	
	public static void insertBarQuestion(String question, String answer_1, String answer_2, String answer_3, String answer_4, String correct_answer) {
		//TODO
		
		try {
			
			stmt.executeUpdate("INSERT INTO Fragen(question, answer_1, answer_2, answer_3, answer_4, correct_answer, bar_id) VALUES (" + "\"" + question + "\"" + ", " + "\"" +
			answer_1 + "\"" + ", " + "\"" + answer_2 + "\"" + ", " + "\"" + answer_3 + "\"" + ", " + "\"" + answer_4 + "\"" + ", " + "\"" + correct_answer +
			"\"" + ", " + bar_id + ");");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//update frage
	public static void main(String[] args) {
		initializeDB();		//adresse eingeben
		//methode
		closeDB();
	}
	


}
