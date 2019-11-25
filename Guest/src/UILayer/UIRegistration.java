package UILayer;

import LogicLayer.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblAnmelden = new JLabel("Anmelden");
		lblAnmelden.setBounds(0, 0, 0, 0);
		contentPane.add(lblAnmelden);
		
		JLabel LabelUserName = new JLabel("Benutzername");
		LabelUserName.setBounds(0, 0, 0, 0);
		contentPane.add(LabelUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(0, 0, 0, 0);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel LabelUserMail = new JLabel("E-Mail Adresse");
		LabelUserMail.setBounds(0, 0, 0, 0);
		contentPane.add(LabelUserMail);
		
		textFieldUserMail = new JTextField();
		textFieldUserMail.setBounds(0, 0, 0, 0);
		contentPane.add(textFieldUserMail);
		textFieldUserMail.setColumns(10);
		
		JLabel LabelUserPw = new JLabel("Passwort");
		LabelUserPw.setBounds(0, 0, 0, 0);
		contentPane.add(LabelUserPw);
		
		passwordFieldUserPw = new JPasswordField();
		passwordFieldUserPw.setBounds(0, 0, 0, 0);
		contentPane.add(passwordFieldUserPw);
		
		JLabel LabelUserPwRepeat = new JLabel("Passwort wiederholen");
		LabelUserPwRepeat.setBounds(0, 0, 0, 0);
		contentPane.add(LabelUserPwRepeat);
		
		passwordFieldUserPwRepeat = new JPasswordField();
		passwordFieldUserPwRepeat.setBounds(0, 0, 0, 0);
		contentPane.add(passwordFieldUserPwRepeat);
		
		JButton ButtonRegistration = new JButton("Anmelden");
		ButtonRegistration.setBounds(0, 0, 0, 0);
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
					System.out.println("Passwortfelder stimmen nicht überein!");
				}


			}
		});
	}

}
