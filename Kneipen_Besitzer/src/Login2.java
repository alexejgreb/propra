import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;


public class Login2 {

	private JFrame frame;
	private JTextField login;
	private JPasswordField pwd;

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
					Login2 window = new Login2();
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
	public Login2() {
		initialize();
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(43, 94, 153, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 33));
		lblNewLabel_1.setBounds(43, 156, 199, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		login = new JTextField();
		login.setFont(new Font("Tahoma", Font.PLAIN, 17));
		login.setText("Kneipe#310514");
		login.setEditable(false);
		login.setBounds(254, 94, 315, 37);
		frame.getContentPane().add(login);
		login.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setEchoChar('?');
		pwd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pwd.setBounds(254, 144, 315, 37);
		frame.getContentPane().add(pwd);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	int pwd1;
				
				pwd1=Integer.valueOf(pwd.getText());
					
					if(pwd1==1010){
						Kneipen_Besitzer KB= new Kneipen_Besitzer();
						try {
							KB.NewScreen();
						} catch (ClassNotFoundException
								| InstantiationException
								| IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Ungültige Zugangsdaten !!!!!");	
					}
				
				}
				
				
			
		});
		btnNewButton.setBounds(432, 194, 137, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(283, 194, 137, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Haith\\Desktop\\Projekt1\\krombacher-pils-prost.jpg"));
		lblNewLabel_2.setBounds(0, 0, 581, 295);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
