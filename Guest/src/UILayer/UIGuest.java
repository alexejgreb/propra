package UILayer;



import DataLayer.DataBaseConnector;
import LogicLayer.Guest;
import LogicLayer.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIGuest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGameID;
	String id_num;
	int tempIdNumber;
	String tempEmail;
	String tempUserPW;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
		DataBaseConnector.setServerPassword(args[2]);
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
		ButtonLogin.addActionListener(this::doStuff);

	}
	private void doStuff(ActionEvent actionEvent) {

		String id_num = textFieldGameID.getText();
		tempIdNumber = Integer.parseInt(id_num);

		if(Login.checkIdNumber(tempIdNumber)){

				//TODO Fenster für Spiel öffnen
			dispose();
		} else {
				//TODO TEXTBOX: Id_Nummer ungültig
		}

	}

}
