import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;


public class Fragen_Pool {

	private JFrame frame;
	public  static JTable table;
	private static JLabel lb1,lb2 ;
	private JTextField a,w1,w2,w3,w4;
	public static JComboBox CB1;
	private JTextArea ta ;
	private static JScrollPane scrollPane;
	private static JButton Btp_zurueck;
	private static JTextArea ff ;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void newScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {

					Fragen_Pool window = new Fragen_Pool();
					window.frame.setVisible(true);



					DB_Anfragen.Table_Question(table);
					CB1.removeAllItems();


					DB_Anfragen.Question_Nr(CB1);



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

	public Fragen_Pool() {
		initialize();
		//con=Database1.dbConnector();

		con = DataBaseConnector.dbConnectorMariaDB();

		lb1.setVisible(false);
		lb2.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton Btp_Hinzufügen = new JButton("Einfügen");
		Btp_Hinzufügen.setForeground(Color.RED);
		Btp_Hinzufügen.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_Hinzufügen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lb1.setVisible(false);
				lb2.setVisible(false);

				int z;


				DB_Anfragen.Max_Question_Nr(lb1);
				z= Integer.parseInt(lb1.getText())+1	; /////
				lb2.setText(String.valueOf(z));

				DB_Anfragen.Insert_Question(lb2,ff,w1,w2,w3,w4,a);
				ta.append("\t Frage-Save: \n\n"+"Frage_Nr:\t"+CB1.getSelectedItem().toString()+"\n======================================\n"+"Frage:\t"+ff.getText()+"\n\n"+"Antwort :\t"+a.getText()+"\n\n"+
						" \t"+" \n======================================\n");
				ff.setText("");
				w1.setText("");
				a.setText("");
				w2.setText("");
				w3.setText("");
				w4.setText("");

			}

			//

		});
		Btp_Hinzufügen.setBounds(28, 34, 118, 45);
		frame.getContentPane().add(Btp_Hinzufügen);

		JButton Btp_Delet = new JButton("Löschen");
		Btp_Delet.setForeground(Color.RED);
		Btp_Delet.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_Delet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb1.setVisible(false);
				lb2.setVisible(false);
				//con=Database1.dbConnector();
				int YesorNo = JOptionPane.showConfirmDialog(null, " Sind Sie sicher wollen sie dieses Frage mit dem FrageNr:  ,"+CB1.getSelectedItem().toString()+",   entfernen !!!!!","Frage Entfernen",JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){


					DB_Anfragen.Delete_Question(CB1);
					ta.append("\t Frage-Delete: \n\n"+"Frage_Nr:\t"+CB1.getSelectedItem().toString()+"\n======================================\n"+"Frage:\t"+ff.getText()+"\n\n"+"Antwort :\t"+a.getText()+"\n\n"+
							" \t"+" \n======================================\n");


					ff.setText("");
					a.setText("");
					w1.setText("");
					w2.setText("");
					w3.setText("");
					w4.setText("");


				}
				else{
					JOptionPane.showMessageDialog(null,"OK Sie haben nichts entfernt");
				}


			}
		});
		Btp_Delet.setBounds(28, 92, 118, 45);
		frame.getContentPane().add(Btp_Delet);

		JButton Btp_edit = new JButton("Anpassen");
		Btp_edit.setForeground(Color.RED);
		Btp_edit.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lb1.setVisible(false);
				lb2.setVisible(false);



				DB_Anfragen.Update_Question(ff, w1, w2, w3, w4, a, CB1);
				ta.append("\t Frage-Update: \n\n"+"Frage_Nr:\t"+CB1.getSelectedItem().toString()+"\n======================================\n"+"Frage:\t"+ff.getText()+"\n\n"+"Antwort :\t"+a.getText()+"\n\n"+
						" \t"+" \n======================================\n");
				ff.setText("");
				w1.setText("");
				a.setText("");
				w2.setText("");
				w3.setText("");
				w4.setText("");
			}





		});
		Btp_edit.setBounds(28, 150, 118, 45);
		frame.getContentPane().add(Btp_edit);

		JButton Btp_Exit = new JButton("Schließen");
		Btp_Exit.setForeground(Color.RED);
		Btp_Exit.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Btp_Exit.setBounds(28, 400, 118, 45);
		frame.getContentPane().add(Btp_Exit);

		Btp_zurueck = new JButton("Zurück");
		Btp_zurueck.setForeground(Color.RED);
		Btp_zurueck.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_zurueck.addActionListener(new ActionListener() {
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
		Btp_zurueck.setBounds(28, 266, 118, 45);
		frame.getContentPane().add(Btp_zurueck);

		JButton Btp_Aktualisieren = new JButton("Felder leeren");
		Btp_Aktualisieren.setForeground(Color.RED);
		Btp_Aktualisieren.setFont(new Font("Tahoma", Font.BOLD, 18));
		Btp_Aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb1.setVisible(false);
				lb2.setVisible(false);
				ff.setText("");
				w1.setText("");
				a.setText("");
				w2.setText("");
				w3.setText("");
				w4.setText("");
			}
		});
		Btp_Aktualisieren.setBounds(28, 324, 118, 45);
		frame.getContentPane().add(Btp_Aktualisieren);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 492, 1721, 216);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lb1 = new JLabel("0");
		lb1.setBounds(171, 185, 56, 16);
		frame.getContentPane().add(lb1);

		lb2 = new JLabel("0");
		lb2.setBounds(171, 164, 56, 16);
		frame.getContentPane().add(lb2);

		JButton btnNewButton_1 = new JButton("Drucken");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


			}
		});
		btnNewButton_1.setBounds(28, 203, 118, 45);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("Drucken");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1624, 432, 97, 30);
		frame.getContentPane().add(btnNewButton);

		a = new JTextField();
		a.setFont(new Font("Tahoma", Font.BOLD, 13));
		a.setBounds(320, 212, 820, 36);
		frame.getContentPane().add(a);
		a.setColumns(10);

		w1 = new JTextField();
		w1.setFont(new Font("Tahoma", Font.BOLD, 13));
		w1.setBounds(320, 270, 820, 36);
		frame.getContentPane().add(w1);
		w1.setColumns(10);

		w2 = new JTextField();
		w2.setFont(new Font("Tahoma", Font.BOLD, 13));
		w2.setBounds(320, 311, 820, 36);
		frame.getContentPane().add(w2);
		w2.setColumns(10);

		w3 = new JTextField();
		w3.setFont(new Font("Tahoma", Font.BOLD, 13));
		w3.setBounds(320, 360, 820, 36);
		frame.getContentPane().add(w3);
		w3.setColumns(10);

		w4 = new JTextField();
		w4.setFont(new Font("Tahoma", Font.BOLD, 13));
		w4.setBounds(320, 409, 820, 36);
		frame.getContentPane().add(w4);
		w4.setColumns(10);

		CB1 = new JComboBox();
		CB1.setFont(new Font("Tahoma", Font.BOLD, 13));
		CB1.setBounds(320, 66, 70, 22);
		frame.getContentPane().add(CB1);

		JLabel lblNewLabel_2 = new JLabel("Frage Nr:");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(182, 60, 85, 30);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblFrage = new JLabel("Frage:");
		lblFrage.setForeground(Color.RED);
		lblFrage.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFrage.setBounds(206, 121, 70, 36);
		frame.getContentPane().add(lblFrage);

		JLabel lblNewLabel = new JLabel("Antwort:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(191, 210, 97, 36);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("A:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(254, 268, 34, 36);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblMglichkeit = new JLabel("B:");
		lblMglichkeit.setForeground(Color.RED);
		lblMglichkeit.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMglichkeit.setBounds(254, 309, 34, 36);
		frame.getContentPane().add(lblMglichkeit);

		JLabel lblMglichkeit_1 = new JLabel("C:");
		lblMglichkeit_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMglichkeit_1.setForeground(Color.RED);
		lblMglichkeit_1.setBounds(254, 358, 34, 36);
		frame.getContentPane().add(lblMglichkeit_1);

		JLabel lblMglichkeit_2 = new JLabel("D:");
		lblMglichkeit_2.setForeground(Color.RED);
		lblMglichkeit_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMglichkeit_2.setBounds(254, 404, 34, 43);
		frame.getContentPane().add(lblMglichkeit_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1193, 66, 528, 353);
		frame.getContentPane().add(scrollPane_1);

		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);

		ff = new JTextArea();
		ff.setFont(new Font("Tahoma", Font.BOLD, 13));
		ff.setBounds(320, 131, 820, 68);
		frame.getContentPane().add(ff);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(402, 66, 738, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("");
		//TODO
		lblNewLabel_3.setIcon(new ImageIcon("Ressources/image_content_828136805_20180122145147.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1733, 721);
		frame.getContentPane().add(lblNewLabel_3);
		CB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				DB_Anfragen.Select_Question(ff, a, w1, w2, w3, w4, CB1);
			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ta.print();
				} catch (PrinterException e) {

					e.printStackTrace();
				}

			}
		});
	}
}
