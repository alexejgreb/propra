package UILayer;

import DataLayer.DataBaseConnector;
import LogicLayer.Login;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class UIDefault extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldUserLogin;
	private JPasswordField passwordFieldUserPw;
	private String tempUserName;
	private String tempUserMail;
	private char[] tempUserPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
		DataBaseConnector.setServerPassword(args[2]);
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIDefault frame = new UIDefault();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public UIDefault() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//ImageIcon img = new ImageIcon("Ressources\\Imag\\index.png");

		//JLabel background = new JLabel(img);
		//background.setBounds(0,0,700,500);
		//contentPane.add(background);


		JButton buttonUserLogin = new JButton("Login");
		buttonUserLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonUserLogin.setForeground(new Color(255, 0, 0));
		buttonUserLogin.setBounds(5, 149, 89, 23);
		contentPane.add(buttonUserLogin);
		buttonUserLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				tempUserMail=textFieldUserLogin.getText();
				tempUserPW=passwordFieldUserPw.getPassword();
				String userPWString = String.valueOf(tempUserPW);

				if (Login.checkIfRegistered(tempUserMail, userPWString)){
					Login.saveGuestInfo(tempUserMail, userPWString);
					UIUserDefault.main(null);
					dispose();
				} else {
					JDialog JDialogWrongPW = new JDialog();
					String message = "\"Passwort oder Email falsch!\"\n";

					JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
					System.out.println("Logindaten falsch, Konto nicht gefunden!");

				}
			}
		});
		
		JButton buttonRegistration = new JButton("Anmelden");
		buttonRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonRegistration.setForeground(new Color(255, 0, 0));
		buttonRegistration.setBounds(735, 5, 150, 22);
		contentPane.add(buttonRegistration);
		buttonRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIRegistration.main(null);
				dispose();

			}
		});
		
		JButton buttonGuest = new JButton("Weiter als Gast");
		buttonGuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGuest.setForeground(new Color(255, 0, 0));
		buttonGuest.setBounds(735, 40, 150, 22);
		contentPane.add(buttonGuest);
		buttonGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIGuest.main(null);
				dispose();
			}
		});

		JLabel LabelHeader = new JLabel("Willkommen");
		LabelHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelHeader.setBounds(5, 5, 424, 14);
		contentPane.add(LabelHeader);
		
		JLabel LabelUserLogin = new JLabel("Login");
		LabelUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelUserLogin.setBounds(103, 30, 260, 20);
		contentPane.add(LabelUserLogin);

		textFieldUserLogin = new JTextField();
		textFieldUserLogin.setBounds(82, 61, 96, 20);
		contentPane.add(textFieldUserLogin);
		textFieldUserLogin.setColumns(10);
		
		passwordFieldUserPw = new JPasswordField();
		passwordFieldUserPw.setBounds(82, 92, 96, 20);
		contentPane.add(passwordFieldUserPw);
		
		JLabel LabelLoginMail = new JLabel("E-Mail");
		LabelLoginMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelLoginMail.setBounds(5, 64, 72, 14);
		contentPane.add(LabelLoginMail);
		
		JLabel LabelLoginPw = new JLabel("Passwort");
		LabelLoginPw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelLoginPw.setBounds(5, 95, 67, 14);
		contentPane.add(LabelLoginPw);
		
		JLabel LabelRegistration = new JLabel("Noch nicht angemeldet?");
		LabelRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelRegistration.setBounds(560, 5, 150, 20);
		contentPane.add(LabelRegistration);

		JLabel LabelGuest = new JLabel("Oder Spiel als Gast");
		LabelGuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelGuest.setBounds(560, 40, 150, 20);
		contentPane.add(LabelGuest);

		ImageIcon imageIcon = new ImageIcon("Ressources/Startbild.jpg");
		JLabel backgroundImage = new JLabel(imageIcon);
		backgroundImage.setBounds(0, 0, 900, 577);
		contentPane.add(backgroundImage);
	}
}

