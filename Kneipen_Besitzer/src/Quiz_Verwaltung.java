
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;

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

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;




public class Quiz_Verwaltung {



	public  static JComboBox cb2,cb1;

	private JFrame frame;
	private static JTable table;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private static JComboBox comboBox;
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


					tname.setText(Kneipen_Besitzer.txtkneipexxxy.getText());
					tnummer.setText(Kneipen_Besitzer.ff.getText());

					try{


						String query2="select Spiel_Nummer from Spiel_Gnehmigt where Status=1 and Bar_Nr='"+tnummer.getText()+"' ";
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
						String query="select Spiel_Nummer,Datum,Lizenc,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel,Anzahl_Runden,Anzahl_Fragen from (Spiel_Gnehmigt) where Bar_Nr='"+tnummer.getText()+"'";
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
	public static JTextField tnummer;
	public static JTextField tname;
	public Quiz_Verwaltung() {
		initialize();
		frame.setResizable(false);
		//con=Database.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {



		frame = new JFrame();
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnInsert = new JButton("Quiz bearbeiten");
		btnInsert.setForeground(Color.RED);
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Quiz_Fragen_Bearbeiten QB= new Quiz_Fragen_Bearbeiten();
				try {
					QB.Screen3();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {

					e.printStackTrace();
				}



			}
		});
		btnInsert.setBounds(20, 41, 175, 45);
		frame.getContentPane().add(btnInsert);

		JButton btnQuizteilnehmer = new JButton("Teilnehmer");
		btnQuizteilnehmer.setForeground(Color.RED);
		btnQuizteilnehmer.setFont(new Font("Tahoma", Font.BOLD, 16));
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

		JButton btnWinner = new JButton("Gewinner prüfen");
		btnWinner.setForeground(Color.RED);
		btnWinner.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Winner QB= new Winner();
				try {
					QB.main(null);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}


			}
		});
		btnWinner.setBounds(20, 157, 175, 45);
		frame.getContentPane().add(btnWinner);

		JButton btnQuizterminer = new JButton("Spiel anmelden");
		btnQuizterminer.setForeground(Color.RED);
		btnQuizterminer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuizterminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				Quiz_Terminer QT= new Quiz_Terminer();
				try {
					QT.main(null);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnQuizterminer.setBounds(20, 215, 175, 45);
		frame.getContentPane().add(btnQuizterminer);

		JButton button_4 = new JButton("Zurück");
		button_4.setForeground(Color.RED);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
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

		JButton btnLeeren = new JButton("Clear");
		btnLeeren.setForeground(Color.RED);
		btnLeeren.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLeeren.setBounds(20, 331, 175, 45);
		frame.getContentPane().add(btnLeeren);

		JButton btnExit = new JButton("Drucken");
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				try {
					ta.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}





			}
		});
		btnExit.setBounds(20, 389, 175, 45);
		frame.getContentPane().add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 447, 1701, 261);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.BOLD, 13));
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				//	cb2.removeAllItems();

				try{
					String query2="select FrageNr from (FragenPool , Quiz_Fragen) where Quiz_Fragen.Frage_Nr = FragenPool.FrageNr and Quiz_Fragen.Spiel_Nummer ='"+cb1.getSelectedItem().toString()+"' and Quiz_Fragen.Bar_Nr ='"+tnummer.getText()+"'";
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




				try{
					String query2="select Frage from (FragenPool , Quiz_Fragen) where Quiz_Fragen.Frage_Nr = FragenPool.FrageNr and Quiz_Fragen.Spiel_Nummer ='"+cb1.getSelectedItem().toString()+"' and Quiz_Fragen.Bar_Nr ='"+tnummer.getText()+"'";
					PreparedStatement pst1=con.prepareStatement(query2);

					ResultSet rs= pst1.executeQuery();

					while (rs.next()){
						String Frage = rs.getString("Frage");

						comboBox.addItem(Frage);

					}

					rs.close();

				}
				catch(Exception e2){
					e2.printStackTrace();

				}





			}
		});
		cb1.setBounds(334, 19, 85, 22);
		frame.getContentPane().add(cb1);

		JLabel lblSpielnr = new JLabel("SpielNr:");
		lblSpielnr.setForeground(Color.RED);
		lblSpielnr.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSpielnr.setBounds(237, 13, 85, 30);
		frame.getContentPane().add(lblSpielnr);

		JTextArea t1 = new JTextArea();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setForeground(new Color(0, 0, 0));
		t1.setBounds(316, 111, 820, 70);
		frame.getContentPane().add(t1);

		JLabel label_1 = new JLabel("Frage:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(237, 101, 64, 36);
		frame.getContentPane().add(label_1);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(316, 194, 820, 36);
		frame.getContentPane().add(t2);

		JLabel label_2 = new JLabel("Antwort:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(226, 192, 97, 36);
		frame.getContentPane().add(label_2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(316, 243, 820, 36);
		frame.getContentPane().add(t3);

		JLabel lblA = new JLabel("A:");
		lblA.setForeground(Color.RED);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA.setBounds(281, 241, 35, 36);
		frame.getContentPane().add(lblA);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(316, 292, 820, 36);
		frame.getContentPane().add(t4);

		JLabel lblB = new JLabel("B:");
		lblB.setForeground(Color.RED);
		lblB.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblB.setBounds(281, 290, 35, 36);
		frame.getContentPane().add(lblB);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setColumns(10);
		t5.setBounds(316, 335, 820, 36);
		frame.getContentPane().add(t5);

		JLabel lblC = new JLabel("C:");
		lblC.setForeground(Color.RED);
		lblC.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblC.setBounds(281, 333, 35, 36);
		frame.getContentPane().add(lblC);

		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setColumns(10);
		t6.setBounds(316, 384, 820, 36);
		frame.getContentPane().add(t6);

		JLabel lblD = new JLabel("D:");
		lblD.setForeground(Color.RED);
		lblD.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblD.setBounds(281, 379, 35, 43);
		frame.getContentPane().add(lblD);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1191, 88, 530, 318);
		frame.getContentPane().add(scrollPane_1);

		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);
		ta.setEditable(false);

		JButton button_7 = new JButton("Drucken");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ta.print();
				} catch (PrinterException e1) {

					e1.printStackTrace();
				}
			}
		});
		button_7.setForeground(Color.RED);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBounds(1624, 412, 97, 22);
		frame.getContentPane().add(button_7);

		JLabel lblFragenr = new JLabel("FrageNr:");
		lblFragenr.setForeground(Color.RED);
		lblFragenr.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFragenr.setBounds(237, 56, 85, 30);
		frame.getContentPane().add(lblFragenr);

		cb2 = new JComboBox();
		cb2.setFont(new Font("Tahoma", Font.BOLD, 13));
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				try {	 ///CODE Verbessern !!!!!

					String query="select Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl from (FragenPool , Quiz_Fragen) where Quiz_Fragen.Frage_Nr = FragenPool.FrageNr and Quiz_Fragen.Spiel_Nummer ='"+cb1.getSelectedItem().toString()+"' and Quiz_Fragen.Frage_Nr='"+cb2.getSelectedItem().toString()+"'and Quiz_Fragen.Bar_Nr='"+tnummer.getText()+"'";

					PreparedStatement pst1=con.prepareStatement(query);

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
		cb2.setBounds(334, 64, 85, 22);
		frame.getContentPane().add(cb2);

		JLabel label = new JLabel("Kneipennummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(1553, 13, 168, 16);
		frame.getContentPane().add(label);

		tnummer = new JTextField();
		tnummer.setFont(new Font("Tahoma", Font.BOLD, 13));
		tnummer.setText("310514");
		tnummer.setEditable(false);
		tnummer.setColumns(10);
		tnummer.setBounds(1638, 38, 68, 22);
		frame.getContentPane().add(tnummer);

		tname = new JTextField();
		tname.setFont(new Font("Tahoma", Font.BOLD, 13));
		tname.setText("#KneipeXXXY");
		tname.setEditable(false);
		tname.setColumns(10);
		tname.setBounds(1532, 38, 93, 22);
		frame.getContentPane().add(tname);

		JLabel lblFrage = new JLabel("Frage:");
		lblFrage.setForeground(Color.RED);
		lblFrage.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFrage.setBounds(431, 56, 64, 30);
		frame.getContentPane().add(lblFrage);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				try {	 ///CODE Verbessern !!!!!

					String query="select Frage,ErsteWahl,ZweiteWahl,DritteWahl,VierteWahl from FragenPool where Frage='"+comboBox.getSelectedItem().toString()+"'";

					PreparedStatement pst1=con.prepareStatement(query);

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
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(493, 64, 643, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Ressources/image.jpg"));
		lblNewLabel.setBounds(0, 0, 1745, 733);
		frame.getContentPane().add(lblNewLabel);




	}
}
