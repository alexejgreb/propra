package DataLayer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
    // public Admin admin=new Admin(-1,"-1",-1);

    public Date getDate() {
        String query = "SELECT Date(now())";
        java.sql.Date date = new java.sql.Date(1, 1, 1);
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);
            while (res.next()) {
                date = res.getDate(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    public int[] getAdminIdAndMaster(String user, String password) {
        String query = "SELECT* FROM Admin WHERE User = '" + user + "' AND Password = '" + password + "'";
        int[] idAndMaster = new int[2];
        idAndMaster[0] = -1;
        idAndMaster[1] = -1;
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            if (res.next()) {
                idAndMaster[0] = res.getInt(1);
                idAndMaster[1] = res.getInt(4);
            }
            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAndMaster;
    }

    public boolean adminLogin(String user, String password) {
        String query = "SELECT* FROM Admin WHERE User = '" + user + "' AND Password = '" + password + "'";
        boolean status = false;
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

    public int getNewAdminID() {
        int id = -2;
        String query = "SELECT ID FROM Admin ORDER BY ID DESC LIMIT 1";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()) {
                id = res.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        id++;
        return id;
    }

    public void insertNewAdmin(int id, String user, String password, int master) {

        String insert = "INSERT INTO Admin (ID, User, Password, Master) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setInt(1, id);
            pstmt.setString(2, user);
            pstmt.setString(3, password);
            pstmt.setInt(4, master);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] searchAdmin(int id) {
        String query = "SELECT * FROM Admin WHERE ID = '" + id + "'";
        String data[] = new String[4];

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);
            if (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
        //System.out.println(data[1]+data[0]);
    }

    public int getNewBarNumber() {
        int barNumber = -2;
        String query = "SELECT Bar_Nr FROM Bar ORDER BY Bar_Nr DESC LIMIT 1";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            while (res.next()) {
                barNumber = res.getInt("Bar_Nr");
            }
            res.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        barNumber++;
        return barNumber;
    }

    public boolean deleteAdmin(int id) {
        boolean status = false;
        String delete = "DELETE FROM Admin WHERE ID = '" + id + "'";
        try {
            PreparedStatement pstmt = con.prepareStatement(delete);
            pstmt.execute();
            pstmt.close();
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void editAdmin(int id, String user, String password, int master) {
        String update = "Update Admin SET User = '" + user + "', Password = '" + password + "',Master = '" + master + "'WHERE ID = '" + id + "'";
        try {
            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertBar(int Bar_Nr, String surename, String firstname, String street, String city, int post, int mobile, String mail, String nickname, int password, java.sql.Date date) {
        String insert = "INSERT INTO Bar (Bar_Nr, Surname, First_name, Street, City, Post, Mobil, Mail, Nickname, Note, Password, Date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean status = false;
        try {
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setInt(1, Bar_Nr);
            pstmt.setString(2, surename);
            pstmt.setString(3, firstname);
            pstmt.setString(4, street);
            pstmt.setString(5, city);
            pstmt.setInt(6, post);
            pstmt.setInt(7, mobile);
            pstmt.setString(8, mail);
            pstmt.setString(9, nickname);
            //pstmt.setString(10,message);
            pstmt.setInt(10, 1);
            pstmt.setInt(11, password);
            pstmt.setDate(12, date);
            pstmt.executeUpdate();
            pstmt.close();

            status = true;
        } catch (SQLException e) {

        }
        return status;
    }

    public boolean deleteBar(int id) {
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

    public Bar selectBar(int id) {
        boolean error = true;
        Bar bart = new Bar();
        String query = "SELECT * FROM Bar WHERE Bar_Nr=" + id;
        int i = 1;
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery(query);

            if (res.next()) {
                //                          ID,                         Surename                    First Name                      Streer                      City                        Postcode                 Telefonr.                      Mail                            Barname                     Massage                            Note                     Passwort
                Bar bar = new Bar(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getString(8), res.getString(9), res.getString(10), res.getInt(11), res.getInt(12));
                res.close();
                pstmt.close();
                return bar;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bart;
    }

    public boolean updateBar(Bar bar) {
        boolean error = false;
        String update = "Update Bar SET Surename= " + bar.getSurename() + ", First_Name=" + bar.getFirstname() + ", Street=" + bar.getStreet() +
                ", City=" + bar.getCity() + ", Post=" + bar.getPost() + ", Mobil=" + bar.getTelefonenummer() + ", Mail=" + bar.getMail() +
                ", Nickname=" + bar.getBarName() + ", Message=" + bar.getMessage() + ", Note=" + bar.getNote() + ", Password=" + bar.getPasswort() +
                " WHERE ID=" + bar.getId();
        try {
            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            error = true;
            e.printStackTrace();
        }
        return error;
    }

    public ArrayList<Bar> searchBar(int id) {
        String search = "SELECT * FROM Bar WHERE Bar_Nr LIKE '%" + id + "%'";
        ArrayList<Bar> barList = new ArrayList<Bar>();
        int i = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(search);
            ResultSet res = pstmt.executeQuery(search);
            while (res.next()) {
                Bar bar = new Bar();
                bar.setId(res.getInt(1));
                bar.setSurename(res.getString(2));
                bar.setFirstname(res.getString(3));
                bar.setStreet(res.getString(4));
                bar.setCity(res.getString(5));
                bar.setPost(res.getInt(6));
                bar.setTelefonenummer(res.getLong(7));
                bar.setMail(res.getString(8));
                bar.setBarName(res.getString(9));
                bar.setMessage(res.getString(10));
                bar.setNote(res.getInt(11));
                bar.setPasswort(res.getInt(12));
                barList.add(bar);
                i++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Suchen!");
            e.printStackTrace();
        }
        return barList;
    }

    public Bar getBar(int id) {
        String search = "SELECT * FROM Bar WHERE Bar_Nr="+id;
        Bar bar = new Bar();
        try {
            PreparedStatement pstmt = con.prepareStatement(search);
            ResultSet res = pstmt.executeQuery(search);
            while (res.next()) {
                bar.setId(res.getInt(1));
                bar.setSurename(res.getString(2));
                bar.setFirstname(res.getString(3));
                bar.setStreet(res.getString(4));
                bar.setCity(res.getString(5));
                bar.setPost(res.getInt(6));
                bar.setTelefonenummer(res.getLong(7));
                bar.setMail(res.getString(8));
                bar.setBarName(res.getString(9));
                bar.setMessage(res.getString(10));
                bar.setNote(res.getInt(11));
                bar.setPasswort(res.getInt(12));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bar;
    }
}
