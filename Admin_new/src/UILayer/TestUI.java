package UILayer;

import DataLayer.Bar;
import DataLayer.DataBase;
import DataLayer.DataBaseConnector;
import DataLayer.Admin;

public class TestUI {
    //static Admin admin = new Admin(-3,"3",-3);

    public static void main(String args[]){

        DataBaseConnector.setServerAddress(args[0]);
        DataBaseConnector.setServerUsername(args[1]);
        DataBaseConnector.setServerPassword(args[2]);
        DataBase db =new DataBase();
        String[] s= new String[4];
        int[] i=new int[2];
     //   s=db.searchAdmin(100001);
     //   System.out.println(""+s[0]+s[1]+s[2]+" "+s[3]);
      //  db.editAdmin(100002,"test","test1",1);
        //Admin admin = new Admin(-3,"3",-3);
       // i=db.getAdminIdAndMaster("Admin","1212");
       // System.out.println(""+i[0]+" "+i[1]);
       // Bar bar= new Bar();
       // bar =db.selectBar(1001);
        // System.out.println(""+bar.getBarName());
        UIEditBar.main(null);
    }

}
