package UILayer;

import DataLayer.DataBase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UIBarManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIBarManager frame = new UIBarManager();
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
	public UIBarManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBar = new JButton("Bar hinzufügen");
		btnAddBar.setBounds(10, 51, 115, 23);
		contentPane.add(btnAddBar);
		btnAddBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIAddBar.main(null);
			}
		});
		
		JButton btnBack = new JButton("Zurück");
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIMainMenu.main(null);
					dispose();
				} catch (ClassNotFoundException
						| UnsupportedLookAndFeelException
						| InstantiationException
						| IllegalAccessException ex) {
					ex.printStackTrace();
				}
				dispose();
			}
		});
	}
}
