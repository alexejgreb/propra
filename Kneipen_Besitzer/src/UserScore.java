import java.sql.Connection;

public class UserScore {

    public static void getUserScore(){

        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String s = "SELECT* ID_Nummer, Punkte FROM Kunden_Spiel WEHER Spiel_Nr = "+907;

    }
}
