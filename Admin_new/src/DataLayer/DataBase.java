package DataLayer;

import javax.swing.*;
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
    public int getNewAdminID(){
        int id=-2;
        String query="SELECT ID FROM Admin ORDER BY ID DESC LIMIT 1";
        try{
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while(res.next()){
                id=res.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        id++;
        return id;
    }
    public void insertNewAdmin(int id, String user,String password){

        String insert="INSERT INTO Admin (ID, User, Password) VALUES (?,?,?)";
        try{
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setInt(1,id);
            pstmt.setString(2,user);
            pstmt.setString(3,password);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int getNewBarNumber(){
        int barNumber=-2;
        String query = "SELECT Bar_Nr FROM Bar ORDER BY Bar_Nr DESC LIMIT 1";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()) {
                barNumber=res.getInt("Bar_Nr");
            }
            res.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        barNumber++;
        return barNumber;
    }

    public boolean insertBar(int Bar_Nr,String surename,String firstname, String street, String city, int post, int mobile, String mail, String nickname, int password){
        String insert="INSERT INTO Bar (Bar_Nr, Surname, First_name, Street, City, Post, Mobil, Mail, Nickname, Note, Password) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        boolean status=false;
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

            status=true;
        } catch (SQLException e) {

        }
        return status;
    }

}
