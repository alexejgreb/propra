
import java.sql.Connection;

import java.sql.DriverManager;

public class Database1 {

	
		
		
	//	Connection con = null;
		public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Haith\\Desktop\\Projekt1\\Projekt1.db");
			System.out.println("SQLITE DB CONNECTED");
			return con;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}

	}}
