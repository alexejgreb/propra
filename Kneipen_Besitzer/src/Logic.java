import java.sql.Connection;

public class Logic {
    public static Connection con =null;
    public Logic(){
        con=DataBaseConnector.dbConnectorMariaDB();
    }
    public void randomQuestion(){
        con = DataBaseConnector.dbConnectorMariaDB();
    }

    public void howManyQuestion(){
        con = DataBaseConnector.dbConnectorMariaDB();
        String query="select count FROM FragenPool WHERE Besitzer ='"+0+"'";

    }
}
