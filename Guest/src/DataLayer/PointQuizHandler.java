package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PointQuizHandler {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();

    public void setPointsGuestForBarOwner (int points){

        //TODO Punkte des abgschlossenen Quiz unter Punkte in Kunde_Spiel speichern, dabei ID_Nummer als Identifier nutzen

       // String update = "UPDATE Kunde_Spiel ...;
       // try {

       //     PreparedStatement pstmt = con.prepareStatement(update);
       //     pstmt.execute();
       //     pstmt.close();

       // } catch (
       //         SQLException se){
       //     se.printStackTrace();
       // }
    }

    public void setPointsForCustomer (int pointsOfQuiz) {
        //TODO Punkte des aktuellen Spiels in Kunden_Info unter AktuellePunkte speichern
    }

    public void setTotalPointsforCustomer(int pointsOfQuiz) {
        //TODO hole aktuellen Stand von "Punkte" unter "Kunden_Info" und erhöhe ihn um die Punkte des Quizes (pointsOfQuiz)
    }



}
