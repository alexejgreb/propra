package UILayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIBar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearchId;
	private JTable table;
	private final JButton btnSearch = new JButton("Suchen");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIBar frame = new UIBar();
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
	public UIBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSearchId = new JLabel("Suche nach ID-Nummer");
		GridBagConstraints gbc_lblSearchId = new GridBagConstraints();
		gbc_lblSearchId.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchId.gridx = 0;
		gbc_lblSearchId.gridy = 1;
		contentPane.add(lblSearchId, gbc_lblSearchId);
		
		textFieldSearchId = new JTextField();
		GridBagConstraints gbc_textFieldSearchId = new GridBagConstraints();
		gbc_textFieldSearchId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSearchId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSearchId.gridx = 1;
		gbc_textFieldSearchId.gridy = 1;
		contentPane.add(textFieldSearchId, gbc_textFieldSearchId);
		textFieldSearchId.setColumns(10);

		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnSearch, gbc_btnSearch);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 3;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		contentPane.add(table, gbc_table);
		
		JButton btnback = new JButton("Zur\u00FCck");
		GridBagConstraints gbc_btnback = new GridBagConstraints();
		gbc_btnback.insets = new Insets(0, 0, 0, 5);
		gbc_btnback.gridx = 0;
		gbc_btnback.gridy = 4;
		contentPane.add(btnback, gbc_btnback);
		
		JButton btnCreateNewBar = new JButton("Neu Bar Anlegen");
		GridBagConstraints gbc_btnCreateNewBar = new GridBagConstraints();
		gbc_btnCreateNewBar.gridx = 2;
		gbc_btnCreateNewBar.gridy = 4;
		contentPane.add(btnCreateNewBar, gbc_btnCreateNewBar);
	}

}
