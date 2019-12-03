import java.sql.Connection;

public class UserScore {

    public void getUserScore(){
        String password_hash = hashString(password);
        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String s = "SELECT* ID_Nummer, Punkte FROM Kunden_Spiel WEHER Spiel_Nr = "+907;

    }
}
