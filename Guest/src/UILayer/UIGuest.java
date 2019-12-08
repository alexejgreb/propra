package UILayer;



import DataLayer.DataBaseConnector;
import LogicLayer.Guest;
import LogicLayer.Login;
import LogicLayer.Validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIGuest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGameID;
	String id_num =null;
	int tempIdNumber = -1;
	String tempEmail;
	String tempUserPW;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		DataBaseConnector.setServerAddress(args[0]);
//		DataBaseConnector.setServerUsername(args[1]);
//		DataBaseConnector.setServerPassword(args[2]);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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
		boolean isInt = Validator.stringToInt(id_num);
		if  (isInt==true){
			tempIdNumber = Integer.parseInt(id_num);
			if (Login.checkIdNumber(tempIdNumber)) {
				if (Login.checkIfIDNrValid(tempIdNumber)) {
					Login.saveGameAndIDNumber(tempIdNumber);
					Login.setValid0InKundeSpiel(tempIdNumber);
					UIGameWaitingroom.showWaitingroom(Login.guest.getGameNumber());
					dispose();
				} else {
					JDialog JDialogOLdIDNumber = new JDialog();
					String message = "\"ID-Nummer wurde bereits benutzt!\"\n";
					JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
					System.out.println("IdNummer wurde bereits verbraucht");
				}

			} else {

				JDialog JDialogIDNummerFormatError = new JDialog();
				String message = "\"ID-Nummer ungültig!\"\n";
				JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
				System.out.println("Id Nummer ungültig");

			}
		}
		else {
			JDialog JDialogWrongIDNumber = new JDialog();
			String message = "\"Geben Sie bitte etwas ein!\"\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
			System.out.println("Id Nummer ungültig");

		}
	}

}
