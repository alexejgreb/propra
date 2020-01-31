package UILayer;

import DataLayer.Bar;
import DataLayer.DataBase;
import LogicLayer.Logic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class t extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Bar> barlist = new ArrayList<>();
	private DataBase db = new DataBase();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t frame = new t();
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
	public t() {
		Logic logic = new Logic();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Container con = new SouthSide();
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);

		//JTextField textFieldSearchId= new JTextField(logic.fillTable(););
		//contentPane.add(textFieldSearchId,BorderLayout.SOUTH);
		
		JButton btnSearch = new JButton("Suchen");
		contentPane.add(btnSearch, BorderLayout.SOUTH);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barlist=db.searchBar(0);
			}
		});
	}
	public class SouthSide extends Container{

	}

}
