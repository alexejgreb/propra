import java.awt.EventQueue;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Color;


public class Anfrage {
	private JTextArea ta;
	private static JLabel test;
	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void Screen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anfrage window = new Anfrage();
					window.frame.setVisible(true);
					test.setVisible(false);
					t1.setText(Kneipen_Besitzer.ff.getText());

					post.setVisible(false);
					name.setVisible(false);
					vorname.setVisible(false);
					stadt.setVisible(false);
					street.setVisible(false);
					DB_Anfragen.Select_Bar_Info(t1,name,vorname,street,post,stadt,t3,t5);

					t2.setText(street.getText()+"  "+post.getText()+"  "+stadt.getText());
					t4.setText(vorname.getText()+" "+name.getText());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con =null;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t5;
	private static  JTextField post;
	private static  JTextField name;
	private static JTextField vorname;
	private static  JTextField street;
	private static  JTextField stadt;
	private JScrollPane scrollPane;
	public Anfrage() {
		initialize();
		//con=Database.dbConnector();

		frame.setResizable(false);

		con = DataBaseConnector.dbConnectorMariaDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Kneipe_Nr:");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5.setBounds(25, 124, 170, 50);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(new Color(0, 0, 255));
		lblAdresse.setFont(new Font("Arial", Font.BOLD, 20));
		lblAdresse.setBounds(25, 171, 164, 50);
		frame.getContentPane().add(lblAdresse);

		JLabel lblTelephonnr = new JLabel("Telephon_Nr:");
		lblTelephonnr.setForeground(new Color(0, 0, 255));
		lblTelephonnr.setFont(new Font("Arial", Font.BOLD, 20));
		lblTelephonnr.setBounds(25, 227, 164, 50);
		frame.getContentPane().add(lblTelephonnr);

		JLabel lblBesitzer = new JLabel("Besitzer:");
		lblBesitzer.setForeground(new Color(0, 0, 255));
		lblBesitzer.setFont(new Font("Arial", Font.BOLD, 20));
		lblBesitzer.setBounds(25, 273, 164, 50);
		frame.getContentPane().add(lblBesitzer);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(25, 333, 121, 42);
		frame.getContentPane().add(lblEmail);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setEditable(false);
		t1.setText("310514");
		t1.setBounds(182, 136, 112, 30);
		frame.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setText("Adresse PLZ StraßeXXXXX");
		t2.setColumns(10);
		t2.setBounds(182, 183, 391, 30);
		frame.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setText("0176/111111111");
		t3.setColumns(10);
		t3.setBounds(182, 239, 391, 30);
		frame.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setEditable(false);
		t4.setText("BesitzerXXXXX");
		t4.setColumns(10);
		t4.setBounds(182, 285, 391, 30);
		frame.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setText("XXXX@XXXXX");
		t5.setColumns(10);
		t5.setBounds(182, 341, 391, 30);
		frame.getContentPane().add(t5);

		JButton btnNewButton = new JButton("Senden");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				try {
					String query="select * from Spiel_Licence where Vermerk ='"+t1.getText()+"'";

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


				int i11 =Integer.parseInt(test.getText());

				if(i11==1){
					JOptionPane.showMessageDialog(null,"Sie haben eine unbefristete Lizenc bekommen ");
				}else{







					try{

						//

						String sql = "INSERT INTO Kneipe_Teilnehmer (Kneipe_Nr,Adresse,Telefon_Nr,Besitzer,Email,Vermerk)VALUES (?,?,?,?,?,?)" ;
						PreparedStatement pst=con.prepareStatement(sql);
						pst.setString(1, t1.getText());
						pst.setString(2, t2.getText());
						pst.setString(3, t3.getText());
						pst.setString(4, t4.getText());
						pst.setString(5, t5.getText());


						pst.setString(6, "0");

						pst.execute();
						JOptionPane.showMessageDialog(null,"Versendet!!!");

						ta.append("\tAnfrage_Versendet: \n\n"+"Kneipe_Nr:\t"+t1.getText()+"\n======================================\n"+"Besitzer:\t"+t4.getText()+"\n\n"+"Telefon_Nr:\t"+t3.getText()+"\n\n"+
								" \t"+" \n======================================\n");
					} catch (Exception e1) {
						e1.printStackTrace();
					}







				}}
		});
		btnNewButton.setBounds(461, 384, 112, 36);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(461, 482, 112, 36);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnZurck = new JButton("Zurück");
		btnZurck.setForeground(new Color(255, 0, 0));
		btnZurck.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kneipen_Besitzer KBI= new Kneipen_Besitzer();
				try {
					KBI.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();

			}
		});
		btnZurck.setBounds(461, 433, 112, 36);
		frame.getContentPane().add(btnZurck);

		test = new JLabel("0");
		test.setBounds(82, 45, 56, 16);
		frame.getContentPane().add(test);

		post = new JTextField();
		post.setBounds(242, 384, 116, 22);
		frame.getContentPane().add(post);
		post.setColumns(10);

		name = new JTextField();
		name.setBounds(242, 423, 116, 22);
		frame.getContentPane().add(name);
		name.setColumns(10);

		vorname = new JTextField();
		vorname.setBounds(242, 458, 116, 22);
		frame.getContentPane().add(vorname);
		vorname.setColumns(10);

		street = new JTextField();
		street.setBounds(242, 490, 116, 22);
		frame.getContentPane().add(street);
		street.setColumns(10);

		stadt = new JTextField();
		stadt.setBounds(370, 142, 116, 22);
		frame.getContentPane().add(stadt);
		stadt.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(601, 107, 281, 405);
		frame.getContentPane().add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setEditable(false);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Desktop\\Projekt1\\download Krombacher Hintergrundbild 1024x768-1.jpg"));
		lblNewLabel.setBounds(0, 3, 894, 539);
		frame.getContentPane().add(lblNewLabel);
	}
}
