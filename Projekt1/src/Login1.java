import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;public class Login1 {

	private JFrame frame;
	private JTextField txtAdmin;
	private JPasswordField pwd1;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
		DataBaseConnector.setServerPassword(args[2]);

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 window = new Login1();
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
	public Login1() {
		initialize();
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Benutzername:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(605, 267, 186, 32);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Passwort:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(601, 335, 153, 32);
		frame.getContentPane().add(lblNewLabel_1);

		txtAdmin = new JTextField();
		txtAdmin.setEditable(false);
		txtAdmin.setText("Admin");
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAdmin.setBounds(803, 264, 296, 40);
		frame.getContentPane().add(txtAdmin);
		txtAdmin.setColumns(10);

		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pwd;

				pwd=Integer.valueOf(pwd1.getText());

				if(pwd==1212){
					Admin ad= new Admin();
					try {
						ad.NewScreen();
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e) {

						e.printStackTrace();
					}
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Ungültige Zugangsdaten!");
				}

			}
		});
		btnNewButton.setBounds(1012, 397, 87, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Schließen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(913, 397, 87, 40);
		frame.getContentPane().add(btnNewButton_1);

		pwd1 = new JPasswordField();
		pwd1.setToolTipText("");
		pwd1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pwd1.setBounds(805, 332, 294, 40);
		frame.getContentPane().add(pwd1);

		JLabel lblNewLabel_2 = new JLabel("");
		//TODO
		lblNewLabel_2.setIcon(new ImageIcon("Ressources/2015-10-26_Krombacher Marke des Jahres (1).jpg"));
		lblNewLabel_2.setBounds(0, 0, 1745, 733);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
