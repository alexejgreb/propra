package DataLayer;

import LogicLayer.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PointQuizHandler {
    Connection con = DataBaseConnector.dbConnectorMariaDB();

    public  void setPointsGuestForBarOwner (int points){
        //Punkte des abgschlossenen Quiz werdern unter Punkte in Kunde_Spiel gespeichert, dabei wird ID_Nummer aus dem Objekt guest als Identifier verwendet.

        int idNr = Login.guest.getIDNumber();
        //zum Testen:
        //int idNr = 100000;
        String update = "UPDATE Kunde_Spiel SET Punkte = '" + points + "'WHERE ID_Nummer = '" + idNr + "'";
        try {

            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void setPointsForCustomer (int pointsOfQuiz) {
        //Punkte des aktuellen Spiels in Kunden_Info unter AktuellePunkte speichern

        //zum Testen:
        //int guestID = 100000;
        int guestID = Login.guest.getGuestID();
        if(guestID!=0) {
            String update = "UPDATE Kunden_Info SET AktuellePunkte = '" + pointsOfQuiz + "'WHERE KundenNr = '" + guestID + "'";
            try {

                PreparedStatement pstmt = con.prepareStatement(update);
                pstmt.execute();
                pstmt.close();

            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void setTotalPointsforCustomer(int pointsOfQuiz) {
        //erhöht die 'Punkte' in der Tabelle Kunden_Info um die erspielten Punkte nach einem Spiel.

        //zum Testen:
        //int guestID = 100000;
        int guestID = Login.guest.getGuestID();
        if(guestID!=0) {
            String update = "UPDATE Kunden_Info SET Punkte = Punkte +'" + pointsOfQuiz + "'WHERE KundenNr = '" + guestID + "'";
            try {

                PreparedStatement pstmt = con.prepareStatement(update);
                pstmt.execute();
                pstmt.close();

            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }



}
