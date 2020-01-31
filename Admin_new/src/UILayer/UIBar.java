package UILayer;

import DataLayer.Bar;
import DataLayer.DataBase;
import DataLayer.GlobalId;
import LogicLayer.Logic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIBar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearchId;
	private JTable table;
	private final JButton btnSearch = new JButton("Suchen");
	private ArrayList<Bar> barList = new ArrayList<Bar>();

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


	public UIBar() {
		Logic logic = new Logic();
		DataBase db= new DataBase();
		DefaultTableModel model = new DefaultTableModel();



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
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
				barList=db.searchBar(Integer.valueOf(textFieldSearchId.getText()));
				for(int i=0;i<barList.size();i++){
					model.addRow(new Object[] {barList.get(i).getId(),barList.get(i).getBarName(),barList.get(i).getCity(),barList.get(i).getSurename(),barList.get(i).getFirstname(),barList.get(i).getMail(),barList.get(i).getNote()});
				}
			}
		});
		contentPane.add(btnSearch, gbc_btnSearch);

		table = new JTable(model);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 3;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane,gbc_table);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int id = table.rowAtPoint(point);
					System.out.println(id);
					JOptionPane.showMessageDialog(null,"öffnen!");
					int row1 = table.getSelectedRow();
					int column = table.getSelectedColumn();
					String valueInCell = String.valueOf(table.getValueAt(row, column));
					String g=valueInCell;
					GlobalId globalId= new GlobalId(Integer.valueOf(g));
					//UIEditBaredit ui = new UIEditBaredit(Integer.valueOf(g));
					//ui.setVisible(true);
					System.out.println(g);
					// your valueChanged overridden method
				}
			}
		});
		//muss auskommentiert bleiben, sonst gibt es keine Scrollbar
		//contentPane.add(table, gbc_table);

		//addColums
		model.addColumn("ID");
		model.addColumn("Barname");
		model.addColumn("Stadt");
		model.addColumn("Nachname");
		model.addColumn("Vorname");
		model.addColumn("Email");
		model.addColumn("Aktiv");

		
		JButton btnback = new JButton("Zur\u00FCck");
		GridBagConstraints gbc_btnback = new GridBagConstraints();
		gbc_btnback.insets = new Insets(0, 0, 0, 5);
		gbc_btnback.gridx = 0;
		gbc_btnback.gridy = 4;
		contentPane.add(btnback, gbc_btnback);
		
		JButton btnSelect = new JButton("Bearbeiten");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 4;
		contentPane.add(btnSelect, gbc_btnSelect);
		
		JButton btnCreateNewBar = new JButton("Neu Bar Anlegen");
		GridBagConstraints gbc_btnCreateNewBar = new GridBagConstraints();
		gbc_btnCreateNewBar.gridx = 2;
		gbc_btnCreateNewBar.gridy = 4;
		contentPane.add(btnCreateNewBar, gbc_btnCreateNewBar);
	}

}
