import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class Auto_Fragen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void Fragen_Quiz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auto_Fragen window = new Auto_Fragen();
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
	public Auto_Fragen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Kneipe_Nummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(581, 0, 168, 29);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setText("#KneipeXXXY");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(591, 31, 93, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("310514");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(681, 31, 68, 22);
		frame.getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"POP_Quiz", "Local", "All"}));
		comboBox.setBounds(12, 77, 153, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"POP_Quiz", "Local", "All"}));
		comboBox_1.setBounds(196, 77, 153, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"POP_Quiz", "Local", "All"}));
		comboBox_2.setBounds(375, 77, 153, 22);
		frame.getContentPane().add(comboBox_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 42, 99, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(196, 42, 99, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(375, 42, 99, 22);
		frame.getContentPane().add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 143, 562, 97);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.ORANGE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(596, 193, 153, 36);
		frame.getContentPane().add(btnPrint);
		
		JButton btnHinzufgen = new JButton("Hinzufügen");
		btnHinzufgen.setForeground(Color.ORANGE);
		btnHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHinzufgen.setBounds(596, 67, 153, 50);
		frame.getContentPane().add(btnHinzufgen);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnExit.setForeground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(596, 130, 153, 50);
		frame.getContentPane().add(btnExit);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(97, 112, 68, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(281, 112, 68, 22);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(460, 112, 68, 22);
		frame.getContentPane().add(comboBox_5);
		
		JLabel lblSpielnummer = new JLabel("Spiel_Nummer:");
		lblSpielnummer.setForeground(Color.RED);
		lblSpielnummer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSpielnummer.setBounds(12, 10, 153, 22);
		frame.getContentPane().add(lblSpielnummer);
		
		JLabel lblFragenrunden = new JLabel("Fragen/Runden");
		lblFragenrunden.setForeground(Color.RED);
		lblFragenrunden.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFragenrunden.setBounds(321, 10, 145, 22);
		frame.getContentPane().add(lblFragenrunden);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(169, 11, 99, 22);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(470, 11, 99, 22);
		frame.getContentPane().add(textField_6);
	}
}
