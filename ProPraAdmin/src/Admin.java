import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;


public class Admin {

	private JFrame frame;
	private static  JTable table;
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

					try {
						String query="select * from Kneipe_Teilnehmer";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs= pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
							

					} catch (Exception e) {
						e.printStackTrace();
					}	
					
					
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
		con=Database1.dbConnector();
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
		frame.setBounds(100, 100, 1004, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 241, 926, 162);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btAr = new JButton("Archiv");
		btAr.setBounds(25, 105, 163, 34);
		frame.getContentPane().add(btAr);
		
		JButton btEx = new JButton("EXIT");
		btEx.setBounds(25, 152, 163, 34);
		frame.getContentPane().add(btEx);
		
		JButton btKW = new JButton("Kneipen_Verwaltung");
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
		btKW.setBounds(25, 62, 163, 34);
		frame.getContentPane().add(btKW);
		
		JButton btFr = new JButton("Fragen_Pool");
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
		btFr.setBounds(25, 15, 163, 34);
		frame.getContentPane().add(btFr);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setBounds(25, 192, 163, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Desktop\\Projekt1\\image_content_828136805_20180122145147.jpg"));
		lblNewLabel.setBounds(0, 0, 986, 433);
		frame.getContentPane().add(lblNewLabel);
	}
}
