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
	private JPanel southPanel;
	private JPanel northPanel;
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
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);


		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(northPanel,BorderLayout.NORTH);

		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(southPanel,BorderLayout.SOUTH);


		JLabel lblAnmelden = new JLabel("Anmelden");
		lblAnmelden.setFont(new Font("Tahoma",Font.BOLD,15));
		lblAnmelden.setBounds(5, 5, 424, 14);
		northPanel.add(lblAnmelden);
		
		JLabel LabelUserName = new JLabel("Benutzername");
		LabelUserName.setBounds(5, 64, 92, 14);
		contentPane.add(LabelUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(120, 61, 160, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel LabelUserMail = new JLabel("E-Mail");
		LabelUserMail.setBounds(5, 95, 67, 14);
		contentPane.add(LabelUserMail);
		
		textFieldUserMail = new JTextField();
		textFieldUserMail.setBounds(120, 92, 160, 20);
		contentPane.add(textFieldUserMail);
		textFieldUserMail.setColumns(10);
		
		JLabel LabelUserPw = new JLabel("Passwort");
		LabelUserPw.setBounds(5, 126, 67, 14);
		contentPane.add(LabelUserPw);
		
		passwordFieldUserPw = new JPasswordField();
		passwordFieldUserPw.setBounds(120, 126, 160, 20);
		contentPane.add(passwordFieldUserPw);
		passwordFieldUserPw.setColumns(10);
		
		JLabel LabelUserPwRepeat = new JLabel("Passwort");
		LabelUserPwRepeat.setBounds(5, 157, 67, 14);
		contentPane.add(LabelUserPwRepeat);

		passwordFieldUserPwRepeat = new JPasswordField();
		passwordFieldUserPwRepeat.setBounds(120, 160, 160, 20);
		passwordFieldUserPwRepeat.setColumns(10);
		contentPane.add(passwordFieldUserPwRepeat);

		JLabel LabelRepeat = new JLabel("wiederholen");
		LabelRepeat.setBounds(5, 170, 97, 14);
		contentPane.add(LabelRepeat);

		JButton buttonback = new JButton("Zurück");
		buttonback.setBounds(65, 210, 96, 25);
		buttonback.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonback.setForeground(new Color(255, 0, 0));
		southPanel.add(buttonback);
		buttonback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				UIDefault.main(null);
				dispose();
			}
		});

		JButton buttonRegistration = new JButton("Anmelden");
		buttonRegistration.setBounds(65, 210, 96, 25);
		buttonRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonRegistration.setForeground(new Color(255, 0, 0));
		southPanel.add(buttonRegistration);
		buttonRegistration.addActionListener(new ActionListener() {

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

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Ressources\\index.jpg"));
		background.setBounds(100, 100, 700, 500);
		contentPane.add(background);
	}

}
