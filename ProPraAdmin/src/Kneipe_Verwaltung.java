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
private static JLabel lb,Zeit,h;
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
					
					lb.setVisible(false);
					text.setVisible(false);
					Clock();
					try {
						String query="select * from Kneipe_Teilnehmer";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
							

					} catch (Exception e1) {
						e1.printStackTrace();
					}	
					
					C1.removeAllItems();
					try{
						String query2="select Kneipe_Nr from Kneipe_Teilnehmer where Vermerk =0;";
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
		btnNewButton.setBounds(12, 425, 153, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnndern = new JButton("Ändern");
		btnndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clock();
			}
		});
		btnndern.setBounds(12, 189, 153, 46);
		frame.getContentPane().add(btnndern);
		
		JButton btnSperren = new JButton("Sperren");
		btnSperren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clock();
				try{
					 
					
					String value115=C1.getSelectedItem().toString();
			String sql22="update Kneipe_Teilnehmer set Vermerk=0 where Kneipe_Nr='"+value115+"' ";
			PreparedStatement pst3=con.prepareStatement(sql22);
			pst3.execute();
			JOptionPane.showMessageDialog(null,"Erfolgreich Gespeert");
			
			
			ta1.append("\t\t Teilnahme_Beenden: \n\n"+"Kneipe_Nr:\t\t\t"+C1.getSelectedItem().toString()+"\n======================================\n"+"Besitzer:\t\t\t"+txt3.getText()+"\n\n"+"Telefon_Nr:\t\t\t"
			+txt4.getText()+"\n\n"+"Email:\t\t\t"+txt5.getText()+" \t\t\t"+"Adresse:\t\t\t"+txt2.getText()+" \n======================================\n");	
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			txt6.setText("");
		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,e3);
		}
				
			}
		});
		btnSperren.setBounds(12, 130, 153, 46);
		frame.getContentPane().add(btnSperren);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(12, 366, 153, 46);
		frame.getContentPane().add(btnExit);
		
		JButton btnGenhemigen = new JButton("Genhemigen");
		btnGenhemigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text.setVisible(false);
				lb.setVisible(false);
			Clock()	;
			int i1 =Integer.parseInt(text.getText());
            
            if(i1==0)	{
            	JOptionPane.showMessageDialog(null,"Whälen sie eine offene Anfrage");
            }
		if(i1!=0){
			
		
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
				
				

                  
                   
                   
               	
   				try{
   					 int i =Integer.parseInt(lb.getText());
                   int j = i+1;
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

   					ta1.append("\t Genehmigung_Spiel: \n======================================\n"+"Spiel_Nr:\t"+lb.getText()+"\n======================================\n"+"Kneipe_Nr:\t"+txt1.getText()+"\n======================================\n"+"Adresse:\t"+txt2.getText()+"\n======================================\n"+"Besitzer:\t"+txt3.getText()+"\n======================================\n"+"Telefon_Nr:\t"+txt4.getText()+"\n======================================\n"
   							+"Email:\t"+txt5.getText()+"\n======================================\n"+"\t"+"\n======================================\n"+" \t"+" \n======================================\n");	
   				} catch (Exception e1) {
   					e1.printStackTrace();
   				}	
				
				
				try{
					 
						
							String value115=text.getText();
					String sql22="update Kneipe_Teilnehmer set Vermerk=1 where Kneipe_Nr='"+value115+"' ";
					PreparedStatement pst3=con.prepareStatement(sql22);
					pst3.execute();
					JOptionPane.showMessageDialog(null,"Erfolgreich Genehmigt");
					
					
					ta1.append("\t\t Anfrage_Genehmigt: \n======================================\n"+
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
					
		}
			}
		});
		btnGenhemigen.setBounds(12, 71, 153, 46);
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
		btnAktualisieren.setBounds(12, 248, 153, 46);
		frame.getContentPane().add(btnAktualisieren);
		
		JPanel panel = new JPanel();
		panel.setBounds(257, 71, 494, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txt2 = new JTextField();
		txt2.setBounds(201, 128, 227, 40);
		panel.add(txt2);
		txt2.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setBounds(201, 75, 227, 40);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(201, 181, 227, 40);
		panel.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(201, 234, 227, 40);
		panel.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(201, 287, 227, 40);
		panel.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(201, 340, 227, 40);
		panel.add(txt6);
		
		JLabel lblNewLabel = new JLabel("Name_Kneipe:");
		lblNewLabel.setBounds(12, 75, 177, 40);
		panel.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(12, 128, 177, 40);
		panel.add(lblAdresse);
		
		JLabel lblBesitzer = new JLabel("Besitzer:");
		lblBesitzer.setBounds(12, 181, 177, 40);
		panel.add(lblBesitzer);
		
		JLabel lblTelephonnummer = new JLabel("Tel:");
		lblTelephonnummer.setBounds(12, 234, 177, 40);
		panel.add(lblTelephonnummer);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 275, 177, 40);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Vermerk:");
		lblNewLabel_1.setBounds(12, 328, 154, 40);
		panel.add(lblNewLabel_1);
		
		 C1 = new JComboBox();
		 C1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 	text.setText(C1.getSelectedItem().toString());	
		 		
try {	 /// Jetzt brauchen wir Info �ber das ausgewh�lte Regal um in den PDF auszudr�cken 
					
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
		 		
		 		
		 		
		 	}
		 });
		C1.setBounds(201, 38, 183, 22);
		panel.add(C1);
		
		JLabel lblNewLabel_2 = new JLabel("Anfrage:");
		lblNewLabel_2.setBounds(12, 22, 154, 40);
		panel.add(lblNewLabel_2);
		
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
		lb.setBounds(257, 33, 153, 16);
		frame.getContentPane().add(lb);
		
		 Zeit = new JLabel("New label");
		 Zeit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Zeit.setBounds(498, 32, 134, 16);
		frame.getContentPane().add(Zeit);
		
		 h = new JLabel("New label");
		 h.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		h.setBounds(644, 32, 106, 16);
		frame.getContentPane().add(h);
		
		text = new JTextField();
		text.setEnabled(false);
		text.setEditable(false);
		text.setText("0");
		text.setBounds(46, 30, 196, 22);
		frame.getContentPane().add(text);
		text.setColumns(10);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(763, 73, 316, 339);
		 frame.getContentPane().add(scrollPane_1);
		
		 ta1 = new JTextArea();
		 scrollPane_1.setViewportView(ta1);
		 
		 JButton btnPrint = new JButton("Print");
		 btnPrint.setBounds(12, 307, 153, 46);
		 frame.getContentPane().add(btnPrint);
	}
}
