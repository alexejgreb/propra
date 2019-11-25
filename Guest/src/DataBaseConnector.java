
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    //	Connection con = null;
    public static Connection dbConnectorMariaDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("");
            System.out.println("DB CONNECTED");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}

