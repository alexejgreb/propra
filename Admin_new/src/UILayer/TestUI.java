package UILayer;

import DataLayer.DataBase;
import DataLayer.DataBaseConnector;

public class TestUI {


    public static void main(String args[]){

        DataBaseConnector.setServerAddress(args[0]);
        DataBaseConnector.setServerUsername(args[1]);
        DataBaseConnector.setServerPassword(args[2]);
        DataBase db =new DataBase();
        System.out.println(db.getNewBarNumber());
    }

}
