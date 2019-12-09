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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		Button buttonRegistration = new Button("Anmelden");
		buttonRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonRegistration.setForeground(new Color(255, 0, 0));
		buttonRegistration.setBounds(5, 330, 80, 22);
		contentPane.add(buttonRegistration);
		buttonRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIRegistration.main(null);
				dispose();

			}
		});
		
		Button buttonGuest = new Button("Weiter als Gast");
		buttonGuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGuest.setForeground(new Color(255, 0, 0));
		buttonGuest.setBounds(338, 330, 130, 22);
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
		LabelLoginMail.setBounds(5, 64, 72, 14);
		contentPane.add(LabelLoginMail);
		
		JLabel LabelLoginPw = new JLabel("Passwort");
		LabelLoginPw.setBounds(5, 95, 67, 14);
		contentPane.add(LabelLoginPw);
		
		JLabel LabelRegistration = new JLabel("Noch nicht angemeldet? Jetzt anmelden!");
		LabelRegistration.setBounds(5, 248, 327, 20);
		contentPane.add(LabelRegistration);
		
		

		Label LabelGuest = new Label("Oder Spiel als Gast");
		LabelGuest.setBounds(338, 248, 215, 22);
		contentPane.add(LabelGuest);
	}
}

