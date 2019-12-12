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

import javax.swing.JTextArea;

import net.proteanit.sql.DbUtils;


public class Kneipen_Besitzer {

	private JFrame frame;
	private static JTable table;
	public static JTextField ff;
	public static JTextField txtkneipexxxy;
	private static JScrollPane scrollPane;
	static Connection con =null;
	private static JTextArea info;
	private static JTextField neu;
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

					//ff.setText(t);
					neu.setVisible(false);
					ff.setText(Bar_Owner.bar.getText());

					txtkneipexxxy.setText(Bar_Owner.pub.getText());


					try {
						String query="select Spiel_Nummer AS Spielnummer,Datum AS Datum,Lizenc AS Linzenz,Status AS Status,Uhr_Spiel AS Stunde,Min_Spiel AS Minute,Tag_Spiel AS Tag,Monat_Spiel AS Monat,Jahr_Spiel AS Jahr,Anzahl_Runden AS Runden,Anzahl_Fragen AS Fragen from (Spiel_Gnehmigt) where status =1 and Bar_Nr='"+ff.getText()+"'";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));


					} catch (Exception e1) {
						e1.printStackTrace();
					}




				} catch (Exception e) {
					e.printStackTrace();
				}


				DB_Anfragen.Neu_Anmeldung(ff.getText(), neu);

				int i = Integer.parseInt(neu.getText());
				if(i==1){
					info.setVisible(true);
				}else{
					info.setVisible(false);
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
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 490, 1733, 230);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Statistiken");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(33, 294, 194, 51);
		frame.getContentPane().add(btnNewButton);

		JButton btnAnfragesenden = new JButton("Anfrage senden");
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

					e1.printStackTrace();
				}

			}
		});
		btnAnfragesenden.setBounds(33, 358, 194, 53);
		frame.getContentPane().add(btnAnfragesenden);

		JButton btnFragenverwalten = new JButton("Fragen verwalten");
		btnFragenverwalten.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFragenverwalten.setForeground(new Color(255, 0, 0));
		btnFragenverwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				info.setVisible(false);
				Fragen_Verwaltung FV= new Fragen_Verwaltung();
				try {
					FV.Screen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}
				frame.dispose();


			}
		});
		btnFragenverwalten.setBounds(33, 164, 194, 60);
		frame.getContentPane().add(btnFragenverwalten);

		JButton btnQuizstarten = new JButton("Quiz starten");
		btnQuizstarten.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuizstarten.setForeground(new Color(255, 0, 0));
		btnQuizstarten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				info.setVisible(false);
				Spiel_Starten ST= new Spiel_Starten();
				try {
					ST.Screen2();

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}

				frame.dispose();
			}
		});
		btnQuizstarten.setBounds(33, 27, 194, 51);
		frame.getContentPane().add(btnQuizstarten);

		JButton btnQuizverwaltung = new JButton("Quiz verwalten");
		btnQuizverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				info.setVisible(false);
				Quiz_Verwaltung QV= new Quiz_Verwaltung();
				try {
					QV.Screen2();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnQuizverwaltung.setForeground(new Color(255, 0, 0));
		btnQuizverwaltung.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuizverwaltung.setBounds(33, 91, 194, 51);
		frame.getContentPane().add(btnQuizverwaltung);

		JButton btnbersicht = new JButton("Logout");
		btnbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bar_Owner BO= new Bar_Owner();

				BO.main(DataBaseConnector.getArgs());


				frame.dispose();
			}
		});
		btnbersicht.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnbersicht.setForeground(new Color(255, 0, 0));
		btnbersicht.setBounds(33, 422, 194, 55);
		frame.getContentPane().add(btnbersicht);

		JLabel lblKneipenummer = new JLabel("Kneipennummer:");
		lblKneipenummer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblKneipenummer.setForeground(new Color(255, 0, 0));
		lblKneipenummer.setBounds(1560, 13, 168, 16);
		frame.getContentPane().add(lblKneipenummer);

		ff = new JTextField();
		ff.setEditable(false);
		ff.setText("310514");
		ff.setBounds(1665, 42, 68, 22);
		frame.getContentPane().add(ff);
		ff.setColumns(10);

		txtkneipexxxy = new JTextField();
		txtkneipexxxy.setEditable(false);
		txtkneipexxxy.setText("#KneipeXXXY");
		txtkneipexxxy.setBounds(1560, 42, 93, 22);
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

					e.printStackTrace();
				}

			}
		});
		btnAnmeldung.setForeground(Color.RED);
		btnAnmeldung.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAnmeldung.setBounds(33, 230, 194, 55);
		frame.getContentPane().add(btnAnmeldung);

		info = new JTextArea();
		info.setBackground(Color.LIGHT_GRAY);
		info.setFont(new Font("Monospaced", Font.BOLD, 18));

		info.setText("Hallo und Herzlich Willkommen!\r\n\r\n\r\nmit dieser Anwendung kannst du in deiner Kneipe Quizabende veranstalten.\r\nBevor du einen Quizabend durchführen kannst, senden Sie zunächst eine Anfrage (Anfrage senden).\r\nSobald deine Kneipe geprüft wurde, bekommst du eine E-Mail mit der Bestätigung.\r\n\r\nDiese Meldung wird Ihnen auch gezeigt, weil sie ihr Passwort nicht geändert haben.\r\nÄndern Sie bitte ihr Passwort.\r\n\r\n\r\n");
		info.setBounds(431, 132, 1117, 230);
		frame.getContentPane().add(info);

		neu = new JTextField();
		neu.setText("0");
		neu.setBounds(1526, 42, 22, 22);
		frame.getContentPane().add(neu);
		neu.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Ressources/image_content_828136805_20180122145147.jpg"));
		lblNewLabel.setBounds(0, 0, 1757, 733);
		frame.getContentPane().add(lblNewLabel);
	}
}
