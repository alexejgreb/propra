package UILayer;

import DataLayer.DataBase;
import LogicLayer.Logic;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.xml.crypto.Data;

public class UIEditAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdminId;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JLabel lblHeader2;
	private JLabel lblHeader1;
	private JLabel lblUserIdSearch;
	private Component verticalStrut;
	private JTextField textFieldUserIdSearch;
	private JLabel lblSuchen;
	private JButton btnSearch;
	private JButton btnAdd;
	private JLabel lblUserIdEdit;
	private JTextField textFieldUserIdEdit;
	private JLabel lblUserNameEdit;
	private JLabel lblUserPasswordEdit;
	private JTextField textFieldUserNameEdit;
	private JTextField textFieldPasswordEdit;
	private JButton btnSafe;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIEditAdmin frame = new UIEditAdmin();
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
	public UIEditAdmin() {
		DataBase db= new DataBase();
		Logic logic= new Logic();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblHeader1 = new JLabel("Neuer Admin");
		GridBagConstraints gbc_lblHeader1 = new GridBagConstraints();
		gbc_lblHeader1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeader1.gridx = 1;
		gbc_lblHeader1.gridy = 0;
		contentPane.add(lblHeader1, gbc_lblHeader1);
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		contentPane.add(verticalStrut, gbc_verticalStrut);
		
		lblHeader2 = new JLabel("Admin bearbeiten");
		GridBagConstraints gbc_lblHeader2 = new GridBagConstraints();
		gbc_lblHeader2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeader2.gridx = 4;
		gbc_lblHeader2.gridy = 0;
		contentPane.add(lblHeader2, gbc_lblHeader2);
		
		lblSuchen = new JLabel("Zum suchen bitte die ID-Nummer eingeben");
		GridBagConstraints gbc_lblSuchen = new GridBagConstraints();
		gbc_lblSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuchen.gridx = 4;
		gbc_lblSuchen.gridy = 1;
		contentPane.add(lblSuchen, gbc_lblSuchen);
		
		JLabel lblUserId = new JLabel("ID-Nummer");
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.anchor = GridBagConstraints.EAST;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 0;
		gbc_lblUserId.gridy = 2;
		contentPane.add(lblUserId, gbc_lblUserId);
		
		textFieldAdminId = new JTextField();
		GridBagConstraints gbc_textFieldAdminId = new GridBagConstraints();
		textFieldAdminId.setEditable(false);
		textFieldAdminId.setText(""+db.getNewAdminID());
		gbc_textFieldAdminId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdminId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdminId.gridx = 1;
		gbc_textFieldAdminId.gridy = 2;
		contentPane.add(textFieldAdminId, gbc_textFieldAdminId);
		textFieldAdminId.setColumns(10);
		
		lblUserIdSearch = new JLabel("ID-Nummer");
		GridBagConstraints gbc_lblUserIdSearch = new GridBagConstraints();
		gbc_lblUserIdSearch.anchor = GridBagConstraints.EAST;
		gbc_lblUserIdSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserIdSearch.gridx = 3;
		gbc_lblUserIdSearch.gridy = 2;
		contentPane.add(lblUserIdSearch, gbc_lblUserIdSearch);
		
		textFieldUserIdSearch = new JTextField();
		GridBagConstraints gbc_textFieldUserIdSearch = new GridBagConstraints();
		gbc_textFieldUserIdSearch.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserIdSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserIdSearch.gridx = 4;
		gbc_textFieldUserIdSearch.gridy = 2;
		contentPane.add(textFieldUserIdSearch, gbc_textFieldUserIdSearch);
		textFieldUserIdSearch.setColumns(10);
		
		JLabel lblUserName = new JLabel("Name");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 3;
		contentPane.add(lblUserName, gbc_lblUserName);
		
		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 3;
		contentPane.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setColumns(10);
		
		btnSearch = new JButton("Suchen");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 3;
		contentPane.add(btnSearch, gbc_btnSearch);
		
		JLabel lblAdminPassword = new JLabel("Passwort");
		GridBagConstraints gbc_lblAdminPassword = new GridBagConstraints();
		gbc_lblAdminPassword.anchor = GridBagConstraints.EAST;
		gbc_lblAdminPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdminPassword.gridx = 0;
		gbc_lblAdminPassword.gridy = 4;
		contentPane.add(lblAdminPassword, gbc_lblAdminPassword);
		
		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 4;
		contentPane.add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnAdd = new JButton("erstellen");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 6;
		contentPane.add(btnAdd, gbc_btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean tempStatus=false;
				tempStatus=logic.addNewAdmin(textFieldUserName.getText(),textFieldPassword.getText());
				//reset
				if (tempStatus==true) {
					dispose();
					UIEditAdmin.main(null);
				}
			}
		});
		
		lblUserIdEdit = new JLabel("ID-Nummer");
		GridBagConstraints gbc_lblUserIdEdit = new GridBagConstraints();
		gbc_lblUserIdEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserIdEdit.gridx = 3;
		gbc_lblUserIdEdit.gridy = 6;
		contentPane.add(lblUserIdEdit, gbc_lblUserIdEdit);
		
		textFieldUserIdEdit = new JTextField();
		textFieldUserIdEdit.setEditable(false);
		textFieldUserIdEdit.setText("");
		GridBagConstraints gbc_textFieldUserIdEdit = new GridBagConstraints();
		gbc_textFieldUserIdEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserIdEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserIdEdit.gridx = 4;
		gbc_textFieldUserIdEdit.gridy = 6;
		contentPane.add(textFieldUserIdEdit, gbc_textFieldUserIdEdit);
		textFieldUserIdEdit.setColumns(10);
		
		lblUserNameEdit = new JLabel("Name");
		GridBagConstraints gbc_lblUserNameEdit = new GridBagConstraints();
		gbc_lblUserNameEdit.anchor = GridBagConstraints.EAST;
		gbc_lblUserNameEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserNameEdit.gridx = 3;
		gbc_lblUserNameEdit.gridy = 7;
		contentPane.add(lblUserNameEdit, gbc_lblUserNameEdit);
		
		textFieldUserNameEdit = new JTextField();
		textFieldUserNameEdit.setText("");
		GridBagConstraints gbc_textFieldUserNameEdit = new GridBagConstraints();
		gbc_textFieldUserNameEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserNameEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserNameEdit.gridx = 4;
		gbc_textFieldUserNameEdit.gridy = 7;
		contentPane.add(textFieldUserNameEdit, gbc_textFieldUserNameEdit);
		textFieldUserNameEdit.setColumns(10);
		
		lblUserPasswordEdit = new JLabel("Passowort");
		GridBagConstraints gbc_lblUserPasswordEdit = new GridBagConstraints();
		gbc_lblUserPasswordEdit.anchor = GridBagConstraints.EAST;
		gbc_lblUserPasswordEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserPasswordEdit.gridx = 3;
		gbc_lblUserPasswordEdit.gridy = 8;
		contentPane.add(lblUserPasswordEdit, gbc_lblUserPasswordEdit);
		
		textFieldPasswordEdit = new JTextField();
		GridBagConstraints gbc_textFieldPasswordEdit = new GridBagConstraints();
		gbc_textFieldPasswordEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPasswordEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswordEdit.gridx = 4;
		gbc_textFieldPasswordEdit.gridy = 8;
		contentPane.add(textFieldPasswordEdit, gbc_textFieldPasswordEdit);
		textFieldPasswordEdit.setColumns(10);
		
		btnSafe = new JButton("\u00C4nderungen Speichern");
		GridBagConstraints gbc_btnSafe = new GridBagConstraints();
		gbc_btnSafe.insets = new Insets(0, 0, 5, 5);
		gbc_btnSafe.gridx = 4;
		gbc_btnSafe.gridy = 10;
		contentPane.add(btnSafe, gbc_btnSafe);
		
		btnBack = new JButton("Zur\u00FCck");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 12;
		contentPane.add(btnBack, gbc_btnBack);
	}
}
