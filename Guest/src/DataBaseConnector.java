import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnector {

    //	Connection con = null;
    public static Connection dbConnector() {
        try {
            Class.forName("org.sqlite.JDBC");

            SQLiteConfig sqLiteConfig = new SQLiteConfig();
            Properties properties = sqLiteConfig.toProperties();
            properties.setProperty(SQLiteConfig.Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd HH:mm:ss");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Projekt1.db", properties);
            System.out.println("SQLITE DB CONNECTED");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}

