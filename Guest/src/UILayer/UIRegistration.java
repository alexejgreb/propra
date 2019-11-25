package UILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
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
	}

}
