package UILayer;

import DataLayer.DataBase;
import DataLayer.DataBaseConnector;
import LogicLayer.Admin;

public class TestUI {


    public static void main(String args[]){

        DataBaseConnector.setServerAddress(args[0]);
        DataBaseConnector.setServerUsername(args[1]);
        DataBaseConnector.setServerPassword(args[2]);
        DataBase db =new DataBase();
        String[] s= new String[4];
     //   s=db.searchAdmin(100001);
     //   System.out.println(""+s[0]+s[1]+s[2]+" "+s[3]);
      //  db.editAdmin(100002,"test","test1",1);
        Admin admin= db.creatAdmin("Max","0000");
        System.out.println(""+admin.getMaster()+" "+admin.getId());
    }

}
