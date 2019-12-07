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

}
