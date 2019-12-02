
 import java.awt.EventQueue;

















import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import javax.swing.JTextField;

 import Old.Database;
 import net.proteanit.sql.DbUtils;
 
 
 

public class Quiz_Verwaltung {

	
	
	public  static JComboBox cb2,cb1;
	 
	 private JFrame frame;
	private static JTable table;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
public static  JTextArea ta;
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
					Quiz_Verwaltung window = new Quiz_Verwaltung();
					window.frame.setVisible(true);
					
					
					
					
                    try{
						
						
						String query2="select Spiel_Nummer from Spiel_Gnehmigt where Status=1 ";
						PreparedStatement pst1=con.prepareStatement(query2);
						
						ResultSet rs= pst1.executeQuery();
						//c1.removeAllItems();
						while (rs.next()){
							
							
							String Spiel_Nummer = rs.getString("Spiel_Nummer");
							cb1.addItem(Spiel_Nummer);
							
						}
						
						rs.close();
						
						}
					catch(Exception e2){
						e2.printStackTrace();
					
					}
					
					
					
					
					
					
					
					
					
					

					try {
						String query="select Spiel_Nummer,Datum,Lizenc,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel from (Spiel_Gnehmigt)";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
							

					} catch (Exception e1) {
						e1.printStackTrace();
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
	private JTextField textField;
	private JTextField textField_1;
	public Quiz_Verwaltung() {
		initialize();
		
		con= Database.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		 
		 frame = new JFrame();
		frame.setBounds(100, 100, 1124, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsert = new JButton("Bearbeiten");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Quiz_Fragen_Bearbeiten QB= new Quiz_Fragen_Bearbeiten();
				try {
					QB.Screen3();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnInsert.setBounds(20, 41, 175, 45);
		frame.getContentPane().add(btnInsert);
		
		JButton btnQuizteilnehmer = new JButton("Quiz_Teilnehmer");
		btnQuizteilnehmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Quiz_Teilnehmer QB= new Quiz_Teilnehmer();
				try {
					QB.Screen4();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnQuizteilnehmer.setBounds(20, 99, 175, 45);
		frame.getContentPane().add(btnQuizteilnehmer);
		
		JButton btnWinner = new JButton("Winner");
		btnWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Winner QB= new Winner();
				try {
					QB.main(null);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnWinner.setBounds(20, 157, 175, 45);
		frame.getContentPane().add(btnWinner);
		
		JButton btnQuizterminer = new JButton("Quiz_Terminer");
		btnQuizterminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Quiz_Terminer QT= new Quiz_Terminer();
				try {
					QT.main(null);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnQuizterminer.setBounds(20, 215, 175, 45);
		frame.getContentPane().add(btnQuizterminer);
		
		JButton button_4 = new JButton("Zurück");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Kneipen_Besitzer KB= new Kneipen_Besitzer();
				try {
					KB.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				
				
			}
		});
		button_4.setBounds(20, 273, 175, 45);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Aktualisieren");
		button_5.setBounds(20, 331, 175, 45);
		frame.getContentPane().add(button_5);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnExit.setBounds(20, 389, 175, 45);
		frame.getContentPane().add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 447, 1074, 167);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 cb1 = new JComboBox();
		 cb1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		cb2.removeAllItems();
		 		
		 		try{
					String query2="select FrageNr from (Fragen_Pool , Quiz_Fragen) where Quiz_Fragen.Frage_Nr = Fragen_Pool.FrageNr and Quiz_Fragen.Spiel_Nummer ='"+cb1.getSelectedItem().toString()+"'";
					PreparedStatement pst1=con.prepareStatement(query2);
					
					ResultSet rs= pst1.executeQuery();
					
					while (rs.next()){
						String FrageNr = rs.getString("FrageNr");
						
						cb2.addItem(FrageNr);
						
					}
					
					rs.close();
					
					}
				catch(Exception e2){
					e2.printStackTrace();
				
				}
		}
		 });
		cb1.setBounds(407, 64, 97, 22);
		frame.getContentPane().add(cb1);
		
		JLabel lblSpielnr = new JLabel("Spiel_Nr:");
		lblSpielnr.setForeground(Color.ORANGE);
		lblSpielnr.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSpielnr.setBounds(310, 56, 85, 30);
		frame.getContentPane().add(lblSpielnr);
		
		JTextArea t1 = new JTextArea();
		t1.setBounds(382, 110, 347, 80);
		frame.getContentPane().add(t1);
		
		JLabel label_1 = new JLabel("Frage:");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(306, 101, 64, 36);
		frame.getContentPane().add(label_1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(382, 194, 344, 36);
		frame.getContentPane().add(t2);
		
		JLabel label_2 = new JLabel("Antwort:");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(253, 192, 117, 36);
		frame.getContentPane().add(label_2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(382, 243, 344, 36);
		frame.getContentPane().add(t3);
		
		JLabel label_3 = new JLabel("Möglichkeit1:");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(233, 241, 137, 36);
		frame.getContentPane().add(label_3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(382, 292, 344, 36);
		frame.getContentPane().add(t4);
		
		JLabel label_4 = new JLabel("Möglichkeit2:");
		label_4.setForeground(Color.ORANGE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(243, 290, 121, 36);
		frame.getContentPane().add(label_4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(382, 340, 344, 36);
		frame.getContentPane().add(t5);
		
		JLabel label_5 = new JLabel("Möglichkeit3:");
		label_5.setForeground(Color.ORANGE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_5.setBounds(249, 340, 121, 36);
		frame.getContentPane().add(label_5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(382, 393, 344, 36);
		frame.getContentPane().add(t6);
		
		JLabel label_6 = new JLabel("Möglichkeit4:");
		label_6.setForeground(Color.ORANGE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(249, 388, 121, 43);
		frame.getContentPane().add(label_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(788, 87, 294, 318);
		frame.getContentPane().add(scrollPane_1);
		
		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);
		
		JButton button_7 = new JButton("Print");
		button_7.setBounds(985, 412, 97, 22);
		frame.getContentPane().add(button_7);
		
		JLabel lblFragenr = new JLabel("Frage_Nr:");
		lblFragenr.setForeground(Color.ORANGE);
		lblFragenr.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFragenr.setBounds(516, 56, 85, 30);
		frame.getContentPane().add(lblFragenr);
		
		 cb2 = new JComboBox();
		 cb2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		
try {	 ///CODE Verbessern !!!!!  
					
				    String query="select Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl from (Fragen_Pool , Quiz_Fragen) where Quiz_Fragen.Frage_Nr = Fragen_Pool.FrageNr and Quiz_Fragen.Spiel_Nummer =? and Quiz_Fragen.Frage_Nr=?";
				    
					PreparedStatement pst1=con.prepareStatement(query);
					pst1.setString(1, cb1.getSelectedItem().toString());
					pst1.setString(2, cb2.getSelectedItem().toString());
					ResultSet rs= pst1.executeQuery();
					
					 if ((rs.next()))
					 {
						
						t1.setText(rs.getString("Frage"));
						t2.setText(rs.getString("ErsteWahl"));
						t3.setText(rs.getString("ErsteWahl"));
					t4.setText(rs.getString("ZweiteWahl"));
					t5.setText(rs.getString("DritteWahl"));
					t6.setText(rs.getString("VierteWahl"));
					 }
					
						pst1.close();
						

					} catch (Exception e3) {
						e3.printStackTrace();
					}
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		cb2.setBounds(629, 64, 97, 22);
		frame.getContentPane().add(cb2);
		
		JLabel label = new JLabel("Kneipe_Nummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(914, 13, 168, 16);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setText("310514");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(1026, 38, 68, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("#KneipeXXXY");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(914, 38, 93, 22);
		frame.getContentPane().add(textField_1);
		 
		 
		 
		 
	}

}
