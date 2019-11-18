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
		table.setBounds(20, 447, 1074, 167);
		frame.getContentPane().add(table);
		
		JComboBox cb1 = new JComboBox();
		cb1.setBounds(390, 46, 141, 22);
		frame.getContentPane().add(cb1);
		
		JLabel label = new JLabel("Frage_Nr:");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(243, 40, 106, 30);
		frame.getContentPane().add(label);
		
		JTextArea t1 = new JTextArea();
		t1.setBounds(306, 104, 347, 80);
		frame.getContentPane().add(t1);
		
		JLabel label_1 = new JLabel("Frage:");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(188, 95, 106, 36);
		frame.getContentPane().add(label_1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(306, 194, 344, 36);
		frame.getContentPane().add(t2);
		
		JLabel label_2 = new JLabel("Antwort:");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(177, 192, 117, 36);
		frame.getContentPane().add(label_2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(306, 243, 344, 36);
		frame.getContentPane().add(t3);
		
		JLabel label_3 = new JLabel("Möglichkeit1:");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(161, 241, 137, 36);
		frame.getContentPane().add(label_3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(306, 292, 344, 36);
		frame.getContentPane().add(t4);
		
		JLabel label_4 = new JLabel("Möglichkeit2:");
		label_4.setForeground(Color.ORANGE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(161, 290, 121, 36);
		frame.getContentPane().add(label_4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(306, 340, 344, 36);
		frame.getContentPane().add(t5);
		
		JLabel label_5 = new JLabel("Möglichkeit3:");
		label_5.setForeground(Color.ORANGE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_5.setBounds(161, 339, 121, 36);
		frame.getContentPane().add(label_5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(306, 393, 344, 36);
		frame.getContentPane().add(t6);
		
		JLabel label_6 = new JLabel("Möglichkeit4:");
		label_6.setForeground(Color.ORANGE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(173, 389, 121, 43);
		frame.getContentPane().add(label_6);
		
	ta = new JTextArea();
		ta.setBounds(703, 35, 379, 353);
		frame.getContentPane().add(ta);
		
		JButton button_7 = new JButton("Print");
		button_7.setBounds(985, 398, 97, 36);
		frame.getContentPane().add(button_7);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(20, 389, 118, 45);
		frame.getContentPane().add(btnExit);
	}
}
