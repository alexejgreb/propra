import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Kneipe_Verwaltung {

	private JFrame frame;
	private JTextField txt2;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
private static JComboBox C1;
private JTextArea ta1 ;
private static JLabel test,lb,Zeit,h;
private static JTable table;
private static JTextField text;
private static JScrollPane scrollPane ;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void NewScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kneipe_Verwaltung window = new Kneipe_Verwaltung();
					window.frame.setVisible(true);
					tk.setVisible(false);
					lb.setVisible(false);
					text.setVisible(false);
					test.setVisible(false);
					Clock();
					
					
					/*
					try {
						String query="select DISTINCT Kneipe_Nr ,Adresse, Telefon_Nr, Besitzer, Email from Kneipe_Teilnehmer where Vermerk =1;";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
							

					} catch (Exception e1) {
						e1.printStackTrace();
					}	
					*/
				//	C1.removeAllItems();
					
					DB_Anfragen.Table_Bar(table);
					/*
					try{
						String query2="select DISTINCT Kneipe_Nr from Kneipe_Teilnehmer where Vermerk =0";
						PreparedStatement pst1=con.prepareStatement(query2);
						
						ResultSet rs= pst1.executeQuery();
						while (rs.next()){
							String Kneipe_Nr = rs.getString("Kneipe_Nr");
							C1.addItem(Kneipe_Nr);
							
						}
						
						rs.close();
						
						}
					catch(Exception e2){
						e2.printStackTrace();
					
					}
					*/
					DB_Anfragen.Bar_Nr(C1);
					
					
					
					
					
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
	private static JTextField tk;
	
	
	public static void Clock(){
		Calendar cal = new GregorianCalendar();
		int Tag = cal.get(Calendar.DAY_OF_MONTH);
		int Jahre = cal.get(Calendar.YEAR);
		int Monat = cal.get(Calendar.MONTH);
		
		
		int Seconde = cal.get(Calendar.SECOND);
		int Minute= cal.get(Calendar.MINUTE);
		int Stunde = cal.get(Calendar.HOUR);
		Zeit.setText(+Tag+"/"+Monat+"/"+Jahre);
	h.setText(""+Stunde+":"+Minute+":"+Seconde);
		
		
	}
	
	public Kneipe_Verwaltung() {
		
		
		initialize();
		con=Database1.dbConnector();
		Clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1124, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Zurück");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin ad= new Admin();
				try {
					ad.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton.setBounds(12, 425, 204, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSperren = new JButton("Sperren");
		btnSperren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clock()	;
				int i1 =Integer.parseInt(text.getText());
	            
	            if(i1==0)	{
	            	JOptionPane.showMessageDialog(null,"Whälen sie eine offene Anfrage");
	            }
			if(i1!=0){
				
				/*
			
				try{
					 
					
					String value115=C1.getSelectedItem().toString();
			String sql22="update Kneipe_Teilnehmer set Vermerk=0 where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();
			JOptionPane.showMessageDialog(null,"Erfolgreich Gespeert");
			*/
			DB_Anfragen.Update_Bar_Member(C1);
			
			
			ta1.append("\t Teilnahme_Beenden: \n\n"+"Kneipe_Nr:\t"+C1.getSelectedItem().toString()+"\n======================================\n"+"Besitzer:\t"+txt3.getText()+"\n\n"+"Telefon_Nr:\t"
			+txt4.getText()+"\n\n"+"Email:\t"+txt5.getText()+" \t"+"Adresse:\t"+txt2.getText()+" \n======================================\n");	
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			txt6.setText("");
			
			/*
		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,e3);
		}
			*/	
			}}
		});
		btnSperren.setBounds(12, 189, 204, 46);
		frame.getContentPane().add(btnSperren);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(12, 366, 204, 46);
		frame.getContentPane().add(btnExit);
		
		JButton btnGenhemigen = new JButton("Genehmigung_Erteilen");
		btnGenhemigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//////// MUSS NOCH ERGÄNZT WERDEN :: FEHLER!!!!!
			Clock()	;
			int i1 =Integer.parseInt(text.getText());
            
            if(i1==0)	{
            	JOptionPane.showMessageDialog(null,"Whälen sie eine offene Anfrage");
            }
		if(i1!=0){
		/////
			
			try {	 /// 		
			    String query="select * from Spiel_Licence where Vermerk ='"+C1.getSelectedItem().toString()+"'";
			    
				PreparedStatement pst1=con.prepareStatement(query);
				
				ResultSet rs= pst1.executeQuery();
				
				 if ((rs.next()))
				 {
					
					 test.setText("1");
				 }
				
					pst1.close();
					

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			
			
			//DB_Anfragen.Select_Lizenc(C1, test);
			
		int i11 =Integer.parseInt(test.getText());
			
			if(i11==1){
				JOptionPane.showMessageDialog(null,"Sie haben eine unbefristete Lizenc bekommen ");
			}
		if(i11==0)	{
			//////
		
try {	 /// 		
				    String query="select max (Licence_Nr) from Spiel_Licence";
				    
					PreparedStatement pst1=con.prepareStatement(query);
					
					ResultSet rs= pst1.executeQuery();
					
					 if ((rs.next()))
					 {
						
						 lb.setText(rs.getString("max (Licence_Nr)"));
					 }
					
						pst1.close();
						

					} catch (Exception e3) {
						e3.printStackTrace();
					}
				
				

			
		//	DB_Anfragen.Max_Lizenc_Nr(lb);
                  
                   
                   
               
   				try{
   					 int i =Integer.parseInt(lb.getText());
                   int j = i+77;
                   lb.setText(String.valueOf(j));
   					// Neue Frage Hinzufügen
   					
   					String sql = "INSERT INTO Spiel_Licence (Licence_Nr, Kneipe_Nr, Datum, Vermerk)VALUES (?,?,?,?)" ;
   					PreparedStatement pst=con.prepareStatement(sql);
   					pst.setString(1, lb.getText());
   					pst.setString(2, txt1.getText());
   					pst.setString(3, Zeit.getText());
   					pst.setString(4, "1");
   					
   					pst.execute();
   					JOptionPane.showMessageDialog(null,"Teilname Bestätigung");

                   // DB_Anfragen.Insert_Lizenc_1(lb, txt1, Zeit);
   					ta1.append("\t Genehmigung_Spiel: \n======================================\n"+"Spiel_Nr:\t"+lb.getText()+"\n======================================\n"+"Kneipe_Nr:\t"+txt1.getText()+"\n======================================\n"+"Adresse:\t"+txt2.getText()+"\n======================================\n"+"Besitzer:\t"+txt3.getText()+"\n======================================\n"+"Telefon_Nr:\t"+txt4.getText()+"\n======================================\n"
   							+"Email:\t"+txt5.getText()+"\n======================================\n"+"\t"+"\n======================================\n"+" \t"+" \n======================================\n");	
   				
		} catch (Exception e1) {
   					e1.printStackTrace();
   				}	
				
				
				try{
					 
						
							String value115=C1.getSelectedItem().toString();
					String sql22="update Kneipe_Teilnehmer set Vermerk=1 where Kneipe_Nr='"+value115+"' ";
					PreparedStatement pst3=con.prepareStatement(sql22);
					pst3.execute();
					JOptionPane.showMessageDialog(null,"Erfolgreich Genehmigt");
					
					//DB_Anfragen.Update_Bar_Member(C1);
					ta1.append("\t Anfrage_Genehmigt: \n======================================\n"+
					"\n======================================\n"+" \t\n======================================\n"+"ZugangsNummer:\t"+lb.getText()+" \n======================================\n"+"Datum:\t"+Zeit.getText()+"\n======================================\n");	
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					text.setText("0");
					
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null,e3);
				}
				
		}}
			}
		});
		btnGenhemigen.setBounds(12, 71, 204, 46);
		frame.getContentPane().add(btnGenhemigen);
		
		JButton btnAktualisieren = new JButton("Aktualisieren");
		btnAktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clock();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				txt6.setText("");
				
			}
		});
		btnAktualisieren.setBounds(12, 307, 204, 46);
		frame.getContentPane().add(btnAktualisieren);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ta1.print();
				} catch (PrinterException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(983, 425, 98, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 484, 1037, 130);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 lb = new JLabel("1");
		 lb.setEnabled(false);
		lb.setBounds(12, 16, 17, 16);
		frame.getContentPane().add(lb);
		
		 Zeit = new JLabel("New label");
		 Zeit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Zeit.setBounds(960, 15, 134, 16);
		frame.getContentPane().add(Zeit);
		
		 h = new JLabel("New label");
		 h.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		h.setBounds(983, 44, 106, 16);
		frame.getContentPane().add(h);
		
		text = new JTextField();
		text.setEnabled(false);
		text.setEditable(false);
		text.setText("0");
		text.setBounds(12, 36, 196, 22);
		frame.getContentPane().add(text);
		text.setColumns(10);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(763, 73, 316, 339);
		 frame.getContentPane().add(scrollPane_1);
		
		 ta1 = new JTextArea();
		 scrollPane_1.setViewportView(ta1);
		 
		 JButton btnPrint = new JButton("Teilnahme_Verwaltung");
		 btnPrint.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		Teilnahme_Verwaltung TV= new Teilnahme_Verwaltung();
		 		TV.Screen();
		 		
		 	}
		 });
		 btnPrint.setBounds(12, 248, 204, 46);
		 frame.getContentPane().add(btnPrint);
		 
		 tk = new JTextField();
		 tk.setText("#KneipeXXXY");
		 tk.setEditable(false);
		 tk.setColumns(10);
		 tk.setBounds(824, 13, 93, 22);
		 frame.getContentPane().add(tk);
		 
		 JButton btnLizencerteilen = new JButton("Lizenc_Erteilen");
		 btnLizencerteilen.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 		
		 		
		 		Clock()	;
				int i1 =Integer.parseInt(text.getText());
	            
	            if(i1==0)	{
	            	JOptionPane.showMessageDialog(null,"Whälen sie eine offene Anfrage");
	            }
		 		
	            if(i1!=0){
	        		/////
	        			
	            	
	            	/*
	        			try {	 /// 		
	        			    String query="select * from Spiel_Licence where Vermerk ='"+C1.getSelectedItem().toString()+"'";
	        			    
	        				PreparedStatement pst1=con.prepareStatement(query);
	        				
	        				ResultSet rs= pst1.executeQuery();
	        				
	        				 if ((rs.next()))
	        				 {
	        					
	        					 test.setText("1");
	        				 }
	        				
	        					pst1.close();
	        					

	        				} catch (Exception e3) {
	        					e3.printStackTrace();
	        				}
	        			*/
	            	
	            	//
	            	DB_Anfragen.Select_Lizenc(C1, test);
	            	//
	            	
	        			
	        		int i11 =Integer.parseInt(test.getText());
	        			
	        			if(i11==1){
	        				JOptionPane.showMessageDialog(null,"Sie haben eine unbefristete Lizenc bekommen ");
	        			}
	        		if(i11==0)	{
                  lb.setText(C1.getSelectedItem().toString()+tk.getText());
		 	 	/*
   				try{
   					
   					// 
   					
   					String sql = "INSERT INTO Spiel_Licence (Licence_Nr, Kneipe_Nr, Datum, Vermerk)VALUES (?,?,?,?)" ;
   					PreparedStatement pst=con.prepareStatement(sql);
   					pst.setString(1, lb.getText());
   					pst.setString(2, txt1.getText());
   					pst.setString(3, Zeit.getText());
   					pst.setString(4, C1.getSelectedItem().toString());
   					
   					pst.execute();
   					JOptionPane.showMessageDialog(null,"Dauerhaft Lizenc erteilt");
*/
                  DB_Anfragen.Insert_Lizenc(lb, txt1, Zeit, C1);
   					ta1.append("\t Lizenc_Erteilt: \n===============================================================\n"+"	Lizenc_Nr:\t"+lb.getText()+"\n===============================================================\n"+"Kneipe_Nr:\t"+txt1.getText()+"\n===============================================================\n"+"Adresse:\t"+txt2.getText()+"\n===============================================================\n"+"Besitzer:\t"+txt3.getText()+"\n===============================================================\n"+"Telefon_Nr:\t"+txt4.getText()+"\n===============================================================\n"
   							+"Email:\t"+txt5.getText()+"\n===============================================================\n"+"\t"+"\n===============================================================\n"+" \t"+" \n===============================================================\n");	
   					/*
   				} catch (Exception e1) {
   					e1.printStackTrace();
   				}	
				*/
				///
   				
   				
   				
   				
   				
				/*try{
					 
						
							String value115=C1.getSelectedItem().toString();
					String sql22="update Kneipe_Teilnehmer set Vermerk=1 where Kneipe_Nr='"+value115+"' ";
					PreparedStatement pst3=con.prepareStatement(sql22);
					pst3.execute();
					JOptionPane.showMessageDialog(null,"Erfolgreich Genehmigt");
					
					*/
   				
   				DB_Anfragen.Update_Lizenc(C1);
					ta1.append("\t Lizenc_Bestätigt: \n===============================================================\n"+
					"\n===============================================================\n"+" \t\n===============================================================\n"+"Registriert unter der Nummer:\t"+lb.getText()+" \n===============================================================\n"+"Datum:\t"+Zeit.getText()+"\n===============================================================\n"+"\n Wir haben das Recht dieser Genehmigung jeder Zeit ohne Angabe von Gründen zu Wiederrufen \n"+"\n===============================================================\n");	
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					text.setText("0");
					
					/*
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null,e3);
				}
				*/
				
				//
				
				
				}}}
	             });
		 btnLizencerteilen.setBounds(12, 130, 204, 46);
		 frame.getContentPane().add(btnLizencerteilen);
		 
		  test = new JLabel("0");
		 test.setBounds(30, 16, 17, 16);
		 frame.getContentPane().add(test);
		 
		  C1 = new JComboBox();
		  C1.setBounds(469, 83, 183, 22);
		  frame.getContentPane().add(C1);
		  
		  JLabel lblNewLabel_2 = new JLabel("Anfrage:");
		  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblNewLabel_2.setBounds(303, 71, 154, 40);
		  frame.getContentPane().add(lblNewLabel_2);
		  
		  txt6 = new JTextField();
		  txt6.setBounds(469, 422, 227, 40);
		  frame.getContentPane().add(txt6);
		  txt6.setColumns(10);
		  
		  JLabel lblNewLabel_1 = new JLabel("Status:");
		  lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblNewLabel_1.setBounds(290, 425, 154, 40);
		  frame.getContentPane().add(lblNewLabel_1);
		  
		  txt5 = new JTextField();
		  txt5.setBounds(469, 369, 227, 40);
		  frame.getContentPane().add(txt5);
		  txt5.setColumns(10);
		  
		  JLabel lblEmail = new JLabel("Email:");
		  lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblEmail.setBounds(290, 366, 167, 40);
		  frame.getContentPane().add(lblEmail);
		  
		  txt4 = new JTextField();
		  txt4.setBounds(469, 310, 227, 40);
		  frame.getContentPane().add(txt4);
		  txt4.setColumns(10);
		  
		  JLabel lblTelephonnummer = new JLabel("Tel:");
		  lblTelephonnummer.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblTelephonnummer.setBounds(300, 307, 167, 40);
		  frame.getContentPane().add(lblTelephonnummer);
		  
		  txt3 = new JTextField();
		  txt3.setBounds(469, 251, 227, 40);
		  frame.getContentPane().add(txt3);
		  txt3.setColumns(10);
		  
		  JLabel lblBesitzer = new JLabel("Besitzer:");
		  lblBesitzer.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblBesitzer.setBounds(300, 248, 153, 40);
		  frame.getContentPane().add(lblBesitzer);
		  
		  txt2 = new JTextField();
		  txt2.setBounds(469, 192, 227, 40);
		  frame.getContentPane().add(txt2);
		  txt2.setColumns(10);
		  
		  JLabel lblAdresse = new JLabel("Adresse:");
		  lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblAdresse.setBounds(299, 189, 158, 40);
		  frame.getContentPane().add(lblAdresse);
		  
		  txt1 = new JTextField();
		  txt1.setBounds(469, 133, 227, 40);
		  frame.getContentPane().add(txt1);
		  txt1.setColumns(10);
		  
		  JLabel lblNewLabel = new JLabel("Name_Kneipe:");
		  lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		  lblNewLabel.setBounds(299, 130, 158, 40);
		  frame.getContentPane().add(lblNewLabel);
		  
		  JLabel lblNewLabel_3 = new JLabel("");
		  lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\krombacher-spot-mood-flaschen (1).jpg"));
		  lblNewLabel_3.setBounds(0, 1, 1106, 644);
		  frame.getContentPane().add(lblNewLabel_3);
		  C1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  	text.setText(C1.getSelectedItem().toString());	
	/*	  		
try {	 
					
				    String query="select Adresse,Telefon_Nr,Besitzer,Email,Vermerk from Kneipe_Teilnehmer where Kneipe_Nr= ? ";
				    
					PreparedStatement pst1=con.prepareStatement(query);
					pst1.setString(1, C1.getSelectedItem().toString());
					ResultSet rs= pst1.executeQuery();
					
					 if ((rs.next()))
					 {
						
						txt1.setText(C1.getSelectedItem().toString());
						txt2.setText(rs.getString("Adresse"));
						txt3.setText(rs.getString("Besitzer"));
					txt4.setText(rs.getString("Telefon_Nr"));
					txt5.setText(rs.getString("Email"));
					txt6.setText(rs.getString("Vermerk"));
					 }
					
						pst1.close();
						

					} catch (Exception e3) {
						e3.printStackTrace();
					}
		  		*/
		  		DB_Anfragen.Select_Bar(txt1, txt2, txt3, txt4, txt5, txt6, C1);
		  		
		  	}
		  });
	}
}
