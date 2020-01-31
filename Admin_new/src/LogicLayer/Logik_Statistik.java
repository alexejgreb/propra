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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Jahr/ Bewertung für den Zeitraum von dem Jahr'"+Jahr1+"' bis '"+Jahr2+"'","Jahr", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Monat / Bewertung für den Zeitraum von dem Monat'"+Monat1+"' bis '"+Monat2+"'\"","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste für alle Kneipen","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


    public static void Statistik__AnzahlQuiz(JLabel label1,JLabel label2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1=" select count(GameID)as Anzahl_Quiz,Barowner from PlannedGames  group by Barowner";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String  Anzahl_Erstellte_Quiz= rs.getString("Anzahl_Quiz");
                label1.setText(Anzahl_Erstellte_Quiz);
                String Kneipe_Nr = rs.getString("Barowner");
                label2.setText(Kneipe_Nr);
                int x1 = Integer.parseInt(label1.getText())	;

                dataset.setValue(x1,"",label2.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Kneipe","Barowner", "Anzahl_Erstellte_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }

    public static void Statistik__QuizTeilnehmer_t_M(JLabel label1,JLabel label2,int M1,int M2)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Regestrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Monat";

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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste / Bewertung für den Zeitraum von dem Monat'"+M1+"' bis '"+M2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }

    public static void Statistik__AnzahlQuiz_t_M(JLabel label1,JLabel label2,int M1,int M2)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1=" select count(GameID)as Anzahl_Quiz,Barowner from PlannedGames where Monat BETWEEN '"+M1+"' and '"+M2+"' group by Barowner";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String  Anzahl_Erstellte_Quiz= rs.getString("Anzahl_Quiz");
                label1.setText(Anzahl_Erstellte_Quiz);
                String Kneipe_Nr = rs.getString("Barowner");
                label2.setText(Kneipe_Nr);
                int x1 = Integer.parseInt(label1.getText())	;

                dataset.setValue(x1,"",label2.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Kneipe/ Bewertung für den Zeitraum von dem Monat'"+M1+"' bis '"+M2+"'","Jahr", "Anzahl_Erstellte_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


    public static void Statistik__QuizTeilnehmer_t_J(JLabel label1,JLabel label2,int J1,int J2)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Jahr ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Regestrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Jahr";

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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste  / Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }
    public static void Statistik__QuizTeilnehmer_Knrr_J(JLabel label1,JLabel label2,int J1,int J2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Jahr ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Registrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Jahr";

            PreparedStatement pst2=con.prepareStatement(query2);

            ResultSet rs2= pst2.executeQuery();

            while (rs2.next()) {
                String Regestrierte_QuizTeilnehmer = rs2.getString("Registrierte_QuizTeilnehmer");
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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste Pro Jahr Jneipe_Nr:'"+K+"'    / Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }

    public static void Statistik__QuizTeilnehmer_Knrr_M(JLabel label1,JLabel label2,int M1,int M2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Registrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Monat";

            PreparedStatement pst2=con.prepareStatement(query2);

            ResultSet rs2= pst2.executeQuery();

            while (rs2.next()) {
                String Regestrierte_QuizTeilnehmer = rs2.getString("Registrierte_QuizTeilnehmer");
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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste Pro Monat Jneipe_Nr:'"+K+"' / Bewertung für den Zeitraum von dem Monat'"+M1+"' bis '"+M2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


    public static void Statistik__ErstellteQuiz_Knrr_M(JLabel label1,JLabel label2,int M1,int M2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(GameID)as Anzahl_Quiz,Monat from PlannedGames where Monat BETWEEN '"+M1+"' and '"+M2+"' and Barowner='"+K+"'group by Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_Quiz= rs.getString("Anzahl_Quiz");
                label2.setText(Anzahl_Quiz);
                String Monat = rs.getString("Monat");
                label1.setText(Monat);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Monat/ Bewertung für den Zeitraum von dem Monat'"+M1+"' bis '"+M2+"'","Jahr", "Anzahl_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }





    public static void Statistik__QuizTeilnehmer_t_J(JLabel label1,JLabel label2,int M1,int M2,int J1,int J2)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Registrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Registrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Monat";

            PreparedStatement pst2=con.prepareStatement(query2);

            ResultSet rs2= pst2.executeQuery();

            while (rs2.next()) {
                String Regestrierte_QuizTeilnehmer = rs2.getString("Registrierte_QuizTeilnehmer");
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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste / Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"'  /  Für die Monate zwischen'"+M1+"' bis '"+M2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }



    public static void Statistik__AnzahlQuiz_t_J(JLabel label1,JLabel label2,int J1,int J2)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1=" select count(GameID)as Anzahl_Quiz,Jahr from PlannedGames where Jahr BETWEEN '"+J1+"' and '"+J2+"'  group by Jahr ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_Quiz= rs.getString("Anzahl_Quiz");
                label2.setText(Anzahl_Quiz);
                String Jahr = rs.getString("Jahr");
                label1.setText(Jahr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Jahr/ Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"'","Jahr", "Anzahl_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);
    }
    public static void Statistik__QuizTeilnehmer_t_J_Knrr(JLabel label1,JLabel label2,int M1,int M2,int J1,int J2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(Kunde_Spiel.Kunden_Nr)as Nicht_Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"' and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr=0 group by PlannedGames.Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String Nicht_Regestrierte_QuizTeilnehmer = rs.getString("Nicht_Regestrierte_QuizTeilnehmer");
                label2.setText(Nicht_Regestrierte_QuizTeilnehmer);
            }
            pst.close();
            String query2="select count(Kunde_Spiel.Kunden_Nr)as Regestrierte_QuizTeilnehmer from  Kunde_Spiel,PlannedGames where Kunde_Spiel.Spiel_Nr = PlannedGames.GameID and PlannedGames.Monat between  '"+M1+"' and '"+M2+"' and PlannedGames.Jahr between  '"+J1+"' and '"+J2+"'  and PlannedGames.Barowner='"+K+"' and Kunde_Spiel.Kunden_Nr>0 group by PlannedGames.Monat";

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

        JFreeChart chart = ChartFactory.createBarChart("Registrierte VS nicht Registrierte Gäste Kneipe_Nr:'"+K+"'  / Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"'  /  Für die Monate zwischen'"+M1+"' bis '"+M2+"'","", "Anzahl_Gäste", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }

    public static void Statistik__AnzahlQuiz_t_J_Knrr(JLabel label1,JLabel label2,int J1,int J2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(GameID)as Anzahl_Quiz,Jahr from PlannedGames where Jahr BETWEEN '"+J1+"' and '"+J2+"' and Barowner='"+K+"' group by Jahr ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_Quiz= rs.getString("Anzahl_Quiz");
                label2.setText(Anzahl_Quiz);
                String Jahr = rs.getString("Jahr");
                label1.setText(Jahr);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Jahr/ Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"' für die Kneipe_Nr:'"+K+"'","Jahr", "Anzahl_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);
    }


    public static void Statistik__AnzahlQuiz_M_J_Knrr(JLabel label1,JLabel label2,int J1,int J2,int M1,int M2,int K)
    {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1="select count(GameID)as Anzahl_Quiz,Monat from PlannedGames where Jahr BETWEEN '"+J1+"' and '"+J2+"' and Monat BETWEEN '"+M1+"' and '"+M2+"' and Barowner='"+K+"' group by Monat ";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String  Anzahl_Quiz= rs.getString("Anzahl_Quiz");
                label2.setText(Anzahl_Quiz);
                String Monat = rs.getString("Monat");
                label1.setText(Monat);
                int x1 = Integer.parseInt(label2.getText())	;

                dataset.setValue(x1,"",label1.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Monat/ Bewertung für den Zeitraum von dem Jahr'"+J1+"' bis '"+J2+"' und die Monate zwischen '"+M1+"' und '"+M2+"' für die Kneipe_Nr:'"+K+"'","Monat", "Anzahl_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProMonat / Bewertung für den Zeitraum von dem Jahr'"+Jahr1+"' bis '"+Jahr2+"'  /  Für die Monate zwischen'"+Monat1+"' bis '"+Monat2+"'","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProMonat_KneipeNR'"+K+"'  / Bewertung für den Zeitraum von dem Jahr'"+Jahr1+"' bis '"+Jahr2+"'  /  Für die Monate zwischen'"+Monat1+"' bis '"+Monat2+"'","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.green);
        ChartFrame frame1= new ChartFrame("",chart);

        frame1.setVisible(true);
        frame1.setSize(500,500);


    }


    public static void Statistik_JahrUNDMonat_AnzahlQuiz(JLabel label1,JLabel label2,int Jahr1,int Jahr2,int Monat1,int Monat2) {

        con = DataBaseConnector.dbConnectorMariaDB();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        try{
            String query1=" select count(GameID)as Anzahl_Quiz,Monat from PlannedGames where Jahr BETWEEN '"+Jahr1+"'and '"+Jahr2+"' and Monat BETWEEN '"+Monat1+"' and '"+Monat2+"' group by Monat";

            PreparedStatement pst=con.prepareStatement(query1);

            ResultSet rs= pst.executeQuery();

            while (rs.next()) {
                String  Anzahl_Erstellte_Quiz= rs.getString("Anzahl_Quiz");
                label1.setText(Anzahl_Erstellte_Quiz);
                String Monat = rs.getString("Monat");
                label2.setText(Monat);
                int x1 = Integer.parseInt(label1.getText())	;

                dataset.setValue(x1,"",label2.getText());
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Erstellte_Quiz_Pro_Monat/ Bewertung für den Zeitraum von dem Monat'"+Monat1+"' bis '"+Monat2+"' für die Jahre zwischen '"+Jahr1+"' and '"+Jahr2+"'","Monat", "Anzahl_Erstellte_Quiz", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_ProJahr_KneipeNR'"+K+"'  / Bewertung für den Zeitraum von dem Jahr'"+Jahr1+"' bis '"+Jahr2+"'","Jahr", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
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

        JFreeChart chart = ChartFactory.createBarChart("Anzahl_Quiz_Teilnehmer_Pro_Monat_Kneipe_Nr '"+K+"'  / Bewertung für den Zeitraum von dem Monat'"+Monat1+"' bis '"+Monat2+"' ","Monat", "Anzahl_Quiz_Teilnehmer", dataset,PlotOrientation.VERTICAL,false,true,false);
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
