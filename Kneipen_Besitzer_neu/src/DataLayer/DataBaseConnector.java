package DataLayer;
/*

import java.sql.Connection;


import java.sql.DriverManager;

public class DataLayer.Database{

	
		
		
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


	*/

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {

    private static String serverAddress = null;
    private static String serverUsername = null;
    private static String serverPassword = null;

    public static String getServerAddress() {
        return serverAddress;
    }

    public static void setServerAddress(String serverAddress) {
        DataBaseConnector.serverAddress = serverAddress;
    }

    public static String getServerUsername() {
        return serverUsername;
    }

    public static void setServerUsername(String serverUsername) {
        DataBaseConnector.serverUsername = serverUsername;
    }

    public static String getServerPassword() {
        return serverPassword;
    }

    public static void setServerPassword(String serverPassword) {
        DataBaseConnector.serverPassword = serverPassword;
    }

    ///	Connection con = null;
    public static Connection dbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverAddress, serverUsername, serverPassword);
            System.out.println("DB CONNECTED");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}

