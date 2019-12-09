import java.awt.BorderLayout;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;






import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.sql.*;

import net.proteanit.sql.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;


public class Admin {

	private JFrame frame;
	private  static  JTable table;
	private static JScrollPane scrollPane;
	Icon icon;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */

	public static void NewScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {


		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {



					Admin window = new Admin();
					window.frame.setVisible(true);


					DB_Anfragen.Table_Bar(table);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */


	static Connection con =null;
	public Admin() {



		initialize();
		//	con=Database1.dbConnector();
		con = DataBaseConnector.dbConnectorMariaDB();
	}


	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setBackground(new Color(244, 164, 96));
		frame.getContentPane().setForeground(new Color(244, 164, 96));
		frame.setForeground(new Color(0, 0, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Haith\\Desktop\\Projekt1\\2015-10-26_Krombacher Marke des Jahres.jpg"));
		frame.setFont(null);
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 459, 1696, 249);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btAr = new JButton("Kneipen_Verwaltung");
		btAr.setForeground(Color.RED);
		btAr.setFont(new Font("Tahoma", Font.BOLD, 17));
		btAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				Kneipen K= new Kneipen();
				try {
					K.NewScreen1();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();


			}
		});
		btAr.setBounds(25, 207, 291, 51);
		frame.getContentPane().add(btAr);

		JButton btEx = new JButton("EXIT");
		btEx.setForeground(Color.RED);
		btEx.setFont(new Font("Tahoma", Font.BOLD, 17));
		btEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
			}
		});
		btEx.setBounds(25, 286, 291, 51);
		frame.getContentPane().add(btEx);

		JButton btKW = new JButton("Kneipen_Quiz_Verwaltung");
		btKW.setForeground(Color.RED);
		btKW.setFont(new Font("Tahoma", Font.BOLD, 17));
		btKW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kneipe_Verwaltung KV= new Kneipe_Verwaltung();
				try {
					KV.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();

			}
		});
		btKW.setBounds(25, 127, 291, 51);
		frame.getContentPane().add(btKW);

		JButton btFr = new JButton("Fragen_Pool");
		btFr.setForeground(Color.RED);
		btFr.setFont(new Font("Tahoma", Font.BOLD, 17));
		btFr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Fragen_Pool FP= new Fragen_Pool();
				try {
					FP.newScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btFr.setBounds(25, 50, 291, 51);
		frame.getContentPane().add(btFr);

		JButton btnNewButton = new JButton("Print");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {


			}
		});
		btnNewButton.setBounds(25, 378, 291, 51);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\18006_krombacher_alkoholfrei_450x450 (1).jpg"));
		lblNewLabel.setBounds(0, 0, 1733, 721);
		frame.getContentPane().add(lblNewLabel);
	}
}
