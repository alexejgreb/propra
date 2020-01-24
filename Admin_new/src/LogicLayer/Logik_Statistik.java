package LogicLayer;
import DataLayer.DataBaseConnector;
import LogicLayer.DB_Anfragen;
import LogicLayer.Logic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import DataLayer.DataBaseConnector;
import DataLayer.Question;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
public class Logik_Statistik {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();

    public static void Statistik_Jahr_QuizTeilnehmer(JLabel label1,JLabel label2,int Jahr1,int Jahr2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr), PlannedGames.Jahr from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '"+Jahr1+"' and '"+Jahr2+"' group by PlannedGames.Jahr ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("count(Kunde_Spiel.Kunden_Nr)");
                label2.setText(Anzahl_QuizTeilnehmer);
                String Jahr = rs.getString("PlannedGames.Jahr");
                label1.setText(Jahr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Jahr","Jahr", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }



    public static void Statistik_Monat_QuizTeilnehmer(JLabel label1,JLabel label2,int Monat1,int Monat2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr), PlannedGames.Monat from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+Monat1+"' and '"+Monat2+"' group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("count(Kunde_Spiel.Kunden_Nr)");
                label2.setText(Anzahl_QuizTeilnehmer);
                String Monat = rs.getString("PlannedGames.Monat");
                label1.setText(Monat);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Monat","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


}
