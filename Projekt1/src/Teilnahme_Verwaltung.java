import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;


public class Teilnahme_Verwaltung {

	private JFrame frame;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JComboBox nummer ;
	private static JLabel email,besitzer,tel,adresse;
	/**
	 * Launch the application.
	 */
	public static void Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teilnahme_Verwaltung window = new Teilnahme_Verwaltung();
					window.frame.setVisible(true);

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
					DB_Anfragen.Table_Bar(table);
					/*
					try{
						String query2="select DISTINCT Kneipe_Nr from Kneipe_Teilnehmer where Vermerk =1";
						PreparedStatement pst1=con.prepareStatement(query2);

						ResultSet rs= pst1.executeQuery();
						while (rs.next()){
							String Kneipe_Nr = rs.getString("Kneipe_Nr");
							nummer.addItem(Kneipe_Nr);

						}

						rs.close();

						}
					catch(Exception e2){
						e2.printStackTrace();

					}
					*/
					DB_Anfragen.Bar_Nr_1(nummer);








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
	private JLabel lblNewLabel;

	public Teilnahme_Verwaltung() {
		initialize();
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database1.dbConnector();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 132, 737, 108);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		nummer = new JComboBox();
		nummer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


		 		/*
				try {
					String query1="select Adresse, Telefon_Nr, Besitzer, Email from Kneipe_Teilnehmer where Kneipe_Nr='"+nummer.getSelectedItem().toString()+"'";
					PreparedStatement pst11=con.prepareStatement(query1);

					ResultSet rs1= pst11.executeQuery();
					while (rs1.next()){
						String Adresse = rs1.getString("Adresse");
						adresse.setText(Adresse);
						String Telefon_Nr = rs1.getString("Telefon_Nr");
						tel.setText(Telefon_Nr);
						String Besitzer = rs1.getString("Besitzer");
						besitzer.setText(Besitzer);
						String Email = rs1.getString("Email");
						email.setText(Email);

					}

					rs1.close();

					}
				catch(Exception e2){
					e2.printStackTrace();

				}
				*/
				DB_Anfragen.Select_Bar_1(adresse, besitzer, tel, email, nummer);


			}
		});
		nummer.setBounds(14, 43, 130, 22);
		frame.getContentPane().add(nummer);

		JLabel lblKneipenummer = new JLabel("Kneipe_Nummer:");
		lblKneipenummer.setForeground(Color.RED);
		lblKneipenummer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKneipenummer.setBounds(12, 14, 143, 16);
		frame.getContentPane().add(lblKneipenummer);

		adresse = new JLabel("Adresse_Von der Kneipe Straße und Hausnummer");
		adresse.setForeground(Color.RED);
		adresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		adresse.setBounds(178, 45, 376, 16);
		frame.getContentPane().add(adresse);

		tel = new JLabel("Tel_Nr_der_Kneipe");
		tel.setForeground(Color.RED);
		tel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tel.setBounds(178, 74, 228, 16);
		frame.getContentPane().add(tel);

		besitzer = new JLabel("Besitzer_der_Kneipe");
		besitzer.setForeground(Color.RED);
		besitzer.setFont(new Font("Tahoma", Font.BOLD, 15));
		besitzer.setBounds(178, 14, 228, 16);
		frame.getContentPane().add(besitzer);

		email = new JLabel("Email_@_der_Kneipen_Besitzer");
		email.setForeground(Color.RED);
		email.setFont(new Font("Tahoma", Font.BOLD, 15));
		email.setBounds(178, 103, 376, 16);
		frame.getContentPane().add(email);

		JButton btnLizencbeenden = new JButton("Lizenc_beenden");
		btnLizencbeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/// Update Spiel_Licence set Licence_Nr = 0 where Vermerk = Kneipe_Nr
				// Update Spiel_Licence set Vermerk = 0 where Licence_Nr =0
				// Update Kneiep_Teilnehmer  set Vermerk =1  where Kneipe_Nr = ****
				//



			}
		});
		btnLizencbeenden.setForeground(Color.ORANGE);
		btnLizencbeenden.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLizencbeenden.setBounds(563, 11, 186, 31);
		frame.getContentPane().add(btnLizencbeenden);

		JButton btnExit = new JButton("Print");
		btnExit.setForeground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(566, 55, 183, 31);
		frame.getContentPane().add(btnExit);

		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		button.setForeground(Color.ORANGE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(566, 95, 183, 31);
		frame.getContentPane().add(button);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\krombacher-spot-mood-flaschen (1).jpg"));
		lblNewLabel.setBounds(0, 0, 761, 253);
		frame.getContentPane().add(lblNewLabel);
	}
}
