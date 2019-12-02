package Old;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Old.Database;


public class DB_Anfragen {

	public static Connection con =null;
	public DB_Anfragen(){
		con= Database.dbConnector();
	}
	
	
public static void Bar_Registration(long Bar_Nr,String Surname,String Firstname,String Street,String City,long post,long mobil,String mail,String Nickname,String Message,int Note,long Password){ //// Tabelle Fragen
		
		con=Database.dbConnector();
		try{
			
			
			
			String sql = "INSERT INTO Bar (Bar_Nr, Surname, First_Name, Street,City,Post,Mobil,Mail,Nickname,Message,Note,Password)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setLong(1, Bar_Nr);
			pst.setString(2, Surname);
			pst.setString(3, Firstname);
			pst.setString(4, Street);
			pst.setString(5,City);
			pst.setLong(6, post);
			pst.setLong(7, mobil);
			
			pst.setString(8, mail);
			pst.setString(9, Nickname);
			pst.setString(10,Message);
			pst.setLong(11,Note);
			pst.setLong(12,Password);
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Save");

				
		} catch (Exception e0) {
			JOptionPane.showMessageDialog(null,"Ungültige Einträge !!!!!");
		}	
	}
	
	
public static void Login(String Nickname,JLabel t,int pp){ //// 
	
	con=Database.dbConnector();
	try {	 /// 		
	    String query="select password from bar where Bar_Nr='"+Nickname+"' or Surname= '"+Nickname+" or First_Name='"+Nickname+" or Mail='"+Nickname+" or Nickname='"+Nickname+"";
	    
		PreparedStatement pst1=con.prepareStatement(query);
		
		ResultSet rs= pst1.executeQuery();
		
		 if ((rs.next()))
		 {
			
			 String password = rs.getString("Password");
				t.setText(password);
				pp=20;
		
		 }else{
			 JOptionPane.showMessageDialog(null,"Prüfen sie ihren Nickname !!!!!");
		 }
		
			pst1.close();
			

		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}
	
	
public static void PWD_Update1(String Nickname,JLabel t,int p){ //// Combo_Box Fragen_Nr
	
	con=Database.dbConnector();
	try {	 /// 		
	    String query="select Note from bar where Bar_Nr='"+Nickname+"' or Surname='"+Nickname+"' or First_Name='"+Nickname+"' or Mail='"+Nickname+"' or Nickname='"+Nickname+"' ";
	    
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


public static void Update_PWD(int pwd0,int pwd1, int BarNr,int V){ //// Combo_Box Fragen_Nr
	con=Database.dbConnector();
	try{
		 
		int values114=BarNr;
		int value115=pwd0;
		int Values116=pwd1;
         String sql22="update Bar set Password= '"+Values116+"' where Password = '"+value115+"' and Bar_Nr = '"+values114+"' ";
         PreparedStatement pst3=con.prepareStatement(sql22);
        pst3.execute();
          JOptionPane.showMessageDialog(null,"Erfolgreich geändert");
           V=5;


         }catch(Exception e3){
           JOptionPane.showMessageDialog(null,e3);
             }


}

}
