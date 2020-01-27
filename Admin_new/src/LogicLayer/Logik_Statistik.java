package LogicLayer;

import DataLayer.DataBaseConnector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


    public static void Statistik__QuizTeilnehmer(JLabel label1,JLabel label2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Regestrierte_QuizTeilnehmer from Kunde_Spiel where Kunde_Spiel.Kunden_Nr=0";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Regestrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Regestrierte_QuizTeilnehmer from Kunde_Spiel where Kunde_Spiel.Kunden_Nr>0";

            PreparedStatement pst2=con.prepareStatement(query2);

            ResultSet rs2= pst2.executeQuery();

            while (rs2.next()) {
                String Regestrierte_QuizTeilnehmer = rs2.getString("Regestrierte_QuizTeilnehmer");
                label1.setText(Regestrierte_QuizTeilnehmer);

            }
            pst2.close();
            int x1 = Integer.parseInt(label2.getText())	;
            int x2 = Integer.parseInt(label1.getText())	;
            dataset.setValue(x1,"","Registrierte Quiz_Teilnehmer");
            dataset.setValue(x2,"","Nicht Registrierte Quiz_Teilnehmer");
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


    public static void Statistik_JahrUNDMonat_QuizTeilnehmer(JLabel label1,JLabel label2,int Jahr1,int Jahr2,int Monat1,int Monat2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Monat from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr BETWEEN '"+Jahr1+"'and '"+Jahr2+"' and PlannedGames.Monat BETWEEN '"+Monat1+"' and '"+Monat2+"'group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("Anzahl_QuizTeilnehmer");
                label2.setText(Anzahl_QuizTeilnehmer);
                String Jahr = rs.getString("PlannedGames.Monat");
                label1.setText(Jahr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProMonat","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }

    public static void Statistik_JahrUNDMonatUNDKnr_QuizTeilnehmer(JLabel label1,JLabel label2,int Jahr1,int Jahr2,int Monat1,int Monat2,int K) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Monat from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr BETWEEN '"+Jahr1+"'and '"+Jahr2+"' and PlannedGames.Monat BETWEEN '"+Monat1+"' and '"+Monat2+"' and PlannedGames.Barowner='"+K+"'group by PlannedGames.Monat";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("Anzahl_QuizTeilnehmer");
                label2.setText(Anzahl_QuizTeilnehmer);
                String Jahr = rs.getString("PlannedGames.Monat");
                label1.setText(Jahr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProMonat_KneipeNR'"+K+"'","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }
    public static void Statistik_JahrUNDKnr_QuizTeilnehmer(JLabel label1,JLabel label2,int Jahr1,int Jahr2,int K) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Jahr as Jahr from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr BETWEEN '"+Jahr1+"'and '"+Jahr2+"' and PlannedGames.Barowner='"+K+"'group by PlannedGames.Monat";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("Anzahl_QuizTeilnehmer");
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProJahr_KneipeNR'"+K+"'","Jahr", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }
    public static void Statistik_MonatUNDKnr_QuizTeilnehmer(JLabel label1,JLabel label2,int Monat1,int Monat2,int K) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr), PlannedGames.Monat from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+Monat1+"' and '"+Monat2+"' and PlannedGames.Barowner='"+K+"' group by PlannedGames.Monat ";

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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Monat_Kneipe_Nr '"+K+"'","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }




    public static void Statistik_Knr_QuizTeilnehmer(JLabel label1,JLabel label2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Anzahl_QuizTeilnehmer, PlannedGames.Barowner as Kneipe_Nr from Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID group by PlannedGames.Barowner";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_QuizTeilnehmer= rs.getString("Anzahl_QuizTeilnehmer");
                label2.setText(Anzahl_QuizTeilnehmer);
                String Bar_Nr = rs.getString("Kneipe_Nr");
                label1.setText(Bar_Nr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Kneipe","Kneipe_Nr", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }



}
