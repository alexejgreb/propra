package DataLayer;

import LogicLayer.Admin;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
   // public Admin admin=new Admin(-1,"-1",-1);

    public Admin creatAdmin(String loginUser, String loginPassword){
        String query ="SELECT* FROM Admin WHERE User = '"+ loginUser + "' AND Password = '"+ loginPassword +"'";
        boolean status= false;
        String user=loginUser;
        int id = -1;
        int master = -1;
        Admin admin=new Admin(-1,"-1",-1);

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()) {
                status = true;
                id=res.getInt("ID");
                master=res.getInt("Master");
            }
            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (status){
            admin.setId(id);
            admin.setUser(user);
            admin.setId(master);
            System.out.println("hat geklappt"+admin.getId()+" "+admin.getMaster());
            return admin;
        }
        return admin;
    }
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
    public void insertNewAdmin(int id, String user,String password,int master){

        String insert="INSERT INTO Admin (ID, User, Password, Master) VALUES (?,?,?,?)";
        try{
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setInt(1,id);
            pstmt.setString(2,user);
            pstmt.setString(3,password);
            pstmt.setInt(4,master);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String[] searchAdmin(int id){
        String query ="SELECT * FROM Admin WHERE ID = '"+ id+"'";
        String data [] =new String[4];

        try{
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res =pstmt.executeQuery(query);
            if(res.next()){
                data[0]=res.getString(1);
                data[1]=res.getString(2);
                data[2]=res.getString(3);
                data[3]=res.getString(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
        //System.out.println(data[1]+data[0]);
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

    public boolean deleteAdmin(int id){
        boolean status=false;
        String delete="DELETE FROM Admin WHERE ID = '" + id + "'";
        try {
            PreparedStatement pstmt = con.prepareStatement(delete);
            pstmt.execute();
            pstmt.close();
            status=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public void editAdmin(int id, String user,String password,int master){
        String update="Update Admin SET User = '"+user+"', Password = '"+password+"',Master = '"+master+ "'WHERE ID = '"+id+"'";
        try {
            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
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
    public boolean deletBar(int id) {
        String delete = "DELETE FROM Bar WHERE Bar_Nr =" + id;
        boolean error = true;

        try {
            PreparedStatement pstmt = con.prepareStatement(delete);
            pstmt.execute();
            pstmt.close();
            error = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return error;
    }

    public boolean selectBar(int id){
        boolean error=true;
        String querry="SELCET* FROM Bar WHERE Bar_Nr="+id;

        return error;
    }


}
