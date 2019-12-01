package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PointQuizHandler {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
    public void setTotalPointsGuest (){

        //TODO update TotalPoints

       // String update = "UPDATE Kunde_Spiel2 SET Kunden_Nr = '" + guestID + "'WHERE ID_Nummer = '" + idNr + "'";
        //TODO
       // try {

       //     PreparedStatement pstmt = con.prepareStatement(update);
       //     pstmt.execute();
       //     pstmt.close();

       // } catch (
       //         SQLException se){
       //     se.printStackTrace();
       // }
    }

}
