

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {

    private static String serverAddress = null;
    private static String serverUsername = null;
    private static String serverPassword = null;

    public static void setServerAddress(String serverAddress) {
        DataBaseConnector.serverAddress = serverAddress;
    }

    public static void setServerUsername(String serverUsername) {
        DataBaseConnector.serverUsername = serverUsername;
    }


    public static void setServerPassword(String serverPassword) {
        DataBaseConnector.serverPassword = serverPassword;
    }


    public static Connection dbConnectorMariaDB() {
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