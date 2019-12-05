package LogicLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataLayer.DataBaseConnector;

public class Login {
    public static Connection con = DataBaseConnector.dbConnectorMariaDB();
    public static Guest guest = new Guest(0, "","","",0,0);;

    public static void registerGuest(String userName, String email, String password) {

    String password_hash = hashString(password);
    //Connection con = DataBaseConnector.dbConnectorMariaDB();
    String insert = "INSERT INTO Kunden_Info (Benutzername, Email, Passwort) VALUES (?,?,?)";
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
        //Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunden_Info WHERE Email = '" + email + "' AND Passwort = '" + password_hash + "'";
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

        //Connection con = DataBaseConnector.dbConnectorMariaDB();
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
        //String password_hash = hashString(password);
       // Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT KundenNr FROM Kunden_Info WHERE Email = '" + email + "' AND Passwort = '" + password + "'";

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
        //Connection con = DataBaseConnector.dbConnectorMariaDB();
        String update = "UPDATE Kunde_Spiel SET Kunden_Nr = '" + guestID + "'WHERE ID_Nummer = '" + idNr + "'";
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

        Connection con = DataLayer.DataBaseConnector.dbConnector();
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
    /*überprüft ob die ID_Nummer noch gültig ist. ID-Nummer ist gültig wenn sie auf 1 ist*/
    public static boolean checkIfIDNrValid(int idNr){

        //Connection con = DataBaseConnector.dbConnectorMariaDB();

        boolean contains = false;
        String query = "SELECT* FROM Kunde_Spiel WHERE ID_Nummer = '" + idNr + "'AND Vermerk = '" + 1 + "'";

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
    /*setzt Vermerk 0. Das bedeutet, dass ID verbraucht wurde.*/
    public static void setValid0InKundeSpiel(int idNr){

        //Connection con = DataBaseConnector.dbConnectorMariaDB();
        String update = "UPDATE Kunde_Spiel SET Vermerk = '" + 0 + "'WHERE ID_Nummer = '" + idNr + "'";

        try {

            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException se){
            se.printStackTrace();
        }

    }
/*speichert Kundeninformationen zwischen*/
    public static void saveGuestInfo(String email, String password) {

        int guestID_tmp;
        String userName_tmp;
        String email_tmp;
        String password_tmp;

        String password_hash = hashString(password);
        //Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunden_Info WHERE Email = '" + email + "' AND Passwort = '" + password_hash + "'";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while(res.next()){
               guestID_tmp = res.getInt(1);
               userName_tmp = res.getString(2);
               email_tmp = res.getString(3);
               password_tmp = res.getString(4);
               //points_tmp = res.getInt(5);


               // guest = new Guest(guestID_tmp, userName_tmp,email_tmp,password_tmp,0,0);
                guest.setGuestID(guestID_tmp);
                guest.setUserName(userName_tmp);
                guest.setEmail(email_tmp);
                guest.setPassword(password_tmp);
            }
            res.close();
            pstmt.close();

        } catch(SQLException se) {
            se.printStackTrace();
        }

    }
    /*Speichert bei Eingabe der IDNummer, die IDNummer und SpielNr im static Objekt guest*/
    public static void saveGameAndIDNumber(int idNr){

        int tmpGameNumber;
        int tmpIDNumber;

        //Connection con = DataBaseConnector.dbConnectorMariaDB();
        String query = "SELECT* FROM Kunde_Spiel WHERE ID_Nummer = '" + idNr + "'";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while(res.next()){

                tmpGameNumber = res.getInt(2);
                tmpIDNumber = res.getInt(3);

               guest.setGameNumber(tmpGameNumber);
               guest.setIDNumber(tmpIDNumber);
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
