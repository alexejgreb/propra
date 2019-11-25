import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static Guest guest;

    public static void registerGuest(String userName, String email, String password) {

    String password_hash = hashString(password);
    Connection con = DataBaseConnector.dbConnectorMariaDB();
    String insert = "INSERT INTO Kunden_Info2 (Benutzername, Email, Passwort) VALUES (?,?,?)";
    ///TODO Tabelle umbennen
    try {
        PreparedStatement pstmt = con.prepareStatement(insert);
        pstmt.setString(1, userName);
        pstmt.setString(2, email);
        pstmt.setString(3, password_hash);
        pstmt.executeUpdate();
        pstmt.close();
    } catch (SQLException se) {
        se.printStackTrace();
    }
}
    /*überprüft ob der Kunde bereits registriert ist,
    wenn der Kunde nicht in Kunden_Info ist dann wird false zurückgeliefert*/
    public static boolean checkIfRegistered(String email, String password ){

        String password_hash = hashString(password);
        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunden_Info2 WHERE Email = '" + email + "' AND Passwort = '" + password_hash + "'";
        boolean contains = false;

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            if(res.next()) {
                contains = true;
            }
            res.close();
            pstmt.close();
            return contains;
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return contains;
}
    /*gibt true zurück wenn IdNummer übereinstimmen.*/
    public static boolean checkIdNumber(int idNr){

        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunde_Spiel WHERE ID_Nummer ='" + idNr + "'";
        boolean contains = false;

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            if(res.next()) {
                contains = true;
            }
            res.close();
            pstmt.close();
            return contains;
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return contains;
    }
    /*Hilfsfunktion, um in Tabelle Kunde_Spiel KundenNr zu setzen*/
    public static int getGuestID(String email, String password){

        int guestID = 0;
        String password_hash = hashString(password);
        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT KundenNr FROM Kunden_Info2 WHERE Email = '" + email + "' AND Passwort = '" + password_hash + "'";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()){
                guestID = res.getInt("KundenNr");
            }
            res.close();
            pstmt.close();
            return guestID;
        } catch (SQLException se){
            se.printStackTrace();
        }
        return guestID;
    }
    /*Setzt die Kundennummer in Kunde_Spiel ein*/
    public static void setGuestIDInKunde_Spiel(String email, String password, int idNr){

        int guestID = getGuestID(email, password);
        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String update = "UPDATE Kunde_Spiel SET KundenNr = '" + guestID + "'WHERE ID_Nummer = '" + idNr + "'";
        //TODO
        try {

            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException se){
            se.printStackTrace();
        }
    }
    /*ohne Konto/Account wird in Kunde_Spiel die Kundennummer auf 0 gesetzt*/
  /*  public static void setAnonymousInKunde_Spiel(int idNr){

        Connection con = DataBaseConnector.dbConnector();
        int guestID = 0;
        String update = "UPDATE Kunde_Spiel SET Kunden_Nr = '" + guestID + "'WHERE ID_Nummer = '" + idNr + "'";

        try {

            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.execute();
            pstmt.close();

        } catch(SQLException se){
            se.printStackTrace();
        }

    }*/
    /*überprüft ob die ID_Nummer noch gültig ist.*/
    public static boolean checkIfIDNrValid(int idNr){

        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunde_Spiel WHERE ID_Nummer = '" + idNr + "'";
        boolean contains = false;
       // String query = "SELECT* FROM Kunde_Spiel WHERE ID_Nummer = '" + idNr + "'AND Gültigkeit = '" + 0 + "'";
        //TODO einfügen von Attribut: Gültigkeit?
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            if(res.next()){
                contains = true;
            }
            res.close();
            pstmt.close();
            return contains;
        }catch (SQLException se){
            se.printStackTrace();
        }
        return contains;
    }
/*speichert Kundeninformationen zwischen*/
    public static void saveGuestInfo(String email, String password) {

        int guestID_tmp;
        String userName_tmp;
        String email_tmp;
        String password_tmp;
        //int points_tmp;
        String password_hash = hashString(password);
        Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunden2_Info WHERE Email = '" + email + "' AND Passwort = '" + password_hash + "'";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while(res.next()){
               guestID_tmp = res.getInt(1);
               userName_tmp = res.getString(2);
               email_tmp = res.getString(3);
               password_tmp = res.getString(4);
               //points_tmp = res.getInt(5);
                guest = new Guest(guestID_tmp, userName_tmp, email_tmp, password_tmp);
            }
            res.close();
            pstmt.close();

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    /*wandelt Password in einen Hashwert um*/
    public static String hashString(String s) {

        String result;
        int first = 27;
        int second = 14;
        int hash = 0;

        for(int i = 0; i < s.length(); i++) {
            hash = first * hash + s.charAt(i);
        }
        for(int i = 0; i < s.length(); i++) {
            hash = second * hash + s.charAt(i);
        }
        result = hash + "";
        return result;
    }
}
