package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Winner {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winner window = new Winner();
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
	public Winner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Spiel_Nummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(12, 26, 129, 16);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setText("00000000");
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(150, 24, 195, 22);
		frame.getContentPane().add(textField);
		
		JLabel lblKundennr = new JLabel("KundenNr:");
		lblKundennr.setForeground(Color.RED);
		lblKundennr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKundennr.setBounds(12, 74, 129, 16);
		frame.getContentPane().add(lblKundennr);
		
		textField_1 = new JTextField();
		textField_1.setText("000000000");
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 72, 195, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("NameKunde");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 146, 101, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVornamekunde = new JLabel("VornameKunde");
		lblVornamekunde.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVornamekunde.setBounds(216, 146, 129, 16);
		frame.getContentPane().add(lblVornamekunde);
		
		JButton button = new JButton("Suchen");
		button.setForeground(Color.ORANGE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(598, 131, 153, 31);
		frame.getContentPane().add(button);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrint.setForeground(Color.ORANGE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(598, 177, 153, 31);
		frame.getContentPane().add(btnPrint);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnExit.setForeground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(598, 221, 153, 31);
		frame.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(402, 62, 183, 190);
		frame.getContentPane().add(textArea);
		
		JLabel label_1 = new JLabel("Kneipe_Nummer:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(583, 13, 168, 16);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("310514");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(693, 39, 68, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("#KneipeXXXY");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(593, 39, 93, 22);
		frame.getContentPane().add(textField_3);
		
		JLabel label_2 = new JLabel("VornameKunde");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(12, 196, 129, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("VornameKunde");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(201, 192, 129, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("VornameKunde");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(12, 230, 129, 16);
		frame.getContentPane().add(label_4);
	}

}
