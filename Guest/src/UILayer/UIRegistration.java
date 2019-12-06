package UILayer;

import DataLayer.DataBaseConnector;
import LogicLayer.Login;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldUserMail;
	private JPasswordField passwordFieldUserPw;
	private JPasswordField passwordFieldUserPwRepeat;
	private String tempUserName;
	private String tempEmail;
	private char[] tempUserPW;
	private char[] tempUserPWrepeat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//	DataBaseConnector.setServerAddress(args[0]);
	//	DataBaseConnector.setServerUsername(args[1]);
	//	DataBaseConnector.setServerPassword(args[2]);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIRegistration frame = new UIRegistration();
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
	public UIRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAnmelden = new JLabel("Anmelden");
		lblAnmelden.setBounds(5, 5, 424, 14);
		contentPane.add(lblAnmelden);
		
		JLabel LabelUserName = new JLabel("Benutzername");
		LabelUserName.setBounds(5, 64, 92, 14);
		contentPane.add(LabelUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(100, 61, 126, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel LabelUserMail = new JLabel("E-Mail");
		LabelUserMail.setBounds(5, 95, 67, 14);
		contentPane.add(LabelUserMail);
		
		textFieldUserMail = new JTextField();
		textFieldUserMail.setBounds(100, 92, 126, 20);
		contentPane.add(textFieldUserMail);
		textFieldUserMail.setColumns(10);
		
		JLabel LabelUserPw = new JLabel("Passwort");
		LabelUserPw.setBounds(5, 126, 67, 14);
		contentPane.add(LabelUserPw);
		
		passwordFieldUserPw = new JPasswordField();
		passwordFieldUserPw.setBounds(100, 126, 126, 20);
		contentPane.add(passwordFieldUserPw);
		passwordFieldUserPw.setColumns(10);
		
		JLabel LabelUserPwRepeat = new JLabel("Passwort");
		LabelUserPwRepeat.setBounds(5, 157, 67, 14);
		contentPane.add(LabelUserPwRepeat);

		JLabel LabelRepeat = new JLabel("wiederholen");
		LabelRepeat.setBounds(5, 172, 97, 14);
		contentPane.add(LabelRepeat);
		
		passwordFieldUserPwRepeat = new JPasswordField();
		passwordFieldUserPwRepeat.setBounds(100, 160, 126, 20);
		contentPane.add(passwordFieldUserPwRepeat);
		passwordFieldUserPwRepeat.setColumns(10);
		
		JButton ButtonRegistration = new JButton("Anmelden");
		ButtonRegistration.setBounds(65, 210, 96, 25);
		contentPane.add(ButtonRegistration);
		ButtonRegistration.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tempUserName = textFieldUserName.getText();
				tempEmail = textFieldUserMail.getText();
				tempUserPW = passwordFieldUserPw.getPassword();
				tempUserPWrepeat = passwordFieldUserPwRepeat.getPassword();
				String userPWString = String.valueOf(tempUserPW);
				String userPWStringRepeat = String.valueOf(tempUserPWrepeat);

				if(userPWString.equals(userPWStringRepeat)){
					Login.registerGuest(tempUserName, tempEmail, userPWString);
					UIGuest.main(null);
					dispose();
				} else {
					JDialog JDialogWrongPW = new JDialog();
					String message = "\"Passwörter stimmen nicht überein!\"\n";
					JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
					System.out.println("Passwortfelder stimmen nicht überein!");

				}


			}
		});
	}

}
