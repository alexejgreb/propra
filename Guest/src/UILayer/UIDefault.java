package UILayer;

import LogicLayer.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class UIDefault extends JFrame {

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
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton ButtonUserLogin = new JButton("Login");
		ButtonUserLogin.setBounds(5, 149, 89, 23);
		contentPane.add(ButtonUserLogin);
		ButtonUserLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				
				tempUserMail=textFieldUserLogin.getText();
				tempUserPW=passwordFieldUserPw.getPassword();
				String userPWString = Arrays.toString(tempUserPW);

				if (Login.checkIfRegistered(tempUserMail, userPWString)){
					Login.saveGuestInfo(tempUserMail, userPWString);
					UIUserDefault.main(null);
					dispose();
				} else {
					JDialog JDialogWrongPW = new JDialog();
					JDialogWrongPW.setTitle("Passwort oder Mail Adresse falsch");
					JDialogWrongPW.add(new JLabel("Passwort oder Mail Adresse falsch"));
					JDialogWrongPW.add(new JButton("Okay"));
					/*JButton.addActionListener(new ActionListener){
						public void actionPerformed2(ActionEvent arg0) {
							dispose();
						}
					}*/
					JDialogWrongPW.setSize(400,200);
					JDialogWrongPW.setVisible(true);
					System.out.println("Logindaten falsch, Konto nicht gefunden!");

				}
				
			}
		});
		
		Button buttonRegistration = new Button("Anmelden");
		buttonRegistration.setBounds(5, 330, 70, 22);
		contentPane.add(buttonRegistration);
		buttonRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIRegistration.main(null);
				dispose();

			}
		});
		
		Button ButtonGuest = new Button("Weiter als Gast");
		ButtonGuest.setBounds(338, 330, 110, 22);
		contentPane.add(ButtonGuest);
		ButtonGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIGuest.main(null);
				dispose();
			}
		});
		
		
		
		

		
		JLabel LabelHeader = new JLabel("Willkommen");
		LabelHeader.setBounds(5, 5, 424, 14);
		contentPane.add(LabelHeader);
		
		JLabel LabelUserLogin = new JLabel("Login");
		LabelUserLogin.setBounds(103, 30, 26, 20);
		contentPane.add(LabelUserLogin);
		
		textFieldUserLogin = new JTextField();
		textFieldUserLogin.setBounds(82, 61, 96, 20);
		contentPane.add(textFieldUserLogin);
		textFieldUserLogin.setColumns(10);
		
		passwordFieldUserPw = new JPasswordField();
		passwordFieldUserPw.setBounds(82, 92, 96, 20);
		contentPane.add(passwordFieldUserPw);
		
		JLabel LabelLoginMail = new JLabel("E-Mail Adresse");
		LabelLoginMail.setBounds(5, 64, 72, 14);
		contentPane.add(LabelLoginMail);
		
		JLabel LabelLoginPw = new JLabel("Passwort");
		LabelLoginPw.setBounds(5, 95, 67, 14);
		contentPane.add(LabelLoginPw);
		
		JLabel LabelRegistration = new JLabel("Noch nicht angemeldet dann kannst du dich hier anmelden");
		LabelRegistration.setBounds(5, 248, 327, 20);
		contentPane.add(LabelRegistration);
		
		
		
		Label LabelGuest = new Label("Oder Spiel als Gast");
		LabelGuest.setBounds(338, 248, 215, 22);
		contentPane.add(LabelGuest);
	}
		
		public String getUserMail() {
			return tempUserMail;
		}
		
		public char[] getUserPW() {
			return tempUserPW;
		}
	
	
}

