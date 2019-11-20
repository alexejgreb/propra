import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;


public class Spiel_Starten {

	private JFrame frame;
	private static JTable table;
	private JTextField licence;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t1;
	private static JLabel lb;
	private static JLabel lb2;
	private static JLabel l3;
	private static JLabel l4;
	private static JLabel lbl,l11;
private JTextArea ta,t2;
private JComboBox cb,cc;
private static JComboBox c1;
private JButton btnNewButton_1;
private static JButton btnAuto;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void Screen2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spiel_Starten window = new Spiel_Starten();
					window.frame.setVisible(true);
					lbl.setVisible(false);
					tf.setVisible(false);
					tr.setVisible(false);
					l.setVisible(false);
					lb.setVisible(false);
					l3.setVisible(false);
					lb2.setVisible(false);
					l11.setVisible(false);
					l4.setVisible(false);
					l8.setVisible(false);
					s2.setVisible(false);
					ss.setVisible(false);
					s.setVisible(false);
					tz.setVisible(false);
					
					btnAuto.setEnabled(false);
					
					////
					
					
					
					try{
						
						
						String query2="select FrageNr from Fragen_Pool ";
						PreparedStatement pst1=con.prepareStatement(query2);
						
						ResultSet rs= pst1.executeQuery();
						//c1.removeAllItems();
						while (rs.next()){
							
							
							String FrageNr = rs.getString("FrageNr");
							c1.addItem(FrageNr);
							
						}
						
						rs.close();
						
						}
					catch(Exception e2){
						e2.printStackTrace();
					
					}
					
					try{
						String query2="select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1";
						PreparedStatement pst1=con.prepareStatement(query2);
						
						ResultSet rs= pst1.executeQuery();
						CB1.removeAllItems();
						while (rs.next()){
							String Spiel_Nummer = rs.getString("Spiel_Nummer");
							CB1.addItem(Spiel_Nummer);
							
						}
						
						rs.close();
						
						}
					catch(Exception e2){
						e2.printStackTrace();
					
					}
					
					try {
						String query="select Spiel_Nummer,Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,ErsteWahl as Richtige_Antwort from (Fragen_Pool  , Quiz_Fragen) where Quiz_Fragen.Frage_Nr=Fragen_Pool.FrageNr ORDER by Spiel_Nummer";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
							

					} catch (Exception e1) {
						e1.printStackTrace();
					}	
					
					
					//////
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	static Connection con =null;
	private static JTextField tf;
	private static JTextField tr;
	private static JLabel l8;
	private static JComboBox CB1;
	private JButton btnBenden;
	private JScrollPane scrollPane_2;
	private JLabel label;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JLabel l;
	private JLabel lblStart;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblDatum;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JLabel Zeit;
	private static JLabel s;
	private JLabel lblNewLabel_3;
	private static JLabel tz, s2;
	private static JLabel lic,ss;
	private JTextField textField;
	private JTextField aar;
	private JTextField aar2;
	private JLabel bild1;
	private JLabel n;
	
	
	public void Clock(){
		Calendar cal = new GregorianCalendar();
		int Tag = cal.get(Calendar.DAY_OF_MONTH);
		int Jahre = cal.get(Calendar.YEAR);
		int Monat = cal.get(Calendar.MONTH);
		
		
		
		Zeit.setText(+Tag+"/"+Monat+"/"+Jahre);
	
		
		
	}
	
	
	public Spiel_Starten() {
		initialize();
		Clock();
		con=Database.dbConnector();
		frame.setResizable(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1269, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 380, 833, 224);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				////
				aar.setVisible(false);
				aar2.setVisible(false);
				try{
					String query2="select Licence_Nr from Spiel_Licence where vermerk =1 and Licence_Nr='"+licence.getText()+"' limit 1";
					PreparedStatement pst1=con.prepareStatement(query2);
					
					ResultSet rs= pst1.executeQuery();
					
					while (rs.next()){
						
						l.setText("1");
						
						
					}
					
					rs.close();
					
					}
				catch(Exception e22){
					e22.printStackTrace();
					JOptionPane.showMessageDialog(null,e22);
				}
				
				////
				
				
				
				
				
				
				
				
			
				//c1.removeAllItems();
				//CB1.removeAllItems();
				
				lb2.setVisible(false);
				lb.setVisible(false);
				l4.setVisible(false);
				l3.setVisible(false);
				l8.setVisible(false);
				l11.setVisible(false);
				s2.setVisible(false);
				
				
				 int i =Integer.parseInt(l.getText());
                 if(i==1){
                		cb.setEnabled(true);
        				cc.setEnabled(true);
        				btnNewButton_1.setEnabled(true);
        				btnBenden.setEnabled(true);
        				btnAuto.setEnabled(true);
        				JOptionPane.showMessageDialog(null,"Diese Lizenc '"+licence.getText()+"' gültig n ur für ein einzigen Spiel");
        				try {	 /// 		
        				    String query="select max (Spiel_Nummer) from Spiel_Gnehmigt";
        				    
        					PreparedStatement pst1=con.prepareStatement(query);
        					
        					ResultSet rs= pst1.executeQuery();
        					
        					 if ((rs.next()))
        					 {
        						
        						 t1.setText(rs.getString("max (Spiel_Nummer)"));
        					 }
        					
        						pst1.close();
        						

        					} catch (Exception e31) {
        						e31.printStackTrace();
        						JOptionPane.showMessageDialog(null,e31);
        					}	
        				
        				//
        				
        				 int k =Integer.parseInt(t1.getText());
                         int k1=k+1;
                         t1.setText(String.valueOf(k1));	
        				
				try{
					String query2="select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1";
					PreparedStatement pst2=con.prepareStatement(query2);
					
					ResultSet rs2= pst2.executeQuery();
					
					while (rs2.next()){
						String Spiel_Nummer = rs2.getString("Spiel_Nummer");
						CB1.addItem(Spiel_Nummer);
						
					}
					
					rs2.close();
					
					}
				catch(Exception e0){
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(null,e0);
				}
				try{
					String query4="select FrageNr from Fragen_Pool";
					PreparedStatement pst4=con.prepareStatement(query4);
					
					ResultSet rs4= pst4.executeQuery();
					while (rs4.next()){
						String FrageNr = rs4.getString("FrageNr");
						c1.addItem(FrageNr);
						
					}
					
					rs4.close();
					
					}
				catch(Exception e1){
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(null,e1);
				}
			
                 }
                 if(i==0){
                	lbl.setText(textField_1.getText()+textField_2.getText());
                	//
                		try{
        					String query2="select Licence_Nr from Spiel_Licence where vermerk ='"+textField_1.getText()+"' and Licence_Nr='"+lbl.getText()+"' limit 1";
        					PreparedStatement pst1=con.prepareStatement(query2);
        					
        					ResultSet rs= pst1.executeQuery();
        					
        					if (rs.next()){
        						
        						btnNewButton_1.setEnabled(true);
                				btnBenden.setEnabled(true);
                				btnAuto.setEnabled(true);
                				
        						
        						String Licence_Nr = rs.getString("Licence_Nr");
    							licence.setText(Licence_Nr);
        						l.setText("2");
        						rs.close();
        						JOptionPane.showMessageDialog(null,"Sie dürfen Beliebig oft Spiele Starten , Die Krombacher behält das Recht ihre Lizenc jeder Zeit zu Kündigen sofern nicht anders vereinbart :)");
        					}
    							
    							/////
                		else{
   						 JOptionPane.showMessageDialog(null,"Ungültige Zugangsdaten");
   	                		cb.setEnabled(false);
   	        				cc.setEnabled(false);
   	        				btnNewButton_1.setEnabled(false);
   	        				//btnBenden.setEnabled(false);
   					}
        					int i2 =Integer.parseInt(l.getText());	
        					if(i2==2){
    							cb.setEnabled(true);
    	        				cc.setEnabled(true);
    	        				btnNewButton_1.setEnabled(true);
    	        				btnBenden.setEnabled(true);
    	        		//
    	        				try {	 /// 		
    	        				    String query0="select max (Spiel_Nummer) from Spiel_Gnehmigt";
    	        				    
    	        					PreparedStatement pst10=con.prepareStatement(query0);
    	        					
    	        					ResultSet rs0= pst10.executeQuery();
    	        					
    	        					 if ((rs0.next()))
    	        					 {
    	        						
    	        						 t1.setText(rs0.getString("max (Spiel_Nummer)"));
    	        					 }
    	        					
    	        						pst10.close();
    	        						

    	        					} catch (Exception e3) {
    	        						e3.printStackTrace();
    	        					}	
    	        				
    	        				//
    	        				
    	        				 int k =Integer.parseInt(t1.getText());
    	                         int k1=k+1;
    	                         t1.setText(String.valueOf(k1));	
    	        				
    					try{
    						String query22="select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1";
    						PreparedStatement pst11=con.prepareStatement(query22);
    						
    						ResultSet rs1= pst11.executeQuery();
    						
    						while (rs1.next()){
    							String Spiel_Nummer = rs1.getString("Spiel_Nummer");
    							CB1.addItem(Spiel_Nummer);
    							
    						}
    						
    						rs1.close();
    						
    						}
    					catch(Exception e4){
    						//e2.printStackTrace();
    						JOptionPane.showMessageDialog(null,e4);
    					
    					}
    					try{
    						String query23="select FrageNr from Fragen_Pool";
    						PreparedStatement pst13=con.prepareStatement(query23);
    						
    						ResultSet rs3= pst13.executeQuery();
    						while (rs3.next()){
    							String FrageNr = rs3.getString("FrageNr");
    							c1.addItem(FrageNr);
    							
    						}
    						
    						rs3.close();
    						
    						}
    					catch(Exception e3){
    						//e2.printStackTrace();
    						JOptionPane.showMessageDialog(null,e3);
    					
    					}
    				btnAuto.setEnabled(true);
    							
    							
    							
    							//////
    							
    							
        				
        					
        					
        					
        					}}
        				catch(Exception e2){
        					//e2.printStackTrace();
        					JOptionPane.showMessageDialog(null,e2);
        				
        				}
                	 
                		
                	 
                	 
                	 
                
                 }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(739, 25, 73, 25);
		frame.getContentPane().add(btnNewButton);
		
		licence = new JTextField();
		licence.setText("000000");
		licence.setBounds(536, 27, 191, 22);
		frame.getContentPane().add(licence);
		licence.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Frage_Nr:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(238, 99, 140, 24);
		frame.getContentPane().add(lblNewLabel);
		
		 c1 = new JComboBox();
		 c1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		
try {	 ///  
					
				    String query="select  Frage ,ErsteWahl ,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort from Fragen_Pool WHERE FrageNr= ? ";
				    
					PreparedStatement pst1=con.prepareStatement(query);
					pst1.setString(1, c1.getSelectedItem().toString());
					ResultSet rs= pst1.executeQuery();
					
					 if ((rs.next()))
					 {
						
						t2.setText(rs.getString("Frage"));
						t3.setText(rs.getString("RichtigeAntwort"));
						t4.setText(rs.getString("ErsteWahl"));
					t5.setText(rs.getString("ZweiteWahl"));
					t6.setText(rs.getString("DritteWahl"));
					t7.setText(rs.getString("VierteWahl"));
					 }
					
						pst1.close();
						

					} catch (Exception e3) {
						e3.printStackTrace();
					}
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		c1.setBounds(412, 96, 41, 22);
		frame.getContentPane().add(c1);
		
		JLabel lblFrage = new JLabel("Frage:");
		lblFrage.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblFrage.setForeground(Color.BLACK);
		lblFrage.setBounds(238, 139, 159, 25);
		frame.getContentPane().add(lblFrage);
		
		JLabel lblNewLabel_1 = new JLabel("A:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(367, 223, 41, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblZweitewahl = new JLabel("B:");
		lblZweitewahl.setForeground(Color.BLACK);
		lblZweitewahl.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblZweitewahl.setBounds(367, 264, 41, 25);
		frame.getContentPane().add(lblZweitewahl);
		
		JLabel lblDrittewahl = new JLabel("C:");
		lblDrittewahl.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblDrittewahl.setForeground(Color.BLACK);
		lblDrittewahl.setBounds(367, 298, 41, 24);
		frame.getContentPane().add(lblDrittewahl);
		
		JLabel lblViertewahl = new JLabel("D:");
		lblViertewahl.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblViertewahl.setForeground(Color.BLACK);
		lblViertewahl.setBounds(367, 332, 41, 29);
		frame.getContentPane().add(lblViertewahl);
		
		JLabel lblRichtigeantwort = new JLabel("Richtige_Antwort:");
		lblRichtigeantwort.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblRichtigeantwort.setForeground(Color.BLACK);
		lblRichtigeantwort.setBounds(181, 184, 227, 33);
		frame.getContentPane().add(lblRichtigeantwort);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(412, 193, 444, 22);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(412, 228, 444, 22);
		frame.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(412, 263, 444, 22);
		frame.getContentPane().add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBounds(412, 298, 444, 22);
		frame.getContentPane().add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 13));
		t7.setEditable(false);
		t7.setColumns(10);
		t7.setBounds(412, 333, 444, 22);
		frame.getContentPane().add(t7);
		
		 btnNewButton_1 = new JButton("Manuell");
		 btnNewButton_1.setEnabled(false);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnNewButton_1.setEnabled(true);
				btnBenden.setEnabled(false);
				btnAuto.setEnabled(false);
				lb.setText(tf.getText());
				lb2.setText(tr.getText());
				
				int i =Integer.parseInt(lb.getText());
				int i2 = Integer.parseInt(lb2.getText());
				int i2121 =Integer.parseInt(cc.getSelectedItem().toString());
				int s = i*i2;
				l4.setText(String.valueOf(s));
				l3.setText(cb.getSelectedItem().toString());
				int i21 = Integer.parseInt(l4.getText());
				
				int i11 =Integer.parseInt(l3.getText());
				if(s!=0){
					
				
				  try{
					
					// Quiz_Fragen_Hinzufügen
					
					String sql = "insert into Quiz_Fragen(Spiel_Nummer,Frage_Nr) VALUES(?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, t1.getText());
					pst.setString(2, c1.getSelectedItem().toString());
					
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null,"Save");
					if(i11!=i21){

				ta.append("\t Frage_Hinzugefügt: \n\n"+"Spiel_Nr:\t"+t1.getText()+"\n======================================\n"+"Runde_Nr:\t"+l11.getText()+"\n======================================\n"+"FrageNr:\t"+c1.getSelectedItem().toString()+"\n======================================\n"+"Frage:\t"+t2.getText()+"\n\n"+"Antwort :\t"+t4.getText()+"\n\n"+
						" \t"+" \n======================================\n");	
					}
				if(i11==i21 &i2121 !=1){
					
					int i1112 =Integer.parseInt(l11.getText());
					int i1113=i1112+1;
					l8.setText(String.valueOf(i1113));
					ta.append("\t Frage_Hinzugefügt: \n\n"+"Spiel_Nr:\t"+t1.getText()+"\n======================================\n"+"Runde_Nr:\t"+l11.getText()+"\n======================================\n"+"FrageNr:\t"+c1.getSelectedItem().toString()+"\n======================================\n"+"Frage:\t"+t2.getText()+"\n\n"+"Antwort :\t"+t4.getText()+"\n\n"+
							" \t"+" \n======================================\n");
				}
							
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
				
			
			s=s-1;
			tf.setText("1");
			
			tr.setText(String.valueOf(s));	
			l4.setText(String.valueOf(s));
				}
				if(s==0){
					JOptionPane.showMessageDialog(null,"Reicht");
					
					int i9 =Integer.parseInt(l.getText());
					
					if(i9==1){
					try{
						 
						
						String value115=licence.getText();
				String sql22="update Spiel_Licence set Vermerk=0 where Licence_Nr='"+value115+"' ";
				PreparedStatement pst3=con.prepareStatement(sql22);
				pst3.execute();
				
				
				
				String sql = "insert into Spiel_Gnehmigt (Spiel_Nummer,Datum,Lizenc,Kneipe_Nummer,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel)values (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, t1.getText());
				pst.setString(2, Zeit.getText());
				pst.setString(3, licence.getText());
				pst.setString(4, textField_1.getText());
				pst.setString(5, "1");
				pst.setString(6, comboBox.getSelectedItem().toString());
				pst.setString(7, comboBox_1.getSelectedItem().toString());
				pst.setString(8, comboBox_2.getSelectedItem().toString());
				pst.setString(9, comboBox_3.getSelectedItem().toString());
				pst.setString(10, comboBox_4.getSelectedItem().toString());
				
				
				pst.execute();
				JOptionPane.showMessageDialog(null,"Gespeichert");
				
				
				
				
				
				
					}
					catch(Exception e11){
						e11.printStackTrace();
					}
					
					

					ta.append("\t Spiel_angemeldet: \n\n"+"Spiel_Nr:\t"+t1.getText()+"\n============================================================================\n"+"Anzahl_Runden:\t"+cc.getSelectedItem().toString()+"\n============================================================================\n"+"Lizenc_Nummer:\t"+licence.getText()+"\n============================================================================\n"+"Start:\t"+comboBox.getSelectedItem().toString()+":"+comboBox_1.getSelectedItem().toString()+"\n============================================================================\n"+"Datum:\t"+comboBox_2.getSelectedItem().toString()+"/"+comboBox_3.getSelectedItem().toString()+"/"+comboBox_4.getSelectedItem().toString()+"\n\n"+
							" \t"+" \n============================================================================\n"+" \n============================================================================\n"+Zeit.getText()+"\n============================================================================\n"+"\n============================================================================\n"+"\n============================================================================\n");
					
					l.setText("0");
					licence.setText("");
					btnNewButton_1.setEnabled(false);
					btnBenden.setEnabled(false);
					t1.setText("");
					
				}
				if(i9==2){
					
					
					////
					
try{
						/* 
						
						String value115=licence.getText();
				String sql22="update Spiel_Licence set Vermerk=0 where Licence_Nr='"+value115+"' ";
				PreparedStatement pst3=con.prepareStatement(sql22);
				pst3.execute();
				
				*/
				
				String sql = "insert into Spiel_Gnehmigt (Spiel_Nummer,Datum,Lizenc,Kneipe_Nummer,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel)values (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, t1.getText());
				pst.setString(2, Zeit.getText());
				pst.setString(3, licence.getText());
				pst.setString(4, textField_1.getText());
				pst.setString(5, "1");
				pst.setString(6, comboBox.getSelectedItem().toString());
				pst.setString(7, comboBox_1.getSelectedItem().toString());
				pst.setString(8, comboBox_2.getSelectedItem().toString());
				pst.setString(9, comboBox_3.getSelectedItem().toString());
				pst.setString(10, comboBox_4.getSelectedItem().toString());
				
				
				pst.execute();
				JOptionPane.showMessageDialog(null,"Gespeichert");
				
				
				
				
				
				
					}
					catch(Exception e11){
						e11.printStackTrace();
					}
					
					

					ta.append("\t Spiel_angemeldet: \n\n"+"Spiel_Nr:\t"+t1.getText()+"\n============================================================================\n"+"Anzahl_Runden:\t"+cc.getSelectedItem().toString()+"\n============================================================================\n"+"Lizenc_Nummer:\t"+licence.getText()+"\n============================================================================\n"+"Start:\t"+comboBox.getSelectedItem().toString()+":"+comboBox_1.getSelectedItem().toString()+"\n============================================================================\n"+"Datum:\t"+comboBox_2.getSelectedItem().toString()+"/"+comboBox_3.getSelectedItem().toString()+"/"+comboBox_4.getSelectedItem().toString()+"\n\n"+
							" \t"+" \n============================================================================\n"+" \n============================================================================\n"+Zeit.getText()+"\n============================================================================\n"+"\n============================================================================\n"+"\n============================================================================\n");
					
					l.setText("0");
					licence.setText("");
					btnNewButton_1.setEnabled(false);
					btnBenden.setEnabled(false);
					t1.setText("");
					
					/////
					
					
					
				}
				}
				if(i11==i21 & i2121 !=1){
					JOptionPane.showMessageDialog(null,"Erste Runde erledigt");
					//DELETE Where FrageNr= 
					int i111 =Integer.parseInt(l11.getText());
					i111=i111+1;
					l11.setText(String.valueOf(i111));
					
				}
				
			}
				
			
		});
		btnNewButton_1.setBounds(12, 136, 129, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(880, 137, 351, 478);
		frame.getContentPane().add(scrollPane_1);
		
		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);
		
		 btnBenden = new JButton("Beenden");
		 btnBenden.setEnabled(false);
		 btnBenden.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		btnNewButton_1.setEnabled(false);
				btnBenden.setEnabled(true);
				btnAuto.setEnabled(false);
		 		
		 		int i =Integer.parseInt(ss.getText());
		 		
		 		if(i==1){
		 		
                 int YesorNo = JOptionPane.showConfirmDialog(null, " Sind sie sicher wollen sie dieses Spiel mit der SpielNr:  ,"+s.getText()+",   Beenden!!!!!","Spiel Beenden",JOptionPane.YES_NO_OPTION);
				
				if(YesorNo==0){
					
					lic.setText(textField_1.getText()+textField_2.getText());
					///
					try{
						String query2="select * from Spiel_Licence where Licence_Nr='"+lic.getText()+"' and Vermerk != 0";
						PreparedStatement pst1=con.prepareStatement(query2);
						
						ResultSet rs= pst1.executeQuery();
						
						while (rs.next()){
							
							n.setText("1");
							
							
						}
						
						rs.close();
						
						}
					catch(Exception e22){
						e22.printStackTrace();
						JOptionPane.showMessageDialog(null,e22);
					}
					///
					
					int d =Integer.parseInt(n.getText());
					
					
					if(d==0){
					
					String value1155=CB1.getSelectedItem().toString();
		 		try {
				
				String sql22="update Spiel_Gnehmigt set status =0 where Spiel_Nummer ='"+value1155+"' ";
				PreparedStatement pst3;
				
					pst3 = con.prepareStatement(sql22);
					pst3.execute();
					
					ta.append("\t\t Spiel_Beendet: \n\n"+"Spiel_Nr:\t"+s.getText()+"\n======================================\n"+"Datum:\t"+Zeit.getText()+"\n======================================\n"+"Kneipe_Nr:\t"+textField_1.getText()+"\n\n"+"\n\n======================================\n\n"+
							" \t"+" \n======================================\n");
					
					
					JOptionPane.showMessageDialog(null,"Erfolgreich Beendet und nicht statt gefunden");
					
					btnNewButton_1.setEnabled(false);
				} catch (SQLException e1) {
					// TODO uto-generated catch block
					e1.printStackTrace();
				}
		 		
		 		
				////
		 		
		 		
				try{
					
					
					String query2="select Licence_Nr from Spiel_Licence, Spiel_Gnehmigt where Spiel_Gnehmigt.Lizenc = Spiel_Licence.Licence_Nr and Spiel_Gnehmigt.Spiel_Nummer='"+value1155+"' ";
					PreparedStatement pst1=con.prepareStatement(query2);
					
					ResultSet rs= pst1.executeQuery();
					//c1.removeAllItems();
					while (rs.next()){
						
						
						String Licence_Nr = rs.getString("Licence_Nr");
						
						s2.setText(Licence_Nr);
					}
					
					rs.close();
					
					}
				catch(Exception e2){
					e2.printStackTrace();
				
				}
				
				
				/////
				String value11555=s2.getText();
				try {
					
					String sql22="update Spiel_Licence set Vermerk=0 where Licence_Nr='"+value11555+"' ";
					PreparedStatement pst3;
					
						pst3 = con.prepareStatement(sql22);
						pst3.execute();
						
					
						
						btnNewButton_1.setEnabled(false);
					} catch (SQLException e1) {
						// TODO uto-generated catch block
						e1.printStackTrace();
					}
				
		 		////
					}else if(d==1){
						
						
						
						
						String value1155=CB1.getSelectedItem().toString();
			 		try {
					
					String sql22="update Spiel_Gnehmigt set status =0 where Spiel_Nummer ='"+value1155+"' ";
					PreparedStatement pst3;
					
						pst3 = con.prepareStatement(sql22);
						pst3.execute();
						
						ta.append("\t\t Spiel_Beendet: \n\n"+"Spiel_Nr:\t"+s.getText()+"\n======================================\n"+"Datum:\t"+Zeit.getText()+"\n======================================\n"+"Kneipe_Nr:\t"+textField_1.getText()+"\n\n"+"\n\n======================================\n\n"+
								" \t"+" \n======================================\n");
						
						
						JOptionPane.showMessageDialog(null,"Erfolgreich Beendet und nicht statt gefunden");
						
						btnNewButton_1.setEnabled(false);
					} catch (SQLException e1) {
						// TODO uto-generated catch block
						e1.printStackTrace();
					}	
						
						
						
						
					}
				
				
				}
				else{
		 			JOptionPane.showMessageDialog(null,"Es ist nichts passiert!!!!");
		 		}
				
		 		}
		 		
		 		if(i==0){
		 			JOptionPane.showMessageDialog(null,"Gültiges Antrag eingeben");
		 		}
		 	}
		 });
		btnBenden.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBenden.setForeground(new Color(255, 0, 0));
		btnBenden.setBounds(12, 229, 129, 33);
		frame.getContentPane().add(btnBenden);
		
		JLabel lblZeit = new JLabel("Spiel_Nummer");
		lblZeit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblZeit.setForeground(new Color(255, 0, 0));
		lblZeit.setBounds(12, 66, 153, 16);
		frame.getContentPane().add(lblZeit);
		
		t1 = new JTextField();
		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		t1.setEditable(false);
		t1.setBounds(169, 64, 164, 22);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnZurck = new JButton("Zurück");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Kneipen_Besitzer KB= new Kneipen_Besitzer();
				try {
					KB.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
				
			}
		});
		btnZurck.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnZurck.setForeground(new Color(255, 0, 0));
		btnZurck.setBounds(12, 280, 129, 33);
		frame.getContentPane().add(btnZurck);
		
		JButton btnbersicht = new JButton("Übersicht");
		btnbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				/*
				
				try{
					
					
					String query2="select FrageNr from Fragen_Pool ";
					PreparedStatement pst1=con.prepareStatement(query2);
					
					ResultSet rs= pst1.executeQuery();
					//c1.removeAllItems();
					while (rs.next()){
						
						
						String FrageNr = rs.getString("FrageNr");
						c1.addItem(FrageNr);
						
					}
					
					rs.close();
					
					}
				catch(Exception e2){
					e2.printStackTrace();
				
				}
				
				try{
					String query2="select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1";
					PreparedStatement pst1=con.prepareStatement(query2);
					
					ResultSet rs= pst1.executeQuery();
					CB1.removeAllItems();
					while (rs.next()){
						String Spiel_Nummer = rs.getString("Spiel_Nummer");
						CB1.addItem(Spiel_Nummer);
						
					}
					
					rs.close();
					
					}
				catch(Exception e2){
					e2.printStackTrace();
				
				}
				
				try {
					String query="select Spiel_Nummer,Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,RichtigeAntwort from (Fragen_Pool  , Quiz_Fragen) where Quiz_Fragen.Frage_Nr=Fragen_Pool.FrageNr ORDER by Spiel_Nummer";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						

				} catch (Exception e1) {
					e1.printStackTrace();
				}	
				*/
			}
		});
		btnbersicht.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnbersicht.setForeground(new Color(255, 0, 0));
		btnbersicht.setBounds(12, 188, 129, 33);
		frame.getContentPane().add(btnbersicht);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ta.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBounds(1134, 95, 97, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblFragenrunde = new JLabel("Fragen/Runde");
		lblFragenrunde.setForeground(Color.RED);
		lblFragenrunde.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFragenrunde.setBounds(705, 104, 137, 16);
		frame.getContentPane().add(lblFragenrunde);
		
		JLabel lblAnzahlRunden = new JLabel("Anzahl Runden");
		lblAnzahlRunden.setForeground(Color.RED);
		lblAnzahlRunden.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnzahlRunden.setBounds(695, 65, 137, 19);
		frame.getContentPane().add(lblAnzahlRunden);
		
		 cb = new JComboBox();
		 cb.setEnabled(false);
		 cb.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		tf.setText(cb.getSelectedItem().toString());
		 	}
		 });
		cb.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20"}));
		cb.setBounds(834, 96, 56, 22);
		frame.getContentPane().add(cb);
		
		 cc = new JComboBox();
		 cc.setEnabled(false);
		 cc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		tr.setText(cc.getSelectedItem().toString());
		 		
		 	}
		 });
		cc.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		cc.setBounds(834, 64, 56, 22);
		frame.getContentPane().add(cc);
		
	 lb = new JLabel("0");
	 lb.setEnabled(false);
		lb.setBounds(153, 126, 17, 16);
		frame.getContentPane().add(lb);
		
		 lb2 = new JLabel("0");
		 lb2.setEnabled(false);
		lb2.setBounds(208, 156, 17, 16);
		frame.getContentPane().add(lb2);
		
		 l3 = new JLabel("0");
		 l3.setEnabled(false);
		l3.setBounds(153, 140, 17, 16);
		frame.getContentPane().add(l3);
		
		tf = new JTextField();
		tf.setText("10");
		tf.setEditable(false);
		tf.setBounds(454, 61, 30, 22);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		tr = new JTextField();
		tr.setText("1");
		tr.setEditable(false);
		tr.setColumns(10);
		tr.setBounds(412, 64, 30, 22);
		frame.getContentPane().add(tr);
		
		 l4 = new JLabel("0");
		 l4.setEnabled(false);
		l4.setBounds(153, 237, 17, 16);
		frame.getContentPane().add(l4);
		
		 l11 = new JLabel("1");
		 l11.setEnabled(false);
		l11.setBounds(153, 266, 17, 16);
		frame.getContentPane().add(l11);
		
		l8 = new JLabel("0");
		l8.setEnabled(false);
		l8.setBounds(337, 307, 17, 16);
		frame.getContentPane().add(l8);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(409, 134, 447, 42);
		frame.getContentPane().add(scrollPane_2);
		
		t2 = new JTextArea();
		t2.setFont(new Font("Monospaced", Font.BOLD, 13));
		t2.setEditable(false);
		scrollPane_2.setViewportView(t2);
		
		 CB1 = new JComboBox();
		 CB1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 	
		 		
		 		
		 		tz.setText(CB1.getSelectedItem().toString());
		 		
		 		table.removeAll();
		 		s.setText(CB1.getSelectedItem().toString());
		 		ss.setText("1");
		 		btnBenden.setEnabled(true);
		 		try {
					String query="select Spiel_Nummer,Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl,ErsteWahl as Richtige_Antwort from (Fragen_Pool  , Quiz_Fragen) where Quiz_Fragen.Frage_Nr=Fragen_Pool.FrageNr and Spiel_Nummer =? ORDER by Spiel_Nummer ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, tz.getText());
					ResultSet rs= pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						

				} catch (Exception e1) {
					e1.printStackTrace();
				}	
		 		
		 		
		 	}
		 });
		CB1.setBounds(23, 345, 118, 22);
		frame.getContentPane().add(CB1);
		
		label = new JLabel("Kneipe_Nummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(10, 29, 147, 16);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("310514");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(169, 27, 68, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("#KneipeXXXY");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(238, 27, 93, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel lblZulassungsnummer = new JLabel("ZulassungsNummer:");
		lblZulassungsnummer.setForeground(Color.RED);
		lblZulassungsnummer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblZulassungsnummer.setBounds(345, 34, 177, 16);
		frame.getContentPane().add(lblZulassungsnummer);
		
		l = new JLabel("0");
		l.setBounds(446, 13, 56, 16);
		frame.getContentPane().add(l);
		
		lblStart = new JLabel("Start:");
		lblStart.setForeground(new Color(255, 0, 0));
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStart.setBounds(919, 67, 73, 16);
		frame.getContentPane().add(lblStart);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox.setBounds(1004, 64, 46, 22);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBox_1.setBounds(1062, 64, 46, 22);
		frame.getContentPane().add(comboBox_1);
		
		lblDatum = new JLabel("Datum:");
		lblDatum.setForeground(Color.RED);
		lblDatum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatum.setBounds(919, 35, 73, 16);
		frame.getContentPane().add(lblDatum);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2.setBounds(1004, 27, 46, 22);
		frame.getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_3.setBounds(1062, 27, 46, 22);
		frame.getContentPane().add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020"}));
		comboBox_4.setBounds(1120, 27, 73, 22);
		frame.getContentPane().add(comboBox_4);
		
		Zeit = new JLabel("New label");
		Zeit.setForeground(Color.RED);
		Zeit.setFont(new Font("Tahoma", Font.BOLD, 16));
		Zeit.setBounds(919, 100, 118, 16);
		frame.getContentPane().add(Zeit);
		
		s = new JLabel("00000");
		s.setBounds(169, 100, 56, 16);
		frame.getContentPane().add(s);
		
		lblNewLabel_3 = new JLabel("Offene_Quiz:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(22, 322, 119, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		s2 = new JLabel("0000");
		s2.setBounds(181, 126, 56, 16);
		frame.getContentPane().add(s2);
		
		ss = new JLabel("0");
		ss.setBounds(218, 306, 56, 16);
		frame.getContentPane().add(ss);
		
		 tz = new JLabel("*");
		tz.setBounds(169, 351, 56, 16);
		frame.getContentPane().add(tz);
		
		textField = new JTextField();
		textField.setBounds(465, 96, 41, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 btnAuto = new JButton("Auto.");
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aar.setVisible(true);
				aar2.setVisible(true);
				
				btnNewButton_1.setEnabled(false);
				btnBenden.setEnabled(false);
				btnAuto.setEnabled(true);
				
				aar.setText("Anzahl_Runden: "+cc.getSelectedItem().toString());
				aar2.setText("Fragen/Runde :"+cb.getSelectedItem().toString());
				btnNewButton_1.setEnabled(false);
				Auto_Fragen FQ= new Auto_Fragen();
				FQ.Fragen_Quiz();
				
			}
		});
		btnAuto.setForeground(Color.RED);
		btnAuto.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAuto.setBounds(12, 95, 129, 33);
		frame.getContentPane().add(btnAuto);
		
		aar = new JTextField();
		aar.setFont(new Font("Tahoma", Font.BOLD, 13));
		aar.setEditable(false);
		aar.setBounds(518, 64, 144, 22);
		frame.getContentPane().add(aar);
		aar.setColumns(10);
		
		aar2 = new JTextField();
		aar2.setFont(new Font("Tahoma", Font.BOLD, 13));
		aar2.setEditable(false);
		aar2.setColumns(10);
		aar2.setBounds(518, 99, 144, 22);
		frame.getContentPane().add(aar2);
		
		 lbl = new JLabel("*");
		lbl.setBounds(277, 351, 56, 16);
		frame.getContentPane().add(lbl);
		
		bild1 = new JLabel("");
		bild1.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\krombacher-spot-mood-flaschen (1).jpg"));
		bild1.setBounds(0, 0, 1263, 649);
		frame.getContentPane().add(bild1);
		
		 lic = new JLabel("New label");
		lic.setBounds(208, 266, 56, 16);
		frame.getContentPane().add(lic);
		
		n = new JLabel("0");
		n.setBounds(208, 306, 56, 16);
		frame.getContentPane().add(n);
	}
}
