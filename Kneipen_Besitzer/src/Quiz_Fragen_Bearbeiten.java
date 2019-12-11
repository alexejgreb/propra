import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.ImageIcon;


public class Quiz_Fragen_Bearbeiten {

	private JFrame frame;
	private static JTextField t;
	private static JTextField t1;
	private JTextField t2;
	private static JLabel l3,l2;
	private static JComboBox cb1;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void Screen3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {





					Quiz_Fragen_Bearbeiten window = new Quiz_Fragen_Bearbeiten();
					window.frame.setVisible(true);
					tname.setText(Quiz_Verwaltung.tname.getText());
					tnummer.setText(Quiz_Verwaltung.tnummer.getText());
					t.setText(Quiz_Verwaltung.cb1.getSelectedItem().toString());
					t1.setText(Quiz_Verwaltung.cb2.getSelectedItem().toString());


					/////

					try{


						String query2="select Frage from FragenPool where FrageNr = '"+t1.getText()+"'";
						PreparedStatement pst1=con.prepareStatement(query2);

						ResultSet rs= pst1.executeQuery();
						//c1.removeAllItems();
						while (rs.next()){


							String frage = rs.getString("Frage");
							l3.setText(frage);

						}

						rs.close();

					}
					catch(Exception e2){
						e2.printStackTrace();

					}

					//////

					/////

					try{


						String query2="select FrageNr from FragenPool where Besitzer=0 or Besitzer =1 or Besitzer ='"+tnummer.getText()+"' ";
						PreparedStatement pst1=con.prepareStatement(query2);

						ResultSet rs= pst1.executeQuery();
						//c1.removeAllItems();
						while (rs.next()){


							String FrageNr = rs.getString("FrageNr");
							cb1.addItem(FrageNr);

						}

						rs.close();

					}
					catch(Exception e2){
						e2.printStackTrace();

					}



					///////



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
	private static JTextField tname;
	private static JTextField tnummer;
	public Quiz_Fragen_Bearbeiten() {


		initialize();
		con = DataBaseConnector.dbConnectorMariaDB();
		//con=Database.dbConnector();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Spielnummer:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 28, 153, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("FragenNr:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 81, 85, 16);
		frame.getContentPane().add(lblNewLabel_1);

		t = new JTextField();
		t.setEditable(false);
		t.setBounds(170, 26, 170, 22);
		frame.getContentPane().add(t);
		t.setColumns(10);

		t1 = new JTextField();
		t1.setEditable(false);
		t1.setColumns(10);
		t1.setBounds(109, 78, 49, 22);
		frame.getContentPane().add(t1);

		JButton btnNewButton = new JButton("Ändern");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				int YesorNo = JOptionPane.showConfirmDialog(null, " Wollen Sie die Frage Nr:'"+t1.getText()+"' mit der Frage Nr '"+t2.getText()+"' ersetzen?","Frage ändern", JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){

					try{


						//	String value115=licence.getText();
						String sql22="update Quiz_Fragen set Frage_Nr='"+t2.getText()+"'where Spiel_Nummer='"+t.getText()+"' and Frage_Nr='"+t1.getText()+"' and Bar_Nr='"+tnummer.getText()+"'";
						PreparedStatement pst3=con.prepareStatement(sql22);
						pst3.execute();
						//JOptionPane.showMessageDialog(null,"Erfolgreich geändert ");
					}catch(Exception e11){
						e11.printStackTrace();
					}


					Quiz_Verwaltung.ta.append("\t Frage ändern: \n\n"+"Spiel Nr: "+t.getText()+"\n======================================\n"+"Ehemalige_FrageNr:"+t1.getText()+"\n\n"+"Die Frage:"+l3.getText()+"\n======================================\n"+"Neue Frage_Nr:"+t2.getText()+"\n\n"+"Die neue Frage :\t"+l2.getText()+"\n\n"+
							" \t"+" \n======================================\n");

				}
				else{
					//JOptionPane.showMessageDialog(null,"Es ist nichts passiert!!!!");
				}

			}
		});
		btnNewButton.setBounds(608, 74, 153, 33);
		frame.getContentPane().add(btnNewButton);

		JButton btnHinzufgen = new JButton("Hinzufügen");
		btnHinzufgen.setForeground(Color.RED);
		btnHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int YesorNo = JOptionPane.showConfirmDialog(null, "Wollen Sie die Frage Nr:'"+t2.getText()+"' dem Spiel Nr :'"+t.getText()+"' hinzufügen?","Frage hinzufügen", JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){


					try{
						String sql = "insert into Quiz_Fragen (Spiel_Nummer,Frage_Nr,Bar_Nr)values (?,?,?)";
						PreparedStatement pst=con.prepareStatement(sql);
						pst.setString(1, t.getText());
						pst.setString(2, t2.getText());
						pst.setString(3, tnummer.getText());


						pst.execute();
						JOptionPane.showMessageDialog(null,"Die Frage '"+t2.getText()+"' wurde dem Spiel '"+t.getText()+"' hinzugefügt");


					}
					catch(Exception e11){
						e11.printStackTrace();
					}


					Quiz_Verwaltung.ta.append("\t Frage hinzugefügt: \n\n"+"Spiel Nr:\t"+t.getText()+"\n======================================\n"+"Neue_FrageNr:\t"+t2.getText()+"\n\n"+"Die Frage:\t"+l2.getText()+"\n======================================\n"+"\"\n\n"+":\t\n\n"+
							" \t"+" \n======================================\n");

				}
				else{
					//JOptionPane.showMessageDialog(null,"Es ist nichts passiert!!!!");
				}



			}

		});
		btnHinzufgen.setBounds(608, 119, 153, 37);
		frame.getContentPane().add(btnHinzufgen);

		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.setForeground(Color.RED);
		btnEntfernen.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int YesorNo = JOptionPane.showConfirmDialog(null, " Wollen sie die Frage Nr:'"+t1.getText()+"' vom Spiel Nr :'"+t.getText()+"' entfernen?","Frage löschen", JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){
					try{


						String Delete =" delete from Quiz_Fragen where Spiel_Nummer = '"+t.getText()+"' And Frage_Nr = '"+t1.getText()+"' and Bar_Nr='"+tnummer.getText()+"'";

						PreparedStatement pst3=con.prepareStatement(Delete);
						pst3.execute();
						pst3.close();
						JOptionPane.showMessageDialog(null,"Die Frage '"+t1.getText()+"' ist erfolgreich vom Spiel '"+t.getText()+"' entfernt worden.");

					} catch(Exception e1){
						e1.printStackTrace();
					}

					Quiz_Verwaltung.ta.append("\t Frage entfernt: \n\n"+"Spiel Nr:\t"+t.getText()+"\n======================================\n"+"FrageNr:\t"+t1.getText()+"\n\n"+"Die Frage:\t"+l3.getText()+"\n======================================\n"+"\"\n\n"+":\t\n\n"+
							" \t"+" \n======================================\n");

				}
				else{
					//JOptionPane.showMessageDialog(null,"Es ist nichts passiert.");
				}

			}
		});
		btnEntfernen.setBounds(608, 169, 153, 37);
		frame.getContentPane().add(btnEntfernen);

		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(228, 78, 49, 22);
		frame.getContentPane().add(t2);

		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(170, 72, 49, 37);
		frame.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 206, 584, 46);
		frame.getContentPane().add(scrollPane_1);

		l2 = new JLabel("Die Frage:");
		scrollPane_1.setViewportView(l2);
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Arial Black", Font.BOLD, 11));

		cb1 = new JComboBox();
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t2.setText(cb1.getSelectedItem().toString());

				try{


					String query2="select Frage from FragenPool where FrageNr ='"+t2.getText()+"' ";
					PreparedStatement pst1=con.prepareStatement(query2);

					ResultSet rs= pst1.executeQuery();
					//c1.removeAllItems();
					while (rs.next()){


						String Frage = rs.getString("Frage");
						l2.setText(Frage);

					}

					rs.close();

				}
				catch(Exception e2){
					e2.printStackTrace();

				}
			}
		});
		cb1.setBounds(289, 78, 103, 22);
		frame.getContentPane().add(cb1);

		JButton btnExit = new JButton("Schließen");
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Quiz_Verwaltung QW= new Quiz_Verwaltung();
				//QW.Screen2();
				frame.dispose();

			}
		});
		btnExit.setBounds(608, 219, 153, 33);
		frame.getContentPane().add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 152, 584, 37);
		frame.getContentPane().add(scrollPane);

		l3 = new JLabel("New label");
		scrollPane.setViewportView(l3);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Arial Black", Font.BOLD, 11));

		JLabel label = new JLabel("Kneipennummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(593, 13, 168, 16);
		frame.getContentPane().add(label);

		tname = new JTextField();
		tname.setText("#KneipeXXXY");
		tname.setEditable(false);
		tname.setColumns(10);
		tname.setBounds(575, 39, 93, 22);
		frame.getContentPane().add(tname);

		tnummer = new JTextField();
		tnummer.setText("310514");
		tnummer.setEditable(false);
		tnummer.setColumns(10);
		tnummer.setBounds(693, 39, 68, 22);
		frame.getContentPane().add(tnummer);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Ressources/download Krombacher Hintergrundbild 1024x768-1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 773, 265);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
