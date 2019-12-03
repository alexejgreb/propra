import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataLayer.BarQuestionHandler;
import DataLayer.DataBaseConnector;
import UILayer.Fragen_Verwaltung2;
import net.proteanit.sql.DbUtils;


public class Kneipen_Besitzer {

	private JFrame frame;
	private static JTable table;
	private static JTextField ff;
	private static JTextField txtkneipexxxy;
	private static JScrollPane scrollPane;
	static Connection con =null;
	
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
					Kneipen_Besitzer window = new Kneipen_Besitzer();
					window.frame.setVisible(true);
					
					
					try {
						String query="select Spiel_Nummer,Datum,Lizenc,Status,Uhr_Spiel,Min_Spiel,Tag_Spiel,Monat_Spiel,Jahr_Spiel from (Spiel_Gnehmigt) where status =1";
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
	public Kneipen_Besitzer() {
		initialize();
		frame.setResizable(false);
		
		con= DataBaseConnector.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1270, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 490, 1251, 136);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Statistiken");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(33, 230, 194, 51);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAnfragesenden = new JButton("Anfrage_Senden");
		btnAnfragesenden.setForeground(new Color(255, 0, 0));
		btnAnfragesenden.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAnfragesenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Anfrage A= new Anfrage();
				try {
					A.Screen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				
				
				
				
				
			}
		});
		btnAnfragesenden.setBounds(33, 164, 194, 53);
		frame.getContentPane().add(btnAnfragesenden);
		
		JButton btnFragenverwalten = new JButton("Fragen_Verwalten");
		btnFragenverwalten.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFragenverwalten.setForeground(new Color(255, 0, 0));
		btnFragenverwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Fragen_Verwaltung2 FV= new Fragen_Verwaltung2();
				try {
					FV.Screen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				
				
			}
		});
		btnFragenverwalten.setBounds(33, 91, 194, 60);
		frame.getContentPane().add(btnFragenverwalten);
		
		JButton btnQuizstarten = new JButton("Quiz_Starten");
		btnQuizstarten.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuizstarten.setForeground(new Color(255, 0, 0));
		btnQuizstarten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Spiel_Starten ST= new Spiel_Starten();
				try {
					ST.Screen2();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnQuizstarten.setBounds(33, 27, 194, 51);
		frame.getContentPane().add(btnQuizstarten);
		
		JButton btnQuizverwaltung = new JButton("Quiz_Verwaltung");
		btnQuizverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Quiz_Verwaltung QV= new Quiz_Verwaltung();
				try {
					QV.Screen2();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnQuizverwaltung.setForeground(new Color(255, 0, 0));
		btnQuizverwaltung.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuizverwaltung.setBounds(33, 294, 194, 51);
		frame.getContentPane().add(btnQuizverwaltung);
		
		JButton btnbersicht = new JButton("EXIT");
		btnbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnbersicht.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnbersicht.setForeground(new Color(255, 0, 0));
		btnbersicht.setBounds(33, 422, 194, 55);
		frame.getContentPane().add(btnbersicht);
		
		JLabel lblKneipenummer = new JLabel("Kneipe_Nummer:");
		lblKneipenummer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblKneipenummer.setForeground(new Color(255, 0, 0));
		lblKneipenummer.setBounds(1084, 13, 168, 16);
		frame.getContentPane().add(lblKneipenummer);
		
		ff = new JTextField();
		ff.setEditable(false);
		ff.setText("310514");
		ff.setBounds(1184, 42, 68, 22);
		frame.getContentPane().add(ff);
		ff.setColumns(10);
		
		txtkneipexxxy = new JTextField();
		txtkneipexxxy.setEditable(false);
		txtkneipexxxy.setText("#KneipeXXXY");
		txtkneipexxxy.setBounds(1079, 42, 93, 22);
		frame.getContentPane().add(txtkneipexxxy);
		txtkneipexxxy.setColumns(10);
		
		JButton btnAnmeldung = new JButton("Anmeldung");
		btnAnmeldung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Quiz_Terminer QT= new Quiz_Terminer();
				try {
					QT.main(null);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAnmeldung.setForeground(Color.RED);
		btnAnmeldung.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAnmeldung.setBounds(33, 358, 194, 55);
		frame.getContentPane().add(btnAnmeldung);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\krombacher-spot-mood-flaschen (1).jpg"));
		lblNewLabel.setBounds(0, 0, 1263, 639);
		frame.getContentPane().add(lblNewLabel);
	}
}
