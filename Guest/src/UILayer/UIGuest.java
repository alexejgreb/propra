package UILayer;



import LogicLayer.Login;
import LogicLayer.Validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UIGuest extends JFrame {

	private JPanel contentPane;
	private JPanel northPanel;
	private JPanel southPanel;
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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(northPanel, BorderLayout.NORTH);

		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(southPanel,BorderLayout.SOUTH);

		JLabel labelHeader = new JLabel("Gastlogin");
		labelHeader.setFont(new Font("Tahoma",Font.BOLD,18));
		labelHeader.setBounds(0, 0, 0, 0);
		northPanel.add(labelHeader);
		
		JLabel labelGameID = new JLabel("Spiel-ID: ");
		labelGameID.setFont(new Font("Tahoma",Font.BOLD,15));
		labelGameID.setBounds(0, 0, 0, 0);
		southPanel.add(labelGameID);
		
		textFieldGameID = new JTextField();
		labelGameID.setFont(new Font("Tahoma",Font.BOLD,13));
		textFieldGameID.setBounds(0, 0, 0, 0);
		southPanel.add(textFieldGameID);
		textFieldGameID.setColumns(20);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 0, 0);
		background.setIcon(new ImageIcon("Ressources\\Imag\\index.jpg"));
		contentPane.add(background);
		
		JButton buttonLogin = new JButton("Weiter zum Spiel");
		buttonLogin.setFont(new Font("Tahoma",Font.BOLD,15));
		buttonLogin.setForeground(new Color(255, 0, 0));
		buttonLogin.setBounds(0, 0, 0, 0);
		southPanel.add(buttonLogin);
		buttonLogin.addActionListener(this::doStuff);

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
