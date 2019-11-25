package UILayer;



import LogicLayer.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIGuest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGameID;
	private int tempIdNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGuest frame = new UIGuest();
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
	public UIGuest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JLabel LabelHeader = new JLabel("Gastlogin");
		LabelHeader.setBounds(0, 0, 0, 0);
		contentPane.add(LabelHeader);
		
		JLabel lblNewLabel = new JLabel("Spiel-ID");
		lblNewLabel.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel);
		
		textFieldGameID = new JTextField();
		textFieldGameID.setBounds(0, 0, 0, 0);
		contentPane.add(textFieldGameID);
		textFieldGameID.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JButton ButtonLogin = new JButton("Weiter zum Spiel");
		ButtonLogin.setBounds(0, 0, 0, 0);
		contentPane.add(ButtonLogin);
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				tempIdNumber = Integer.parseInt(textFieldGameID.getText());
				String tempEmail = Login.guest.getEmail();
				String tempUserPW = Login.guest.getPassword();

				if (Login.checkIdNumber(tempIdNumber)){
					Login.setGuestIDInKunde_Spiel(tempEmail, tempUserPW, tempIdNumber);
					//TODO öffne Spiel-Fenster
					System.out.println("hat funktioniert");
					dispose();
				} else {
					System.out.println("Id-Nummer ist ungültig!");
				}

			}
		});
	}

}
