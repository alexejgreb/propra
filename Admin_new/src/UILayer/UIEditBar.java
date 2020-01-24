package UILayer;

import DataLayer.Bar;
import DataLayer.DataBase;
import LogicLayer.BarListCellRenderer;
import LogicLayer.Logic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UIEditBar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldSurename;
	private JTextField textFieldFirstname;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldMobil;
	private JTextField textFieldEMail;
	private JTextField textFieldPassword;
	private JTextField textFieldBarName;
	private JTextField textFieldPasswordRepeat;
	private JTextField textFieldMessage;
	private JTextField textFieldPostcode;
	private JTextField textSearch;
	private ArrayList<Bar> barList = new ArrayList<>();
	private Bar bar = new Bar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIEditBar frame = new UIEditBar();
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
	public UIEditBar() {
		DataBase db= new DataBase();
		Logic logic = new Logic();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 100, 0, 600, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Neue Bar anlegen");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblSearch = new JLabel("Suchen");
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.insets = new Insets(0, 0, 5, 0);
		gbc_lblSearch.gridx = 3;
		gbc_lblSearch.gridy = 1;
		contentPane.add(lblSearch, gbc_lblSearch);

		JLabel lblIdOrBarname = new JLabel("ID-Nummer oder Barname");
		GridBagConstraints gbc_lblIdOrBarname = new GridBagConstraints();
		gbc_lblIdOrBarname.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdOrBarname.gridx = 3;
		gbc_lblIdOrBarname.gridy = 2;
		contentPane.add(lblIdOrBarname, gbc_lblIdOrBarname);

		JLabel lblId = new JLabel("ID Nummer");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 3;
		contentPane.add(lblId, gbc_lblId);

		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 3;
		contentPane.add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(10);

		textSearch = new JTextField();
		GridBagConstraints gbc_textSearch = new GridBagConstraints();
		gbc_textSearch.insets = new Insets(0, 0, 5, 0);
		gbc_textSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSearch.gridx = 3;
		gbc_textSearch.gridy = 3;
		contentPane.add(textSearch, gbc_textSearch);
		textSearch.setColumns(10);

		JLabel lblSurename = new JLabel("Nachname");
		GridBagConstraints gbc_lblSurename = new GridBagConstraints();
		gbc_lblSurename.anchor = GridBagConstraints.EAST;
		gbc_lblSurename.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurename.gridx = 0;
		gbc_lblSurename.gridy = 4;
		contentPane.add(lblSurename, gbc_lblSurename);

		textFieldSurename = new JTextField();
		GridBagConstraints gbc_textFieldSurename = new GridBagConstraints();
		gbc_textFieldSurename.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSurename.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSurename.gridx = 1;
		gbc_textFieldSurename.gridy = 4;
		contentPane.add(textFieldSurename, gbc_textFieldSurename);
		textFieldSurename.setColumns(10);


		JLabel lblFirstname = new JLabel("Vorname");
		GridBagConstraints gbc_lblFirstname = new GridBagConstraints();
		gbc_lblFirstname.anchor = GridBagConstraints.EAST;
		gbc_lblFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstname.gridx = 0;
		gbc_lblFirstname.gridy = 5;
		contentPane.add(lblFirstname, gbc_lblFirstname);

		textFieldFirstname = new JTextField();
		GridBagConstraints gbc_textFieldFirstname = new GridBagConstraints();
		gbc_textFieldFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFirstname.gridx = 1;
		gbc_textFieldFirstname.gridy = 5;
		contentPane.add(textFieldFirstname, gbc_textFieldFirstname);
		textFieldFirstname.setColumns(10);

		DefaultListModel<Bar> model = new DefaultListModel<Bar>();
		JList<Bar> list = new JList(model);
		list.setCellRenderer(new BarListCellRenderer());
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 15;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 5;
		contentPane.add(list, gbc_list);


		JLabel lblStreet = new JLabel("Straße und Hausnummer");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 7;
		contentPane.add(lblStreet, gbc_lblStreet);

		textFieldStreet = new JTextField();
		GridBagConstraints gbc_textFieldStreet = new GridBagConstraints();
		gbc_textFieldStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStreet.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStreet.gridx = 1;
		gbc_textFieldStreet.gridy = 7;
		contentPane.add(textFieldStreet, gbc_textFieldStreet);
		textFieldStreet.setColumns(10);

		JLabel lblCity = new JLabel("Stadt");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 8;
		contentPane.add(lblCity, gbc_lblCity);

		textFieldCity = new JTextField();
		GridBagConstraints gbc_textFieldCity = new GridBagConstraints();
		gbc_textFieldCity.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCity.gridx = 1;
		gbc_textFieldCity.gridy = 8;
		contentPane.add(textFieldCity, gbc_textFieldCity);
		textFieldCity.setColumns(10);

		JLabel lblPostCode = new JLabel("Postleitzahl");
		GridBagConstraints gbc_lblPostCode = new GridBagConstraints();
		gbc_lblPostCode.anchor = GridBagConstraints.EAST;
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 0;
		gbc_lblPostCode.gridy = 9;
		contentPane.add(lblPostCode, gbc_lblPostCode);

		textFieldPostcode = new JTextField();
		GridBagConstraints gbc_textFieldPostcode = new GridBagConstraints();
		gbc_textFieldPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPostcode.gridx = 1;
		gbc_textFieldPostcode.gridy = 9;
		contentPane.add(textFieldPostcode, gbc_textFieldPostcode);
		textFieldPostcode.setColumns(10);

		JLabel lblBarName = new JLabel("Bar-Name");
		GridBagConstraints gbc_lblBarName = new GridBagConstraints();
		gbc_lblBarName.anchor = GridBagConstraints.EAST;
		gbc_lblBarName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarName.gridx = 0;
		gbc_lblBarName.gridy = 10;
		contentPane.add(lblBarName, gbc_lblBarName);

		textFieldBarName = new JTextField();
		GridBagConstraints gbc_textFieldBarName = new GridBagConstraints();
		gbc_textFieldBarName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBarName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBarName.gridx = 1;
		gbc_textFieldBarName.gridy = 10;
		contentPane.add(textFieldBarName, gbc_textFieldBarName);
		textFieldBarName.setColumns(10);

		JLabel lblMobile = new JLabel("Telefonnummer");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 0;
		gbc_lblMobile.gridy = 11;
		contentPane.add(lblMobile, gbc_lblMobile);

		textFieldMobil = new JTextField();
		GridBagConstraints gbc_textFieldMobil = new GridBagConstraints();
		gbc_textFieldMobil.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMobil.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMobil.gridx = 1;
		gbc_textFieldMobil.gridy = 11;
		contentPane.add(textFieldMobil, gbc_textFieldMobil);
		textFieldMobil.setColumns(10);

		JLabel lblEMail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEMail = new GridBagConstraints();
		gbc_lblEMail.anchor = GridBagConstraints.EAST;
		gbc_lblEMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEMail.gridx = 0;
		gbc_lblEMail.gridy = 13;
		contentPane.add(lblEMail, gbc_lblEMail);

		textFieldEMail = new JTextField();
		GridBagConstraints gbc_textFieldEMail = new GridBagConstraints();
		gbc_textFieldEMail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEMail.gridx = 1;
		gbc_textFieldEMail.gridy = 13;
		contentPane.add(textFieldEMail, gbc_textFieldEMail);
		textFieldEMail.setColumns(10);

		JLabel lblPassword = new JLabel("Passwort");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 14;
		contentPane.add(lblPassword, gbc_lblPassword);

		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 14;
		contentPane.add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);

		JLabel lblPasswordRepeat = new JLabel("Passwort wiederholen");
		GridBagConstraints gbc_lblPasswordRepeat = new GridBagConstraints();
		gbc_lblPasswordRepeat.anchor = GridBagConstraints.EAST;
		gbc_lblPasswordRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswordRepeat.gridx = 0;
		gbc_lblPasswordRepeat.gridy = 15;
		contentPane.add(lblPasswordRepeat, gbc_lblPasswordRepeat);

		textFieldPasswordRepeat = new JTextField();
		GridBagConstraints gbc_textFieldPasswordRepeat = new GridBagConstraints();
		gbc_textFieldPasswordRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPasswordRepeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswordRepeat.gridx = 1;
		gbc_textFieldPasswordRepeat.gridy = 15;
		contentPane.add(textFieldPasswordRepeat, gbc_textFieldPasswordRepeat);
		textFieldPasswordRepeat.setColumns(10);

		JLabel lblMessage = new JLabel("Notiz");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.anchor = GridBagConstraints.EAST;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 17;
		contentPane.add(lblMessage, gbc_lblMessage);

		textFieldMessage = new JTextField("");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 17;
		contentPane.add(textFieldMessage, gbc_textField);
		textFieldMessage.setColumns(10);

		JCheckBox chckbxBarDeaktivieren = new JCheckBox("Bar deaktivieren");
		GridBagConstraints gbc_chckbxBarDeaktivieren = new GridBagConstraints();
		gbc_chckbxBarDeaktivieren.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBarDeaktivieren.gridx = 1;
		gbc_chckbxBarDeaktivieren.gridy = 19;
		contentPane.add(chckbxBarDeaktivieren, gbc_chckbxBarDeaktivieren);


		JButton btnBack = new JButton("Zurück");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 20;
		contentPane.add(btnBack, gbc_btnBack);

		JButton btnAddBar = new JButton("Bar hinzufügen");
		GridBagConstraints gbc_btnAddBar = new GridBagConstraints();
		gbc_btnAddBar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddBar.gridx = 1;
		gbc_btnAddBar.gridy = 20;
		contentPane.add(btnAddBar, gbc_btnAddBar);
		btnAddBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean barIsActive =true;
				if (chckbxBarDeaktivieren.isSelected()){
					barIsActive=false;
				}
				//Vergleiche ob beide Passwörter übereinstimmen
				if (textFieldPassword.getText()==textFieldPasswordRepeat.getText()){
					//logic.addBar(textFieldId.getText(),textFieldBarName.getText(),textFieldFirstname.getText(),textFieldSurename.getText(),textFieldMobil.getText(),textFieldStreet.getText(),textFieldCity.getText(),textFieldPostcode.getText(),textFieldEMail.getText(),textFieldPassword.getText(),textFieldMessage.getText(),barIsActive,);
				}
				else{
					JOptionPane.showMessageDialog(null,"Passwörtfelder stimmen nicht überein!");
				}
			}
		});

		JButton btnSearch = new JButton("Suchen");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.removeAllElements();
				int i=Integer.valueOf(textSearch.getText());
				barList =db.searchBar(i);
				int j=0;
				while(j<barList.size()){
					bar=barList.get(j);
					model.addElement(barList.get(j));
					j++;
				}
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 4;
		contentPane.add(btnSearch, gbc_btnSearch);
	}

}
