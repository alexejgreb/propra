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
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();
	}



	public static void Table_Question(JTable t){ //// Tabelle Fragen

		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();
		try {
			String query="select Frage, ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,ErsteWahl as RichtigeAntwort from FragenPool where Besitzer =0";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void Question_Nr(JComboBox C){ //// Combo_Box Fragen_Nr

		//	con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
		try{
			String query2="select FrageNr from FragenPool where Besitzer =0";
			PreparedStatement pst1=con.prepareStatement(query2);

			ResultSet rs= pst1.executeQuery();
			while (rs.next()){
				String FrageNr = rs.getString("FrageNr");
				C.addItem(FrageNr);

			}

			rs.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}}






	public static void Table_Bar(JTable t) {

		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();

		try {
			String query="select DISTINCT Kneipe_Nr AS Kneipennummer ,Adresse AS Adresse, Telefon_Nr AS Telefonnummer, Besitzer AS Besitzer, Email AS Email from Kneipe_Teilnehmer where Vermerk =1";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void Max_Question_Nr(JLabel l){ //// Combo_Box Fragen_Nr

		con = DataBaseConnector.dbConnectorMariaDB();

		//	con=Database1.dbConnector();
		try {
			String query="select max(FrageNr) from FragenPool where Besitzer=0";  ///
			PreparedStatement pst1=con.prepareStatement(query);

			ResultSet rs= pst1.executeQuery();

			if ((rs.next()))
			{
				l.setText(rs.getString("max(FrageNr)")) ; //

			}

			pst1.close();


		} catch (Exception e1) {
			e1.printStackTrace();
		}}


	public static void Insert_Question(JLabel l,JTextArea Question,JTextField A,JTextField B,JTextField C,JTextField D,JTextField Answer){ //// Combo_Box Fragen_Nr

		//	con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
		try{

			// Neue Frage Hinzufügen

			String sql = "INSERT INTO FragenPool (Frage, ErsteWahl, ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort,Besitzer)VALUES (?,?,?,?,?,?,?)" ;
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, l.getText());
			pst.setString(1, Question.getText());
			pst.setString(2, A.getText());
			pst.setString(3, B.getText());
			pst.setString(4,C.getText());
			pst.setString(5, D.getText());
			pst.setString(6, Answer.getText());

			pst.setString(7, "0");

			pst.execute();
			JOptionPane.showMessageDialog(null,"Die Frage wurde dem Fragenpool hinzugefügt");


		} catch (Exception e1) {
			e1.printStackTrace();
		}




	}


	public static void Delete_Question(JComboBox C){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();

		try{


			String Delete ="delete from FragenPool where FrageNr ='"+C.getSelectedItem().toString()+"'";

			PreparedStatement pst3=con.prepareStatement(Delete);
			pst3.execute();
			pst3.close();
			JOptionPane.showMessageDialog(null,"Die Frage wurde gelöscht");

		} catch(Exception e1){
			e1.printStackTrace();
		}


	}


	public static void Update_Question(JTextArea Question,JTextField A,JTextField B,JTextField C,JTextField D,JTextField Answer,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();


		try{
			String value223=Question.getText();
			String value33=A.getText();
			String value22= B.getText();
			String value222=C.getText();
			String value221= D.getText();
			String value2225=Answer.getText();
			String value115=CB.getSelectedItem().toString();
			String sql22="update FragenPool set Frage='"+value223+"',ErsteWahl='"+value33+"',ZweiteWahl='"+value22+"',DritteWahl='"+value222+"',VierteWahl='"+value221+"',RichtigeAntwort='"+value2225+"' where FrageNr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();
			JOptionPane.showMessageDialog(null,"Die Frage wurde angepasst.");


		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,e3);
		}


	}

	public static void Select_Question(JTextArea Question,JTextField A,JTextField B,JTextField C,JTextField D,JTextField Answer,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try {	 ///

			String query="select  Frage ,ErsteWahl ,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort from FragenPool WHERE FrageNr= ? ";

			PreparedStatement pst1=con.prepareStatement(query);
			pst1.setString(1, CB.getSelectedItem().toString());
			ResultSet rs= pst1.executeQuery();

			if ((rs.next()))
			{

				Question.setText(rs.getString("Frage"));
				Answer.setText(rs.getString("RichtigeAntwort"));
				A.setText(rs.getString("ErsteWahl"));
				B.setText(rs.getString("ZweiteWahl"));
				C.setText(rs.getString("DritteWahl"));
				D.setText(rs.getString("VierteWahl"));
			}

			pst1.close();


		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}


	public static void Bar_Nr(JComboBox C){ //// Combo_Box Fragen_Nr
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();
		try{
			String query2="select DISTINCT Kneipe_Nr from Kneipe_Teilnehmer where Vermerk =0";
			PreparedStatement pst1=con.prepareStatement(query2);

			ResultSet rs= pst1.executeQuery();
			while (rs.next()){
				String Kneipe_Nr = rs.getString("Kneipe_Nr");
				C.addItem(Kneipe_Nr);

			}

			rs.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}
	}






	public static void Update_Bar_Member(JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try{


			String value115=CB.getSelectedItem().toString();
			String sql22="update Kneipe_Teilnehmer set Vermerk=0 where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();
			JOptionPane.showMessageDialog(null,"Erfolgreich Gespeert");



		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,e3);
		}


	}




	public static void Select_Bar( JTextField Bar_Nr,JTextField Adresse,JTextField Besitzer,JTextField Tel,JTextField mail,JTextField vermerk,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try {

			String query="select Adresse,Telefon_Nr,Besitzer,Email,Vermerk from Kneipe_Teilnehmer where Kneipe_Nr= ? ";

			PreparedStatement pst1=con.prepareStatement(query);
			pst1.setString(1, CB.getSelectedItem().toString());
			ResultSet rs= pst1.executeQuery();

			if ((rs.next()))
			{

				Bar_Nr.setText(CB.getSelectedItem().toString());
				Adresse.setText(rs.getString("Adresse"));
				Besitzer.setText(rs.getString("Besitzer"));
				Tel.setText(rs.getString("Telefon_Nr"));
				mail.setText(rs.getString("Email"));
				vermerk.setText(rs.getString("Vermerk"));
			}

			pst1.close();


		} catch (Exception e3) {
			e3.printStackTrace();
		}

	}




	public static void Update_Lizenc(JComboBox CB){ //// Combo_Box Fragen_Nr
		//	con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try{


			String value115=CB.getSelectedItem().toString();
			String sql22="update Kneipe_Teilnehmer set Vermerk=1 where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();
			JOptionPane.showMessageDialog(null,"Lizenz erteilt");



		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,e3);
		}


	}



	public static void Insert_Lizenc(JLabel Licence_Nr,JTextField Bar_Nr,JLabel Date,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
		try{

			//

			String sql = "INSERT INTO Spiel_Licence (Licence_Nr, Kneipe_Nr, Datum, Vermerk)VALUES (?,?,?,?)" ;
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, Licence_Nr.getText());
			pst.setString(2, Bar_Nr.getText());
			pst.setString(3, Date.getText());
			pst.setString(4, CB.getSelectedItem().toString());

			pst.execute();
			JOptionPane.showMessageDialog(null,"Dauerhafte Lizenz wurde erteilt.");


		} catch (Exception e1) {
			e1.printStackTrace();
		}




	}

	public static void Select_Lizenc(JComboBox C,JLabel t){ //// Combo_Box Fragen_Nr


		con = DataBaseConnector.dbConnectorMariaDB();

		//con=Database1.dbConnector();
		try {	 ///
			String query="select * from Spiel_Licence where Vermerk ='"+C.getSelectedItem().toString()+"'";

			PreparedStatement pst1=con.prepareStatement(query);

			ResultSet rs= pst1.executeQuery();

			if ((rs.next()))
			{

				t.setText("1");
			}

			pst1.close();


		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}


	public static void Insert_Lizenc_1(JLabel Licence_Nr,JTextField Bar_Nr,JLabel Date){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
		try{
			int i =Integer.parseInt(Licence_Nr.getText());
			int j = i+77;
			Licence_Nr.setText(String.valueOf(j));
			// Neue Frage Hinzufügen

			String sql = "INSERT INTO Spiel_Licence (Licence_Nr, Kneipe_Nr, Datum, Vermerk)VALUES (?,?,?,?)" ;
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, Licence_Nr.getText());
			pst.setString(2, Bar_Nr.getText());
			pst.setString(3, Date.getText());
			pst.setString(4, "1");

			pst.execute();
			JOptionPane.showMessageDialog(null,"Teilname Bestätigung");

		} catch (Exception e1) {
			e1.printStackTrace();
		}





	}

	public static void Max_Lizenc_Nr(JLabel l){ ////
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();
		try {	 ///
			String query="select max(Licence_Nr) from Spiel_Licence";

			PreparedStatement pst1=con.prepareStatement(query);

			ResultSet rs= pst1.executeQuery();

			if ((rs.next()))
			{

				l.setText(rs.getString("max(Licence_Nr)"));
			}

			pst1.close();


		} catch (Exception e3) {
			e3.printStackTrace();
		}

	}


	public static void Bar_Nr_1(JComboBox C){ //// Combo_Box Fragen_Nr
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();
		try{
			String query2="select DISTINCT Kneipe_Nr from Kneipe_Teilnehmer where Vermerk =1";
			PreparedStatement pst1=con.prepareStatement(query2);

			ResultSet rs= pst1.executeQuery();
			while (rs.next()){
				String Kneipe_Nr = rs.getString("Kneipe_Nr");
				C.addItem(Kneipe_Nr);

			}

			rs.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}
	}





	public static void Select_Bar_1( JLabel Ad,JLabel Bes,JLabel Tele,JLabel mail,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try {
			String query1="select Adresse, Telefon_Nr, Besitzer, Email from Kneipe_Teilnehmer where Kneipe_Nr='"+CB.getSelectedItem().toString()+"'";
			PreparedStatement pst11=con.prepareStatement(query1);

			ResultSet rs1= pst11.executeQuery();
			while (rs1.next()){
				String Adresse = rs1.getString("Adresse");
				Ad.setText(Adresse);
				String Telefon_Nr = rs1.getString("Telefon_Nr");
				Tele.setText(Telefon_Nr);
				String Besitzer = rs1.getString("Besitzer");
				Bes.setText(Besitzer);
				String Email = rs1.getString("Email");
				mail.setText(Email);

			}

			rs1.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}

	}



	public static void Update_Lizenc1(JComboBox CB){ ////
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();


		try{

			String value115=CB.getSelectedItem().toString();
			String sql22="update Spiel_Licence set Vermerk=0 ,Licence_Nr='S' where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();


			//JOptionPane.showMessageDialog(null,"Gespeert");


		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Ungültiger Eintrag");
		}


	}



	public static void Update_Lizenc2(JComboBox CB){ ////
		//con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();


		try{

			String value115=CB.getSelectedItem().toString();
			String sql22="update Kneipe_Teilnehmer set Vermerk=2  where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();


			JOptionPane.showMessageDialog(null,"Die Kneipe Nr: '"+value115+"' wurde erfolgreich gespeert");


		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Prüfen Sie ihre Eingabe");
		}


	}

	public static void Table_Bar_Reg(JTable t) {

		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();

		try {
			String query="select Bar_Nr as Kneipennummer,Surname as Vorname,First_Name as Nachname,Street as Strasse,City as Stadt,Post as PLZ,Mobil as Telefonnummer,Mail as Email,Nickname as Kneipenname from Bar where Note=1 or Note =0";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void Bar_Nr_2(JComboBox C){ //// Combo_Box Fragen_Nr
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();
		try{
			String query2="select  Bar_Nr from Bar where Note=1 or Note=0";
			PreparedStatement pst1=con.prepareStatement(query2);

			ResultSet rs= pst1.executeQuery();
			while (rs.next()){
				String Kneipe_Nr = rs.getString("Bar_Nr");
				C.addItem(Kneipe_Nr);

			}

			rs.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}

	}


	public static void Select_Bar_Info( JTextField name1,JTextField vorname1,JTextField strasse1,JTextField stadt1,JTextField plz1,JTextField tel1,JTextField email1,JTextField bar1,JTextArea msg1,JComboBox CB){ //// Combo_Box Fragen_Nr
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		try {
			String query1="select Surname,First_Name,Street,City,Post,Mobil,Mail,Nickname,Message from Bar where Bar_Nr='"+CB.getSelectedItem().toString()+"'";
			PreparedStatement pst11=con.prepareStatement(query1);

			ResultSet rs1= pst11.executeQuery();
			while (rs1.next()){
				String name = rs1.getString("Surname");
				name1.setText(name);
				String vorname = rs1.getString("First_Name");
				vorname1.setText(vorname);
				String strasse = rs1.getString("Street");
				strasse1.setText(strasse);
				String stadt = rs1.getString("City");
				stadt1.setText(stadt);
				String plz = rs1.getString("post");
				plz1.setText(plz);
				String tel = rs1.getString("Mobil");
				tel1.setText(tel);
				String email = rs1.getString("Mail");
				email1.setText(email);
				String bar = rs1.getString("Nickname");
				bar1.setText(bar);
				String msg = rs1.getString("Message");
				msg1.setText(msg);

			}

			rs1.close();

		}
		catch(Exception e2){
			e2.printStackTrace();

		}

	}





}
