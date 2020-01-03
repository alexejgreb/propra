package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
    public boolean adminLogin(String user,String password){
        String query = "SELECT* FROM Admin WHERE User = '"+ user + "' AND Password = '"+ password +"'";
        boolean status= false;
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            if (res.next()) {
                status = true;
            }
            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public int getNewBarNumber(){
        int barNumber=-2;
        String query = "SELECT Bar_Nr FROM Bar WHERE Bar_Nr ";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()) {
                barNumber=res.getInt(query);
            }
            res.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        barNumber++;
        return barNumber;
    }

    public void insertBar(int Bar_Nr,String surename,String firstname, String street, String city, int post, int mobile, String mail, String nickname, int password){
        String insert="INSERT IN TO Bar (Bar_Nr, Surename, Firstname, Street, City, Post, Mobil, Mail, Nickname, Note, Password) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setInt(1, Bar_Nr);
            pstmt.setString(2,surename);
            pstmt.setString(3,firstname);
            pstmt.setString(4,street);
            pstmt.setString(5,city);
            pstmt.setInt(6,post);
            pstmt.setInt(7,mobile);
            pstmt.setString(8,mail);
            pstmt.setString(9,nickname);
          //pstmt.setString(10,message);
            pstmt.setInt(10,1);
            pstmt.setInt(11,password);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
