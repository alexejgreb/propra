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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtDdmmjjjjj;

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

		JLabel label = new JLabel("Spiel_Nummer:");
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

		JButton btnExit = new JButton("EXIT");
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

		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.ORANGE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(602, 213, 153, 39);
		frame.getContentPane().add(btnPrint);

		JLabel label_1 = new JLabel("Kneipe_Nummer:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(587, 14, 168, 16);
		frame.getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setText("#KneipeXXXY");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(561, 43, 93, 22);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("310514");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(666, 43, 68, 22);
		frame.getContentPane().add(textField_2);

		txtDdmmjjjjj = new JTextField();
		txtDdmmjjjjj.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDdmmjjjjj.setText("dd/mm/jjjjj");
		txtDdmmjjjjj.setBounds(77, 71, 176, 22);
		frame.getContentPane().add(txtDdmmjjjjj);
		txtDdmmjjjjj.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(330, 11, 153, 22);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(270, 71, 153, 22);
		frame.getContentPane().add(comboBox_1);
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
