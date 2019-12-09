import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;


public class DB_Anfragen {

    public static Connection con =null;
    public DB_Anfragen(){
        con=DataBaseConnector.dbConnectorMariaDB();
    }



    public static void Bar_Registration(String Surname,String Firstname,String Street,String City,long post,long mobil,String mail,String Nickname,String Message,int Note,long Password){ //// Tabelle Fragen

        //con=Database.dbConnector();
        con = DataBaseConnector.dbConnectorMariaDB();
        try{



            String sql = "INSERT INTO Bar (Surname, First_Name, Street,City,Post,Mobil,Mail,Nickname,Message,Note,Password)VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1, Surname);
            pst.setString(2, Firstname);
            pst.setString(3, Street);
            pst.setString(4,City);
            pst.setLong(5, post);
            pst.setLong(6, mobil);

            pst.setString(7, mail);
            pst.setString(8, Nickname);
            pst.setString(9,Message);
            pst.setLong(10,Note);
            pst.setLong(11,Password);

            pst.execute();
            JOptionPane.showMessageDialog(null,"Save");


        } catch (Exception e0) {
            JOptionPane.showMessageDialog(null,"Ungültige Einträge !!!!!");
        }
    }


    public static void Login(String Nickname,JLabel t,int pp,JLabel Name){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select password from Bar where  Surname= '"+Nickname+"' or First_Name='"+Nickname+"' or Mail='"+Nickname+"' or Nickname='"+Nickname+"'";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                String password = rs.getString("Password");
                t.setText(password);
                pp=20;
                Name.setText(Nickname);

            }else{
                JOptionPane.showMessageDialog(null,"Prüfen sie ihren Nickname !!!!!");
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }


    public static void PWD_Update1(String Nickname,JLabel t,int p){ //// Combo_Box Fragen_Nr

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Note from Bar where Surname='"+Nickname+"' or First_Name='"+Nickname+"' or Mail='"+Nickname+"' or Nickname='"+Nickname+"' ";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {
                p=10;
                t.setText(rs.getString("Note"));
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }


    public static void Update_PWD(int pwd1, int BarNr){

        //con=Database.dbConnector();
        con = DataBaseConnector.dbConnectorMariaDB();

        try{

            int values114=BarNr;

            int Values116=pwd1;
            String sql22="update Bar set Password= '"+values114+"',Note=0 where  Bar_Nr = '"+Values116+"' ";
            PreparedStatement pst3=con.prepareStatement(sql22);
            pst3.execute();
            JOptionPane.showMessageDialog(null,"Erfolgreich geändert");



        }catch(Exception e3){
            JOptionPane.showMessageDialog(null,e3);
        }


    }


    public static void Select_BarNr(String Nickname,JLabel t1){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Bar_Nr from Bar where  Surname= '"+Nickname+"' or First_Name='"+Nickname+"' or Mail='"+Nickname+"' or Nickname='"+Nickname+"'";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String BarNr = rs.getString("Bar_Nr");
                t1.setText(BarNr);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void Select_BarNr1(String Nickname1,JTextField t11){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Bar_Nr from Bar where  Surname= '"+Nickname1+"' or First_Name='"+Nickname1+"' or Mail='"+Nickname1+"' or Nickname='"+Nickname1+"'";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String BarNr = rs.getString("Bar_Nr");
                t11.setText(BarNr);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }


    public static void Select_Password(String Nickname2,JLabel t2){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select password from Bar where  Surname= '"+Nickname2+"' or First_Name='"+Nickname2+"' or Mail='"+Nickname2+"' or Nickname='"+Nickname2+"'";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                String password = rs.getString("Password");
                t2.setText(password);




                pst1.close();

            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }


    public static void Select_Password_Bar_Nr(String Nickname2,JLabel t2){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select password from Bar where  Bar_Nr='"+Nickname2+"'";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                String password = rs.getString("Password");
                t2.setText(password);




                pst1.close();

            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }


    public static void Passwort_Neu(String Nickname1,JLabel t1){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Bar_Nr from Bar where Mail='"+Nickname1+"'";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String BarNr = rs.getString("Bar_Nr");
                t1.setText(BarNr);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }



    public static void Update_Pass_Neu(long pwd1, long BarNr){

        //con=Database.dbConnector();
        con = DataBaseConnector.dbConnectorMariaDB();

        try{

            long Values116=BarNr;

            long Values114=pwd1;
            String sql22="update Bar set Password= '"+Values114+"',Note=1 where  Bar_Nr = '"+Values116+"' ";
            PreparedStatement pst3=con.prepareStatement(sql22);
            pst3.execute();
            JOptionPane.showMessageDialog(null,"Neue Password wurde erstellt !!!");



        }catch(Exception e3){
            JOptionPane.showMessageDialog(null,e3);
        }


    }

    public static void Max_BarNR(JTextField t){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select max(Bar_Nr) from Bar";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String BarNr = rs.getString("max(Bar_Nr)");





                t.setText(BarNr);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }



    public static void Neu_Anmeldung(String BarNr ,JTextField t){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Note from Bar where Bar_Nr ='"+BarNr+"' ";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String Note = rs.getString("Note");





                t.setText(Note);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }



    public static void Insert_Frage(String Frage,String ErsteWahl,String ZweiteWahl,String DritteWahl,String VierteWahl,String RichtigeAntwort,int Besitzer,JTextArea ta,JLabel Zeit){ ////

        con = DataBaseConnector.dbConnectorMariaDB();
        try{
            String sql = "insert into FragenPool (Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort,Besitzer)values (?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, Frage);
            pst.setString(2, ErsteWahl);
            pst.setString(3, ZweiteWahl);

            pst.setString(4, DritteWahl);
            pst.setString(5, VierteWahl);
            pst.setString(6, RichtigeAntwort);
            pst.setLong(7, Besitzer);

            pst.execute();
            JOptionPane.showMessageDialog(null,"Gespeichert");






        }
        catch(Exception e11){
            JOptionPane.showMessageDialog(null,"Prüfen sie die Angegebene Daten Bitte !!!");
        }



        ta.append("\t Frage Hinzugefügt: \n\n"+"Frage:\t"+Frage+"\n============================================================================\n"+"A:\t"+ErsteWahl+"\n============================================================================\n"+"B:\t"+ZweiteWahl+"\n============================================================================\n"+"C:\t"+DritteWahl+"\n============================================================================\n"+"D:\t"+VierteWahl+""+
                " \t"+"Antwort:\t"+RichtigeAntwort+" \n============================================================================\n"+" \n============================================================================\n"+Zeit.getText()+"\n============================================================================\n"+"\n============================================================================\n"+"\n============================================================================\n");


    }




    public static void Delete_Frage(int FrageNr,int Besitzer,JTextArea ta,JLabel Zeit){ ////

        con = DataBaseConnector.dbConnectorMariaDB();
        try{


            String Delete =" delete from FragenPool where FrageNr = '"+FrageNr+"' and Besitzer ='"+Besitzer+"'";

            PreparedStatement pst3=con.prepareStatement(Delete);
            pst3.execute();
            pst3.close();
            JOptionPane.showMessageDialog(null,"die Frage '"+FrageNr+"' ist entfernt worden!!!");


        }
        catch(Exception e11){
            JOptionPane.showMessageDialog(null,"Prüfen sie die Angegebene Daten Bitte !!!");
        }



        ta.append("\t Frage Delete: \n\n"+"FrageNr:\t"+FrageNr+" \t"+"\n============================================================================\n"+" \n============================================================================\n"+Zeit.getText()+"\n============================================================================\n"+"\n============================================================================\n"+"\n============================================================================\n");


    }



    public static void Select_FrageNr(int BarNr ,JComboBox c){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select FrageNr from FragenPool where Besitzer ='"+BarNr+"'";

            PreparedStatement pst=con.prepareStatement(query);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String FrageNr = rs.getString("FrageNr");
                c.addItem(FrageNr);

            }
            pst.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void Select_Frage(int NR ,JTextArea txt1, JTextField txt2,JTextField txt3,JTextField txt4,JTextField txt5,JTextField txt6){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select  Frage ,ErsteWahl ,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort from FragenPool WHERE FrageNr= '"+NR+"' ";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                txt1.setText(rs.getString("Frage"));
                txt2.setText(rs.getString("RichtigeAntwort"));
                txt3.setText(rs.getString("ErsteWahl"));
                txt4.setText(rs.getString("ZweiteWahl"));
                txt5.setText(rs.getString("DritteWahl"));
                txt6.setText(rs.getString("VierteWahl"));
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }

    public static void Select_Frage_FragenPool(int BarNr ,JComboBox c){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Frage from FragenPool where Besitzer ='"+BarNr+"'";

            PreparedStatement pst=con.prepareStatement(query);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String Frage = rs.getString("Frage");
                c.addItem(Frage);

            }
            pst.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void Select_Frage1(String F ,JTextArea txt1, JTextField txt2,JTextField txt3,JTextField txt4,JTextField txt5,JTextField txt6){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select  Frage ,ErsteWahl ,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort from FragenPool WHERE Frage= '"+F+"' ";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                txt1.setText(rs.getString("Frage"));
                txt2.setText(rs.getString("RichtigeAntwort"));
                txt3.setText(rs.getString("ErsteWahl"));
                txt4.setText(rs.getString("ZweiteWahl"));
                txt5.setText(rs.getString("DritteWahl"));
                txt6.setText(rs.getString("VierteWahl"));
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }




    public static void Update_Question(JTextArea Question,JTextField A,JTextField B,JTextField C,JTextField D,JTextField Answer,JComboBox CB,JLabel Zeit,JTextArea ta){ //// Combo_Box Fragen_Nr
        //con=Database1.dbConnector();
        con = DataBaseConnector.dbConnectorMariaDB();


        try{
            String value223=Question.getText();
            String value33=A.getText();
            String value22= B.getText();
            String value222=C.getText();
            String value221= D.getText();
            String value2225=Answer.getText();
            String value115=CB.getSelectedItem().toString();
            String sql22="update FragenPool set Frage='"+value223+"',ErsteWahl='"+value33+"',ZweiteWahl='"+value22+"',DritteWahl='"+value222+"',VierteWahl='"+value221+"',RichtigeAntwort='"+value2225+"' where FrageNr='"+value115+"' ";
            PreparedStatement pst3=con.prepareStatement(sql22);
            pst3.execute();
            JOptionPane.showMessageDialog(null,"Erfolgreich UPDATE");
            ta.append("\t Frage Update: \n\n"+"Frage:\t"+Question.getText()+"\n============================================================================\n"+"A:\t"+A.getText()+"\n============================================================================\n"+"B:\t"+B.getText()+"\n============================================================================\n"+"C:\t"+C.getText()+"\n============================================================================\n"+"D:\t"+D.getText()+""+
                    " \t"+"Antwort:\t"+Answer.getText()+" \n============================================================================\n"+" \n============================================================================\n"+Zeit.getText()+"\n============================================================================\n"+"\n============================================================================\n"+"\n============================================================================\n");


        }catch(Exception e3){
            JOptionPane.showMessageDialog(null,"Prüfen sie die Angegebene Daten Bitte !!!");
        }


    }



    public static void Table_Fragen(JTable t,int b) {

        con = DataBaseConnector.dbConnectorMariaDB();
        //con=Database1.dbConnector();

        try {
            String query="select Frage, ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,ErsteWahl as RichtigeAntwort from FragenPool where Besitzer ='"+b+"'";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs= pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void Select_Count_FragenPool0(int N ,JTextField x){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select count(*) from FragenPool f where Besitzer = '"+N+"'";

            PreparedStatement pst=con.prepareStatement(query);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                //String count = rs.getString("count(*)");
                x.setText(rs.getString("count(*)"));

            }
            pst.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }


    public static void Select_FrageNR_FragenPool(int BarNr ,int x,JTextField Spiel,JTextField BarNur){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        for(int i=1;i<=x;i++){


            try {	 ///
                String query="select FrageNr from FragenPool where Besitzer ='"+BarNr+"' and FrageNr not in ( Select Frage_Nr from Quiz_Fragen where Spiel_Nummer='"+Spiel.getText()+"')";

                PreparedStatement pst=con.prepareStatement(query);

                ResultSet rs= pst.executeQuery();
                if(rs.next()){

                    String FrageNr = rs.getString("FrageNr");


                    String sql = "insert into Quiz_Fragen(Spiel_Nummer,Frage_Nr,Bar_Nr) VALUES(?,?,?)";
                    PreparedStatement pst2=con.prepareStatement(sql);
                    pst2.setString(1, Spiel.getText());
                    pst2.setString(2, FrageNr);
                    pst2.setString(3,BarNur.getText());

                    pst2.execute();


                }
                pst.close();


            } catch (Exception e3) {
                e3.printStackTrace();
            }}
    }


    public static void Insert_Spiel_Fragen(JTextField t1 ,JLabel Zeit,JTextField licence,JComboBox Uhr,JComboBox Min,JComboBox Tag,JComboBox Monat,JComboBox Jahr,JComboBox AR,JComboBox AF,JTextField Bar){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String sql = "insert into Spiel_Gnehmigt (Spiel_Nummer,Datum,Lizenc,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel,Anzahl_Runden,Anzahl_Fragen,Bar_Nr)values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t1.getText());
            pst.setString(2, Zeit.getText());
            pst.setString(3, licence.getText());

            pst.setString(4, "1");
            pst.setString(5, Uhr.getSelectedItem().toString());
            pst.setString(6, Min.getSelectedItem().toString());
            pst.setString(7, Tag.getSelectedItem().toString());
            pst.setString(8, Monat.getSelectedItem().toString());
            pst.setString(9, Jahr.getSelectedItem().toString());
            pst.setString(10, AR.getSelectedItem().toString());
            pst.setString(11, AF.getSelectedItem().toString());
            pst.setString(12,Bar.getText());
            /////////////////////////////////////////////////////////////////////////////////////
            pst.execute();
            JOptionPane.showMessageDialog(null,"Gespeichert");






        }
        catch(Exception e11){
            e11.printStackTrace();
        }

    }


    public static void Table_Fragen_Quiz(JTable t,JTextField ff) {

        con = DataBaseConnector.dbConnectorMariaDB();
        //con=Database1.dbConnector();
        try {
            String query="select Spiel_Nummer,Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,ErsteWahl as Richtige_Antwort from (FragenPool  , Quiz_Fragen) where Quiz_Fragen.Frage_Nr=FragenPool.FrageNr and Quiz_Fragen.Bar_Nr='"+ff.getText()+"' ORDER by Spiel_Nummer";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs= pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }


    public static void Select_SpielNR(int BarNr ,JComboBox c){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select Spiel_Nummer from Spiel_Gnehmigt where Bar_Nr ='"+BarNr+"'";

            PreparedStatement pst=con.prepareStatement(query);

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                String Spiel = rs.getString("Spiel_Nummer");
                c.addItem(Spiel);

            }
            pst.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }






    public static void Quiz_Teilnehmer(JTable t,JTextField ff) {

        con = DataBaseConnector.dbConnectorMariaDB();
        //con=Database1.dbConnector();
        try {
            String query="select Kunden_Nr,ID_Nummer from Kunde_Spiel where Spiel_Nr ='"+ff.getText()+"'";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs= pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }



    public static void Select_Quiz_Teilnehmer_Info(JTextField txt1, JTextField txt2,JTextField txt3,JTextField txt4,JTextField txt5,JTextField txt6){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select  Datum,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel,Anzahl_Runden,Anzahl_Fragen from Spiel_Gnehmigt where Spiel_Nummer ='"+txt1.getText()+"'";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                txt2.setText(rs.getString("Datum"));
                txt3.setText(rs.getString("Uhr_Spiel"));
                txt4.setText(rs.getString("Min_Spiel"));
                txt5.setText(rs.getString("Anzahl_Runden"));
                txt6.setText(rs.getString("Anzahl_Fragen"));

            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }

    public static void Select_Bar_Info(JTextField txt1, JTextField txt2,JTextField txt3,JTextField txt4,JTextField txt5,JTextField txt6,JTextField txt7,JTextField txt8){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select  First_Name,Surname,Street,City,Post,Mobil,Mail from Bar where Bar_Nr ='"+txt1.getText()+"'";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {

                txt2.setText(rs.getString("First_Name"));
                txt3.setText(rs.getString("Surname"));
                txt4.setText(rs.getString("Street"));
                txt5.setText(rs.getString("Post"));
                txt6.setText(rs.getString("City"));
                txt7.setText(rs.getString("Mobil"));
                txt8.setText(rs.getString("Mail"));

            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }


    public static void Select_Datum_Spiel(int NR ,JLabel txt1){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select Tag_Spiel,Monat_Spiel,Jahr_Spiel,Uhr_Spiel,Min_Spiel from Spiel_Gnehmigt WHERE Spiel_Nummer= '"+NR+"' ";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {


                txt1.setText(rs.getString("Tag_Spiel")+"/"+rs.getString("Monat_Spiel")+"/"+rs.getString("Jahr_Spiel")+"UM:"+rs.getString("Uhr_Spiel")+":"+rs.getString("Min_Spiel"));


            }else{
                JOptionPane.showMessageDialog(null,"Prüfen sie das Spiel_Nummer");
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }

    public static void Select_Info_Kunde_Spiel(int NR ,int NR2,JLabel txt1,JLabel txt2){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///

            String query="select Kunden_Nr,Punkte from Kunde_Spiel WHERE Spiel_Nr= '"+NR+"' and ID_Nummer='"+NR2+"' ";

            PreparedStatement pst1=con.prepareStatement(query);

            ResultSet rs= pst1.executeQuery();

            if ((rs.next()))
            {


                txt1.setText("KundenNr:"+rs.getString("Kunden_Nr"));
                txt2.setText(rs.getString("Punkte"));

            }else{
                JOptionPane.showMessageDialog(null,"Prüfen sie das Spiel_Nummer ggf auch das ID_Nummer");
            }

            pst1.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }


    }


    public static void Winner_Punkte(int NR,JLabel t){ ////

        con = DataBaseConnector.dbConnectorMariaDB();

        //con=Database.dbConnector();
        try {	 ///
            String query="select max(Punkte) from Kunde_Spiel where Spiel_Nr = '"+NR+"'";

            PreparedStatement pst111=con.prepareStatement(query);

            ResultSet rs= pst111.executeQuery();

            if ((rs.next()))
            {

                String max = rs.getString("max(Punkte)");





                t.setText(max);
                //pp=20;

            }
            pst111.close();


        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void Quiz_Ergebniss(JTable t,int NR) {

        con = DataBaseConnector.dbConnectorMariaDB();
        //con=Database1.dbConnector();
        try {
            String query="select ID_Nummer, Punkte from Kunde_Spiel where Spiel_Nr = '"+NR+"' ORDER by Punkte DESC;";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs= pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }


}
