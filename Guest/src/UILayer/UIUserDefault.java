package UILayer;

import DataLayer.DataBaseConnector;
import javax.swing.*;
import LogicLayer.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UIUserDefault extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGameID;
	private int tempIdNumber;
	private String tempEmail;
	private String tempUserPW;

	/**
	 * Launch the application."jdbc:mysql://alexej.synology.me:5796/propra" "propra" "Kneipenquiz1920!"
	 */
	public static void main(String[] args) {
        	DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
 		DataBaseConnector.setServerPassword(args[2]);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIUserDefault frame = new UIUserDefault();
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
	public UIUserDefault() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel LabelHeader = new JLabel("Startseite");
		LabelHeader.setBounds(0, 0, 0, 0);
		contentPane.add(LabelHeader);
		
		JLabel LabelGameId = new JLabel("Spiel-ID");
		LabelGameId.setBounds(0, 0, 0, 0);
		contentPane.add(LabelGameId);
		
		textFieldGameID = new JTextField();
		textFieldGameID.setBounds(0, 0, 0, 0);
		contentPane.add(textFieldGameID);
		textFieldGameID.setColumns(10);
		
		JButton ButtonStartGame = new JButton("Weiter zum Spiel");
		ButtonStartGame.setBounds(0, 0, 0, 0);
		contentPane.add(ButtonStartGame);
		ButtonStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String id_num = textFieldGameID.getText();
				tempIdNumber = Integer.parseInt(id_num);
				tempEmail = Login.guest.getEmail();
				tempUserPW = Login.guest.getPassword();
				//tempEmail = Login.userEmail;
				//tempUserPW = Login.userPW;

				if(Login.checkIdNumber(tempIdNumber)){
					if(Login.checkIfIDNrValid(tempIdNumber)){
					    Login.saveGameAndIDNumber(tempIdNumber);
						Login.setValid0InKundeSpiel(tempIdNumber);
						Login.setGuestIDInKunde_Spiel(tempEmail, tempUserPW,tempIdNumber);
						UIGame.main(null);

						dispose();
					} else {

						JDialog JDialogWrongOldIDNumber = new JDialog();
						String message = "\"IdNummer wurde bereits verbraucht\"\n";
						System.out.println("IdNummer wurde bereits verbraucht");
					}
				} else {

					JDialog JDialogWrongIDNumber = new JDialog();
					String message = "\"Falsche IDNummer!\"\n";
					System.out.println("falsche IdNummer");
				}
			}
		});
	}

}
