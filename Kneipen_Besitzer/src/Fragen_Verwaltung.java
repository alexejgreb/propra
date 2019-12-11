import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;
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
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class Fragen_Verwaltung {

	private JFrame frame;
	private static JTable table;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	public JTextArea ta,t1;
	private static JTextField tname;
	private static JTextField tnummer;
	private static JLabel Zeit;
	private static JComboBox cbb,Tfrage;
	static Connection con =null;
	private static JScrollPane scrollPane_1;
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
					Fragen_Verwaltung window = new Fragen_Verwaltung();
					window.frame.setVisible(true);

					Zeit.setVisible(false);
					tname.setText(Kneipen_Besitzer.txtkneipexxxy.getText());
					tnummer.setText(Kneipen_Besitzer.ff.getText());

					DB_Anfragen.Select_FrageNr(Integer.parseInt(tnummer.getText()), cbb);
					DB_Anfragen.Select_Frage_FragenPool(Integer.parseInt(tnummer.getText()), Tfrage);
					DB_Anfragen.Table_Fragen(table, Integer.parseInt(tnummer.getText()));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */


	public void Clock(){
		Calendar cal = new GregorianCalendar();
		int Tag = cal.get(Calendar.DAY_OF_MONTH);
		int Jahre = cal.get(Calendar.YEAR);
		int Monat = cal.get(Calendar.MONTH);
		Zeit.setText(+Tag+"/"+Monat+"/"+Jahre);
	}



	public Fragen_Verwaltung() {
		initialize();
		frame.setResizable(false);
		Clock();
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

		JButton insert = new JButton("Einfügen");
		insert.setForeground(Color.RED);
		insert.setFont(new Font("Tahoma", Font.BOLD, 16));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				DB_Anfragen.Insert_Frage(t1.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t2.getText(), Integer.parseInt(tnummer.getText()), ta, Zeit);
			}
		});
		insert.setBounds(20, 41, 118, 45);
		frame.getContentPane().add(insert);

		JButton delete = new JButton("Löschen");
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Tahoma", Font.BOLD, 16));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int YesorNo = JOptionPane.showConfirmDialog(null, "Sind Sie sicher, dass Sie die FrageNr: '"+cbb.getSelectedItem().toString()+"' entfernen wollen?","Frage entfernen",JOptionPane.YES_NO_OPTION);
				if(YesorNo==0){
					DB_Anfragen.Delete_Frage(Integer.parseInt(cbb.getSelectedItem().toString()), Integer.parseInt(tnummer.getText()), ta, Zeit);
				}

			}
		});
		delete.setBounds(20, 157, 118, 45);
		frame.getContentPane().add(delete);

		JButton update = new JButton("Anpassen");
		update.setForeground(Color.RED);
		update.setFont(new Font("Tahoma", Font.BOLD, 16));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int YesorNo = JOptionPane.showConfirmDialog(null, "Sind sie sicher, dass Sie die FrageNr '"+cbb.getSelectedItem().toString()+"' ändern wollen?","Frage ändern",JOptionPane.YES_NO_OPTION);


				if(YesorNo==0){


					DB_Anfragen.Update_Question(t1, t3, t4, t5, t6, t2, cbb,Zeit,ta);
				}
			}
		});
		update.setBounds(20, 99, 118, 45);
		frame.getContentPane().add(update);

		JButton print = new JButton("Drucken");
		print.setForeground(Color.RED);
		print.setFont(new Font("Tahoma", Font.BOLD, 16));
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ta.print();
				} catch (PrinterException e1) {

					e1.printStackTrace();
				}

			}
		});
		print.setBounds(20, 273, 118, 45);
		frame.getContentPane().add(print);

		JButton zurueck = new JButton("Zurück");
		zurueck.setForeground(Color.RED);
		zurueck.setFont(new Font("Tahoma", Font.BOLD, 16));
		zurueck.addActionListener(new ActionListener() {
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
		zurueck.setBounds(20, 331, 118, 45);
		frame.getContentPane().add(zurueck);

		JButton leeren = new JButton("Clear");
		leeren.setForeground(Color.RED);
		leeren.setFont(new Font("Tahoma", Font.BOLD, 16));
		leeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
			}
		});
		leeren.setBounds(20, 215, 118, 45);
		frame.getContentPane().add(leeren);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 481, 1713, 239);
		frame.getContentPane().add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);

		JLabel label = new JLabel("FragenNr:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		label.setBounds(188, 46, 106, 30);
		frame.getContentPane().add(label);

		t1 = new JTextArea();
		t1.setFont(new Font("Monospaced", Font.BOLD, 13));
		t1.setBounds(306, 104, 757, 80);
		frame.getContentPane().add(t1);

		JLabel label_1 = new JLabel("Frage:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(188, 95, 106, 36);
		frame.getContentPane().add(label_1);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(306, 194, 757, 36);
		frame.getContentPane().add(t2);

		JLabel label_2 = new JLabel("Antwort:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(177, 192, 117, 36);
		frame.getContentPane().add(label_2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(306, 243, 757, 36);
		frame.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(306, 292, 757, 36);
		frame.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setColumns(10);
		t5.setBounds(306, 340, 757, 36);
		frame.getContentPane().add(t5);

		JLabel lblC = new JLabel("C:");
		lblC.setForeground(Color.RED);
		lblC.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblC.setBounds(277, 333, 25, 36);
		frame.getContentPane().add(lblC);

		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setColumns(10);
		t6.setBounds(306, 393, 757, 36);
		frame.getContentPane().add(t6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1171, 76, 562, 353);
		frame.getContentPane().add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setEditable(false);

		JButton button_7 = new JButton("Drucken");
		button_7.setForeground(Color.RED);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ta.print();
				} catch (PrinterException e1) {

					e1.printStackTrace();
				}
			}
		});
		button_7.setBounds(1636, 438, 97, 30);
		frame.getContentPane().add(button_7);

		JButton exit = new JButton("Schließen");
		exit.setForeground(Color.RED);
		exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kneipen_Besitzer KB= new Kneipen_Besitzer();
				try {
					KB.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {

					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		exit.setBounds(20, 389, 118, 45);
		//Button macht das gleiche wie zurück
		//frame.getContentPane().add(exit);

		Tfrage = new JComboBox();
		Tfrage.setFont(new Font("Tahoma", Font.BOLD, 13));
		Tfrage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				DB_Anfragen.Select_Frage1(Tfrage.getSelectedItem().toString(), t1, t2, t3, t4, t5, t6);
			}
		});
		Tfrage.setBounds(397, 52, 666, 22);
		frame.getContentPane().add(Tfrage);

		JLabel label_7 = new JLabel("Kneipennummer:");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_7.setBounds(1565, 13, 168, 16);
		frame.getContentPane().add(label_7);

		tname = new JTextField();
		tname.setText("#KneipeXXXY");
		tname.setEditable(false);
		tname.setColumns(10);
		tname.setBounds(1560, 41, 93, 22);
		frame.getContentPane().add(tname);

		tnummer = new JTextField();
		tnummer.setText("310514");
		tnummer.setEditable(false);
		tnummer.setColumns(10);
		tnummer.setBounds(1665, 41, 68, 22);
		frame.getContentPane().add(tnummer);

		JLabel lblD = new JLabel("D:");
		lblD.setForeground(Color.RED);
		lblD.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblD.setBounds(279, 391, 25, 36);
		frame.getContentPane().add(lblD);

		JLabel lblB = new JLabel("B:");
		lblB.setForeground(Color.RED);
		lblB.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblB.setBounds(277, 290, 25, 36);
		frame.getContentPane().add(lblB);

		JLabel lblA = new JLabel("A:");
		lblA.setForeground(Color.RED);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblA.setBounds(277, 241, 25, 36);
		frame.getContentPane().add(lblA);

		Zeit = new JLabel("New label");
		Zeit.setForeground(Color.BLACK);
		Zeit.setFont(new Font("Tahoma", Font.BOLD, 18));
		Zeit.setBounds(1366, 9, 187, 22);
		frame.getContentPane().add(Zeit);

		cbb = new JComboBox();
		cbb.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DB_Anfragen.Select_Frage(Integer.parseInt(cbb.getSelectedItem().toString()), t1, t2, t3, t4, t5, t6);
			}
		});
		cbb.setBounds(306, 52, 79, 22);
		frame.getContentPane().add(cbb);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("Ressources/image.jpg"));
		lblNewLabel.setBounds(0, 0, 1745, 733);
		frame.getContentPane().add(lblNewLabel);
	}
}
