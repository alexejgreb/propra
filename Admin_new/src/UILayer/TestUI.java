package UILayer;

import DataLayer.DataBase;

import java.sql.SQLException;

public class TestUI {
    //static Admin admin = new Admin(-3,"3",-3);

    public static void main(String args[]) throws SQLException {

        // DataBaseConnector.setServerAddress(args[0]);
        //   DataBaseConnector.setServerUsername(args[1]);
        //   DataBaseConnector.setServerPassword(args[2]);
        DataBase db = new DataBase();
        UIEditBar1.main(null);
        UIBar.main(null);




    }

}
