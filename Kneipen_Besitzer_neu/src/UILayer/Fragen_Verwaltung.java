package UILayer;

import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Fragen_Verwaltung {

	private JFrame frame;
	private JTable table;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
public JTextArea ta;
private JTextField textField;
private JTextField textField_1;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fragen_Verwaltung() {
		initialize();
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1124, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(20, 41, 118, 45);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(20, 99, 118, 45);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Update");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(20, 157, 118, 45);
		frame.getContentPane().add(button_2);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrint.setBounds(20, 215, 118, 45);
		frame.getContentPane().add(btnPrint);
		
		JButton button_4 = new JButton("Zurück");
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
		button_4.setBounds(20, 273, 118, 45);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Aktualisieren");
		button_5.setBounds(20, 331, 118, 45);
		frame.getContentPane().add(button_5);
		
		table = new JTable();
		table.setBounds(20, 481, 1074, 133);
		frame.getContentPane().add(table);
		
		JComboBox cb1 = new JComboBox();
		cb1.setBounds(306, 52, 53, 22);
		frame.getContentPane().add(cb1);
		
		JLabel label = new JLabel("Frage_Nr:");
		label.setForeground(new Color(0, 100, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(188, 46, 106, 30);
		frame.getContentPane().add(label);
		
		JTextArea t1 = new JTextArea();
		t1.setBounds(306, 104, 437, 80);
		frame.getContentPane().add(t1);
		
		JLabel label_1 = new JLabel("Frage:");
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(188, 95, 106, 36);
		frame.getContentPane().add(label_1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(306, 194, 437, 36);
		frame.getContentPane().add(t2);
		
		JLabel label_2 = new JLabel("Antwort:");
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(177, 192, 117, 36);
		frame.getContentPane().add(label_2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(306, 243, 437, 36);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(306, 292, 437, 36);
		frame.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(306, 340, 437, 36);
		frame.getContentPane().add(t5);
		
		JLabel lblC = new JLabel("C:");
		lblC.setForeground(new Color(0, 100, 0));
		lblC.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblC.setBounds(277, 333, 25, 36);
		frame.getContentPane().add(lblC);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(306, 393, 437, 36);
		frame.getContentPane().add(t6);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(778, 72, 304, 353);
	frame.getContentPane().add(scrollPane);
		
	ta = new JTextArea();
	scrollPane.setViewportView(ta);
		
		JButton button_7 = new JButton("Print");
		button_7.setBounds(985, 438, 97, 30);
		frame.getContentPane().add(button_7);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(20, 389, 118, 45);
		frame.getContentPane().add(btnExit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(371, 52, 372, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel label_7 = new JLabel("Kneipe_Nummer:");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_7.setBounds(926, 13, 168, 16);
		frame.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setText("#KneipeXXXY");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(904, 41, 93, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("310514");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(1009, 41, 68, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblD = new JLabel("D:");
		lblD.setForeground(new Color(0, 100, 0));
		lblD.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblD.setBounds(279, 391, 25, 36);
		frame.getContentPane().add(lblD);
		
		JLabel lblB = new JLabel("B:");
		lblB.setForeground(new Color(0, 100, 0));
		lblB.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblB.setBounds(277, 290, 25, 36);
		frame.getContentPane().add(lblB);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(0, 100, 0));
		lblA.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA.setBounds(277, 241, 25, 36);
		frame.getContentPane().add(lblA);
	}
}
