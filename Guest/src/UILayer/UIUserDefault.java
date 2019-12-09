package UILayer;

import DataLayer.DataBaseConnector;
import javax.swing.*;
import LogicLayer.Login;
import LogicLayer.Validator;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class UIUserDefault extends JFrame {

	private JPanel contentPane;
	private JPanel southPanel;
	private JTextField textFieldGameID;
	private int tempIdNumber;
	private String tempEmail;
	private String tempUserPW;

	public static void main(String[] args) {

		//DataBaseConnector.setServerAddress(args[0]);
		//DataBaseConnector.setServerUsername(args[1]);
 		//DataBaseConnector.setServerPassword(args[2]);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Container South
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(southPanel,BorderLayout.SOUTH);
		southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



		JLabel labelheader = new JLabel("Hole dir an der Theke einen Spiel-Code und gib sie ein.");
		labelheader.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelheader.setBounds(0, 0, 100, 0);
		contentPane.add(labelheader,BorderLayout.NORTH);

		
		JLabel labelGameId = new JLabel("Spiel-Code: ");
		labelGameId.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelGameId.setBounds(0, 0, 1000, 0);
		southPanel.add(labelGameId);
		
		textFieldGameID = new JTextField();
		textFieldGameID.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGameID.setBounds(0, 0, 0, 0);
		southPanel.add(textFieldGameID);
		textFieldGameID.setColumns(20);
		
		JButton buttonStartGame = new JButton("Weiter zum Spiel");
		buttonStartGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonStartGame.setForeground(new Color(255, 0, 0));
		buttonStartGame.setBounds(338, 248, 215, 22);
		southPanel.add(buttonStartGame);
		buttonStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String id_num = textFieldGameID.getText();
				//tempIdNumber = Integer.parseInt(id_num);
				tempEmail = Login.guest.getEmail();
				tempUserPW = Login.guest.getPassword();
				boolean isInt = Validator.stringToInt(id_num);
				//tempEmail = Login.userEmail;
				//tempUserPW = Login.userPW;
			if(isInt) {
				tempIdNumber = Integer.parseInt(id_num);
				if (Login.checkIdNumber(tempIdNumber)) {
					if (Login.checkIfIDNrValid(tempIdNumber)) {
						Login.saveGameAndIDNumber(tempIdNumber);
						Login.setValid0InKundeSpiel(tempIdNumber);
						Login.setGuestIDInKunde_Spiel(tempEmail, tempUserPW, tempIdNumber);
						// TODO später ersetzen durch : UIGameWaitingroom.showWaitingroom(Login.guest.getGameNumber());
						UIGameWaitingroom.showWaitingroom(907);

						dispose();
					} else {

						JDialog JDialogWrongOldIDNumber = new JDialog();
						String message = "\"Code wurde bereits benutzt!\"\n";
						JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
						System.out.println("IdNummer wurde bereits verbraucht");
					}
				} else {

					JDialog JDialogWrongIDNumber = new JDialog();
					String message = "\"Falscher Code!\"\n";
					JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
					System.out.println("falsche IdNummer");
				}
			}else {
				String message = "\"Geben Sie bitte etwas ein!\"\n";
				JOptionPane.showMessageDialog(new JFrame(), message, "Fehler",JOptionPane.ERROR_MESSAGE);
				System.out.println("Geben sie bitte die ID ein");
			}
			}
		});
	}

}
