package UILayer;

import DataLayer.DataBase;
import LogicLayer.Logic;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UIAddBar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPostCode;
	private JTextField textFieldCity;
	private JTextField textFieldStreet;
	private JTextField textFieldSurename;
	private JTextField textFieldFirstname;
	private JTextField textFieldBarName;
	private JTextField textFieldBarNumber;
	private JTextField textFieldBarEMail;
	private JTextField textFieldPassword;
	private JTextField textFieldPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIAddBar frame = new UIAddBar();
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
	public UIAddBar() {
		//Initialiesiere DataBase
		DataBase db = new DataBase();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		//Wichtig für das Layout also bitte nicht löschen!
		JLabel placeHolder = new JLabel("");
		contentPane.add(placeHolder);
		
		JLabel lblHeader = new JLabel("Bar hinzufügen");
		contentPane.add(lblHeader);
		
		JLabel lblBarNumber = new JLabel("Barnummer");
		contentPane.add(lblBarNumber);
		
		textFieldBarNumber = new JTextField();
		textFieldBarNumber.setEditable(false);
		//textFieldBarNumber.setText(""+db.getNewBarNumber());
		contentPane.add(textFieldBarNumber);
		textFieldBarNumber.setColumns(10);
		
		JLabel lblParName = new JLabel("Bar-Name");
		contentPane.add(lblParName);
		
		textFieldBarName = new JTextField();
		contentPane.add(textFieldBarName);
		textFieldBarName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("Vorname");
		contentPane.add(lblFirstName);
		
		textFieldFirstname = new JTextField();
		contentPane.add(textFieldFirstname);
		textFieldFirstname.setColumns(10);
		
		JLabel lblSurname = new JLabel("Nachname");
		contentPane.add(lblSurname);
		
		textFieldSurename = new JTextField();
		contentPane.add(textFieldSurename);
		textFieldSurename.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Telefonnummer");
		contentPane.add(lblPhoneNumber);
		
		textFieldPhoneNumber = new JTextField();
		contentPane.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblStreet = new JLabel("Straße und Hausnummer");
		contentPane.add(lblStreet);
		
		textFieldStreet = new JTextField();
		contentPane.add(textFieldStreet);
		textFieldStreet.setColumns(10);
		
		JLabel lblCity = new JLabel("Stadt");
		contentPane.add(lblCity);
		
		textFieldCity = new JTextField();
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblPostCode = new JLabel("Postleitzahl");
		contentPane.add(lblPostCode);
		
		textFieldPostCode = new JTextField();
		contentPane.add(textFieldPostCode);
		textFieldPostCode.setColumns(10);
		
		JLabel lblBarEMail = new JLabel("E-Mail Adresse");
		contentPane.add(lblBarEMail);
		
		textFieldBarEMail = new JTextField();
		contentPane.add(textFieldBarEMail);
		textFieldBarEMail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Passwort");
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnInsert = new JButton("Anlegen");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logic temp = new Logic();
				try {
					temp.addBar(textFieldBarNumber.getText(),textFieldBarName.getText(),textFieldFirstname.getText(),textFieldSurename.getText(),textFieldPhoneNumber.getText(),textFieldStreet.getText(),textFieldCity.getText(),textFieldPostCode.getText(),textFieldBarEMail.getText(),textFieldPassword.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnInsert);

		JButton btnBack = new JButton("Schließen");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIBarManager.main(null);
				dispose();
			}
		});
		contentPane.add(btnBack);
	}

}
