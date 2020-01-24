package LogicLayer;
import DataLayer.DataBaseConnector;
import DataLayer.Question;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DB_Anfragen {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();

    public static void Table_Jahr_QuizTeilnehmer(JTable t,int J1, int J2) {

        con = DataBaseConnector.dbConnectorMariaDB();
        //con=Database1.dbConnector();

        try {
            String query = "select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Jahr from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '" + J1 + "' and '" + J2 + "' group by PlannedGames.Jahr ";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void Table_Monat_QuizTeilnehmer(JTable t,int M1, int M2) {

            con = DataBaseConnector.dbConnectorMariaDB();
            //con=Database1.dbConnector();

            try {
                String query="select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Monat from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat BETWEEN '"+M1+"' and '"+M2+"' group by PlannedGames.Monat ASC";
                PreparedStatement pst=con.prepareStatement(query);
                ResultSet rs= pst.executeQuery();
                t.setModel(DbUtils.resultSetToTableModel(rs));


            } catch (Exception e) {
                e.printStackTrace();
            }

    }



}
