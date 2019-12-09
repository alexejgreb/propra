import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;


public class Quiz_Teilnehmer {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private static JTextField tname;
	private static JTextField tnummer;
	private JTextField txtDdmmjjjjj;
	private static JComboBox comboBox;
	private JTextField uhr;
	private JTextField textField_2;
	private JTextField min;
	private JTextField ar;
	private static JTextField t;
	private static JTextField tt;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void Screen4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz_Teilnehmer window = new Quiz_Teilnehmer();
					window.frame.setVisible(true);


					tname.setText(Quiz_Verwaltung.tname.getText());
					tnummer.setText(Quiz_Verwaltung.tnummer.getText());
					t.setVisible(false);
					tt.setVisible(false);
					DB_Anfragen.Select_SpielNR(Integer.parseInt(tnummer.getText()), comboBox);




				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quiz_Teilnehmer() {
		initialize();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Spielnummer:");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setForeground(Color.RED);
		label.setBounds(12, 13, 176, 16);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(148, 10, 170, 22);
		frame.getContentPane().add(textField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 578, 117);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuchen.setForeground(Color.ORANGE);
		btnSuchen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSuchen.setBounds(602, 87, 153, 50);
		frame.getContentPane().add(btnSuchen);

		JButton btnExit = new JButton("Schließen");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setForeground(Color.ORANGE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(602, 150, 153, 50);
		frame.getContentPane().add(btnExit);

		JLabel lblNewLabel = new JLabel("Datum:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 73, 53, 16);
		frame.getContentPane().add(lblNewLabel);

		JButton btnPrint = new JButton("Drucken");
		btnPrint.setForeground(Color.ORANGE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(602, 213, 153, 39);
		frame.getContentPane().add(btnPrint);

		JLabel label_1 = new JLabel("Kneipennummer:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(587, 14, 168, 16);
		frame.getContentPane().add(label_1);

		tname = new JTextField();
		tname.setText("#KneipeXXXY");
		tname.setEditable(false);
		tname.setColumns(10);
		tname.setBounds(561, 43, 93, 22);
		frame.getContentPane().add(tname);

		tnummer = new JTextField();
		tnummer.setText("310514");
		tnummer.setEditable(false);
		tnummer.setColumns(10);
		tnummer.setBounds(666, 43, 68, 22);
		frame.getContentPane().add(tnummer);

		txtDdmmjjjjj = new JTextField();
		txtDdmmjjjjj.setEditable(false);
		txtDdmmjjjjj.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDdmmjjjjj.setText("dd/mm/jjjjj");
		txtDdmmjjjjj.setBounds(77, 71, 106, 22);
		frame.getContentPane().add(txtDdmmjjjjj);
		txtDdmmjjjjj.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(comboBox.getSelectedItem().toString());

				DB_Anfragen.Select_Quiz_Teilnehmer_Info(textField, txtDdmmjjjjj, uhr, min, t, tt);

				DB_Anfragen.Quiz_Teilnehmer(table,textField);
				ar.setText(t.getText()+"/"+tt.getText());
			}
		});
		comboBox.setBounds(330, 11, 134, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblZeit = new JLabel("Zeit:");
		lblZeit.setForeground(Color.RED);
		lblZeit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZeit.setBounds(195, 73, 53, 16);
		frame.getContentPane().add(lblZeit);

		uhr = new JTextField();
		uhr.setFont(new Font("Tahoma", Font.BOLD, 13));
		uhr.setText("00");
		uhr.setEditable(false);
		uhr.setBounds(244, 71, 33, 22);
		frame.getContentPane().add(uhr);
		uhr.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setText(":");
		textField_2.setColumns(10);
		textField_2.setBounds(278, 71, 13, 22);
		frame.getContentPane().add(textField_2);

		min = new JTextField();
		min.setFont(new Font("Tahoma", Font.BOLD, 13));
		min.setText("00");
		min.setEditable(false);
		min.setColumns(10);
		min.setBounds(289, 71, 33, 22);
		frame.getContentPane().add(min);

		JLabel lblFragenrunden = new JLabel("Fragen/Runden:");
		lblFragenrunden.setForeground(Color.RED);
		lblFragenrunden.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFragenrunden.setBounds(12, 106, 134, 16);
		frame.getContentPane().add(lblFragenrunden);

		ar = new JTextField();
		ar.setText("10/1");
		ar.setFont(new Font("Tahoma", Font.BOLD, 13));
		ar.setEditable(false);
		ar.setBounds(148, 100, 58, 22);
		frame.getContentPane().add(ar);
		ar.setColumns(10);

		t = new JTextField();
		t.setBounds(244, 100, 116, 22);
		frame.getContentPane().add(t);
		t.setColumns(10);

		tt = new JTextField();
		tt.setBounds(372, 103, 116, 22);
		frame.getContentPane().add(tt);
		tt.setColumns(10);

		lblNewLabel_1 = new JLabel("");
		//TODO
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Haith\\Desktop\\Projekt1\\download Krombacher Hintergrundbild 1024x768-1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 773, 265);
		frame.getContentPane().add(lblNewLabel_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
