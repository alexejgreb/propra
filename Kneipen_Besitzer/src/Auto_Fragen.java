import java.awt.EventQueue;










import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class Auto_Fragen {




	private JFrame frame;
	private static  JTextField tt;
	private static JTextField ff;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;
	private static JTextField s1;
	private static JTextField f1;
	static Connection con =null;
	private static JLabel l1,l2;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void Fragen_Quiz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auto_Fragen window = new Auto_Fragen();
					window.frame.setVisible(true);

					t1.setVisible(false);
					t2.setVisible(false);
					t3.setVisible(false);
					tt.setText(Spiel_Starten.tvt.getText());
					s1.setText(Spiel_Starten.t1.getText());
					ff.setText(Spiel_Starten.ff.getText());
					f1.setText(Spiel_Starten.cb.getSelectedItem().toString()+" / "+Spiel_Starten.cc.getSelectedItem().toString());
					l1.setText(Spiel_Starten.cb.getSelectedItem().toString());
					l2.setText(Spiel_Starten.cc.getSelectedItem().toString());
					l1.setVisible(false);
					l2.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Auto_Fragen() {
		initialize();
		frame.setResizable(false);
		con = DataBaseConnector.dbConnectorMariaDB();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Kneipennummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(581, 0, 168, 29);
		frame.getContentPane().add(label);

		tt = new JTextField();
		tt.setFont(new Font("Tahoma", Font.BOLD, 13));
		tt.setText("#KneipeXXXY");
		tt.setEditable(false);
		tt.setColumns(10);
		tt.setBounds(581, 31, 93, 22);
		frame.getContentPane().add(tt);

		ff = new JTextField();
		ff.setFont(new Font("Tahoma", Font.BOLD, 13));
		ff.setText("310514");
		ff.setEditable(false);
		ff.setColumns(10);
		ff.setBounds(681, 31, 68, 22);
		frame.getContentPane().add(ff);

		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default", "POP_Quiz", "Lokal"}));
		comboBox.setBounds(12, 77, 153, 22);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"POP_Quiz", "Defaul", "Lokal"}));
		comboBox_1.setBounds(196, 77, 153, 22);
		frame.getContentPane().add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setEditable(true);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Lokal", "Default", "POP_Quiz"}));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_2.setBounds(375, 77, 153, 22);
		frame.getContentPane().add(comboBox_2);

		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt1.setText("0");
		txt1.setBounds(12, 42, 99, 22);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setText("0");
		txt2.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt2.setColumns(10);
		txt2.setBounds(196, 42, 99, 22);
		frame.getContentPane().add(txt2);

		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt3.setText("0");
		txt3.setColumns(10);
		txt3.setBounds(375, 42, 99, 22);
		frame.getContentPane().add(txt3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 143, 562, 97);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnPrint = new JButton("Drucken");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Spiel_Starten.ta.print();
				} catch (PrinterException e) {
					e.printStackTrace();
				}


			}
		});
		btnPrint.setForeground(Color.RED);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPrint.setBounds(596, 131, 153, 42);
		frame.getContentPane().add(btnPrint);

		JButton btnHinzufgen = new JButton("Hinzufügen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				try{

					DB_Anfragen.Select_Count_FragenPool0(0, t1);

					DB_Anfragen.Select_Count_FragenPool0(1, t2);
					DB_Anfragen.Select_Count_FragenPool0(Integer.parseInt(ff.getText()), t3);

					try{


						int Default = Integer.parseInt(txt1.getText());
						int pop = Integer.parseInt(txt2.getText());
						int Lokal = Integer.parseInt(txt3.getText());
						int Summe = Default + pop + Lokal ;
						int AnzahleF = Integer.parseInt(Spiel_Starten.cc.getSelectedItem().toString())* Integer.parseInt(Spiel_Starten.cb.getSelectedItem().toString());

						if(Summe== AnzahleF){

							try{

								int Default1 = Integer.parseInt(t1.getText());
								int pop1 = Integer.parseInt(t2.getText());
								int Lokal1 = Integer.parseInt(t3.getText());


								if (Default> Default1){


									JOptionPane.showMessageDialog(null,"Die maximale Anzahl der Fragen der Kategorie Default ist '"+Default1+"'  !");


								}else if (pop>pop1){


									JOptionPane.showMessageDialog(null," Die maximale Anzahl der Fragen der Kategorie POP_QUIZ ist '"+pop1+"'  !");


								}else if(Lokal>Lokal1){
									JOptionPane.showMessageDialog(null,"Die maximale Anzahl der Fragen der Kategorie Lokal ist '"+Lokal1+"'  !");
								}else{


									if(Default>0){

										DB_Anfragen.Select_FrageNR_FragenPool(0,Default,s1,ff);
										JOptionPane.showMessageDialog(null," Die '"+Default+"'  Fragen aus der Kategorie Default wurden erfolgreich dem Quiz '"+s1.getText()+"' hinzugefügt.");
									}

									if(pop>0){
										DB_Anfragen.Select_FrageNR_FragenPool(1,pop,s1,ff);

										JOptionPane.showMessageDialog(null,"Die '"+pop+"'  Fragen aus der Kategorie POP_QUIZ wurden erfolgreich für den Spiel '"+s1.getText()+"' hinzugefügt.");




									}

									if(Lokal>0){
										DB_Anfragen.Select_FrageNR_FragenPool(Integer.parseInt(ff.getText()),Lokal,s1,ff);


										JOptionPane.showMessageDialog(null," Die '"+Lokal+"'  Fragen aus der Kategorie Lokal wurden erfolgreich für das Spiel'"+s1.getText()+"' hinzugefügt.");



									}


									DB_Anfragen.Insert_Spiel_Fragen(s1,Spiel_Starten.Zeit,Spiel_Starten.licence,Spiel_Starten.comboBox,Spiel_Starten.comboBox_1,Spiel_Starten.comboBox_2,Spiel_Starten.comboBox_3,Spiel_Starten.comboBox_4,Spiel_Starten.cc,Spiel_Starten.cb,ff);

									DB_Anfragen.Table_Fragen_Quiz(table,s1);
								}



							}catch(Exception e2){




							}
						}
						else{


							JOptionPane.showMessageDialog(null,"Sie müssen in der Summe '"+AnzahleF+"' Fragen auswählen.");


						}

					}catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Prüfen Sie die angegebenen Daten!");
					}


				} catch (Exception e){

					System.out.println(e);

				}

























			}
		});
		btnHinzufgen.setForeground(Color.RED);
		btnHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHinzufgen.setBounds(596, 67, 153, 42);
		frame.getContentPane().add(btnHinzufgen);

		JButton btnExit = new JButton("Schließen");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spiel_Starten.aar.setText("");
				Spiel_Starten.aar2.setText("");
				frame.dispose();
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExit.setBounds(596, 198, 153, 42);
		frame.getContentPane().add(btnExit);

		JLabel lblSpielnummer = new JLabel("Spielnummer:");
		lblSpielnummer.setForeground(Color.RED);
		lblSpielnummer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSpielnummer.setBounds(12, 10, 153, 22);
		frame.getContentPane().add(lblSpielnummer);

		JLabel lblFragenrunden = new JLabel("Fragen/Runden");
		lblFragenrunden.setForeground(Color.RED);
		lblFragenrunden.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFragenrunden.setBounds(321, 10, 145, 22);
		frame.getContentPane().add(lblFragenrunden);

		s1 = new JTextField();
		s1.setEditable(false);
		s1.setFont(new Font("Tahoma", Font.BOLD, 16));
		s1.setColumns(10);
		s1.setBounds(169, 11, 99, 22);
		frame.getContentPane().add(s1);

		f1 = new JTextField();
		f1.setEditable(false);
		f1.setFont(new Font("Tahoma", Font.BOLD, 16));
		f1.setColumns(10);
		f1.setBounds(470, 11, 99, 22);
		frame.getContentPane().add(f1);

		l1 = new JLabel("");
		l1.setBounds(493, 34, 29, 16);
		frame.getContentPane().add(l1);

		l2 = new JLabel("");
		l2.setBounds(503, 48, 22, 16);
		frame.getContentPane().add(l2);

		t1 = new JTextField();
		t1.setBounds(22, 108, 116, 22);
		frame.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(196, 112, 116, 22);
		frame.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(375, 112, 116, 22);
		frame.getContentPane().add(t3);

		lblNewLabel = new JLabel("");
		//TODO
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\download Krombacher Hintergrundbild 1024x768-1 (1).jpg"));
		lblNewLabel.setBounds(0, 0, 773, 265);
		frame.getContentPane().add(lblNewLabel);
	}
}
