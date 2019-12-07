import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;


public class Bar_Owner {

	private JFrame frame;
	private static JTextField Name;
	private static JPasswordField pass;
	private static JRadioButton nein,ja;
	private static JLabel Account ,pwd,Benutzer;
	private static JButton exit,login;
	private static JButton btnNewButton;
	private static JButton pwd1;
	private static JLabel t1;
	private static JLabel t2;
	private static JTextField BarNR;
	private static JLabel t3;
	private static JTextField name;
	private static JLabel t4;
	private static JTextField vorname;
	private static JLabel t5;
	private static JTextField strasse;
	private static JLabel t6;
	private static JTextField stadt;
	private static JLabel t7;
	private static JTextField plz;
	private static JLabel t8;
	private static JTextField tel;
	private static JLabel t9;
	private static JTextField email;
	private static JLabel t10;
	private static JTextField bname;
	private static JLabel t11;
	private static JTextArea msg;
	private static JScrollPane scrollPane;
	private static JButton aktu;
	private static JButton quit;
	private static JButton btnRegi;
	private static JLabel t01;
	private static JTextField epwd;
	private static JLabel t001,Zeit;
	private static JTextField barnr0;
	private static JButton pwd01;
	private static JTextArea ta;
	private static JScrollPane scrollPane_1;
	private static int P1,P2,P3;
	private static int Var=0;
	private static JLabel ppwd,labelname;
	private static JLabel test,bild1;




	public float f;
	public static  JLabel bar;
	public  static JLabel pub;
	private static JTextField test22;
	private static JLabel psp;
	private static JLabel tz;
	private static JLabel pasw;
	private static JLabel b1;
	private static JLabel lblNewLabel;
	private static JLabel b2;
	private static JLabel lblNewLabelhhhhhhhhh;
	private static JLabel b3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Bar_Owner window = new Bar_Owner();
					window.frame.setVisible(true);

					ja.setSelected(false);
					nein.setSelected(false);

					scrollPane_1.setVisible(false);
					ta.setVisible(false);
					Benutzer.setText("Benutzer_Name:");


					b1.setVisible(true);


					pasw.setVisible(false);
					pub.setVisible(false);
					bar.setVisible(false);
					test.setVisible(false);
					tz.setVisible(false);
					labelname.setVisible(false);
					ppwd.setVisible(false);
					test22.setVisible(false);
					Zeit.setVisible(false);
					psp.setVisible(false);
					pwd01.setVisible(false);
					t001.setVisible(false);
					barnr0.setVisible(false);
					pwd1.setVisible(false);
					Benutzer.setVisible(false);
					pwd.setVisible(false);
					Name.setVisible(false);
					pass.setVisible(false);
					exit.setVisible(false);
					login.setVisible(false);
					t1.setVisible(false);
					btnRegi.setVisible(false);
					aktu.setVisible(false);
					quit.setVisible(false);
					msg.setVisible(false);
					t2.setVisible(false);
					t3.setVisible(false);
					t4.setVisible(false);
					t5.setVisible(false);
					t6.setVisible(false);
					t6.setVisible(false);
					t7.setVisible(false);
					t8.setVisible(false);
					t9.setVisible(false);
					t10.setVisible(false);
					t11.setVisible(false);
					name.setVisible(false);
					vorname.setVisible(false);
					strasse.setVisible(false);
					stadt.setVisible(false);
					plz.setVisible(false);
					tel.setVisible(false);
					email.setVisible(false);
					bname.setVisible(false);
					BarNR.setVisible(false);
					scrollPane.setVisible(false);
					t01.setVisible(false);
					epwd.setVisible(false);

					//ppwd.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public void Clock(){
		Calendar cal = new GregorianCalendar();
		int Tag = cal.get(Calendar.DAY_OF_MONTH);
		int Jahre = cal.get(Calendar.YEAR);
		int Monat = cal.get(Calendar.MONTH);

		Zeit.setText(+Tag+"/"+Monat+"/"+Jahre);
	}

	public Bar_Owner() {
		initialize();
		frame.setResizable(false);
		Clock();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1751, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Benutzer = new JLabel("Benutzer_Name:");
		Benutzer.setForeground(Color.RED);
		Benutzer.setFont(new Font("Traditional Arabic", Font.BOLD, 19));
		Benutzer.setBounds(554, 265, 176, 29);
		frame.getContentPane().add(Benutzer);

		pwd = new JLabel("Password:");
		pwd.setForeground(Color.RED);
		pwd.setFont(new Font("Traditional Arabic", Font.BOLD, 19));
		pwd.setBounds(554, 335, 176, 29);
		frame.getContentPane().add(pwd);

		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Name.setBounds(765, 259, 379, 38);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		t1 = new JLabel("Bitte fühlen sie  dieses Anmelderformular aus\r\nVielen DANK :)");
		t1.setForeground(Color.RED);
		t1.setFont(new Font("Arial Black", Font.BOLD, 16));
		t1.setBounds(12, 80, 684, 29);

		t2 = new JLabel("Kneipen_Nr:");
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t2.setBounds(12, 141, 97, 29);
		frame.getContentPane().add(t2);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1445, 143, 276, 342);
		frame.getContentPane().add(scrollPane_1);

		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);

		BarNR = new JTextField();
		BarNR.setEditable(false);
		BarNR.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		BarNR.setBounds(155, 137, 303, 37);
		frame.getContentPane().add(BarNR);
		BarNR.setColumns(10);
		t3 = new JLabel("Name:");
		t3.setForeground(Color.BLUE);
		t3.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t3.setBounds(12, 191, 114, 29);
		frame.getContentPane().add(t3);


		barnr0 = new JTextField();
		barnr0.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		barnr0.setBounds(765, 134, 379, 38);
		frame.getContentPane().add(barnr0);
		barnr0.setColumns(10);
		epwd = new JTextField();
		epwd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		epwd.setBounds(765, 196, 379, 38);
		frame.getContentPane().add(epwd);
		epwd.setColumns(10);





		pwd01 = new JButton("Password Vergessen??");
		pwd01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				int YesorNo = JOptionPane.showConfirmDialog(null, "Haben sie Ihren Password vergessen !!!!!","PWD Ändern",JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){


					DB_Anfragen.Select_BarNr(Name.getText(), tz);

					long tz1 =Long.parseLong(tz.getText());


					if(tz1==0){

						JOptionPane.showMessageDialog(null,"Benutzer Name ist ungültig");



					}else{


						BarNR.setText(tz.getText()) ;
						t1.setText("Password Vergessen !!!! Dann bitte dieses Formular ausfüllen :");
						Var=66;
						pwd.setText("Password:");
						Benutzer.setText("Benutzer_Name:");
						ja.setSelected(false);
						Account.setVisible(false);
						ja.setVisible(false);
						nein.setVisible(false);
						pwd1.setVisible(true);
						Benutzer.setVisible(false);
						pwd.setVisible(false);
						Name.setVisible(false);
						pass.setVisible(false);
						exit.setVisible(false);
						login.setVisible(false);
						pwd1.setVisible(false);
						t1.setVisible(true);
						t001.setVisible(false);
						barnr0.setVisible(false);
						t01.setVisible(false);
						epwd.setVisible(false);
						///

						pwd01.setVisible(false);
						btnRegi.setVisible(true);
						aktu.setVisible(true);
						quit.setVisible(true);
						msg.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						t4.setVisible(true);
						t5.setVisible(true);
						t6.setVisible(true);
						t6.setVisible(true);
						t7.setVisible(true);
						t8.setVisible(true);
						t9.setVisible(true);
						t10.setVisible(true);
						t11.setVisible(true);
						name.setVisible(true);
						vorname.setVisible(true);
						strasse.setVisible(true);
						stadt.setVisible(true);
						plz.setVisible(true);
						tel.setVisible(true);
						email.setVisible(true);
						bname.setVisible(true);
						BarNR.setVisible(true);
						scrollPane.setVisible(true);

						barnr0.setText("");
						epwd.setText("");
						Name.setText("");
						pass.setText("");

						btnRegi.setText("Neue Password");

						msg.setText("Ich habe mein Password vergessen ");
						msg.setEditable(false);
						///
						///


					}

				}





			}
		});
		pwd01.setBackground(Color.DARK_GRAY);
		pwd01.setForeground(Color.RED);
		pwd01.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		pwd01.setBounds(966, 441, 178, 44);
		frame.getContentPane().add(pwd01);

		t001 = new JLabel("Kneipen_Nr:");
		t001.setForeground(Color.RED);
		t001.setFont(new Font("Traditional Arabic", Font.BOLD, 19));
		t001.setBounds(554, 137, 176, 35);
		frame.getContentPane().add(t001);

		name = new JTextField();
		name.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		name.setColumns(10);
		name.setBounds(155, 187, 303, 37);
		frame.getContentPane().add(name);
		t01 = new JLabel("Ehemalige_Password:");
		t01.setForeground(Color.RED);
		t01.setFont(new Font("Traditional Arabic", Font.BOLD, 19));
		t01.setBounds(554, 202, 189, 29);
		frame.getContentPane().add(t01);
		tz = new JLabel("0");
		tz.setBounds(470, 387, 21, 16);
		frame.getContentPane().add(tz);
		t4 = new JLabel("Vorname:");
		t4.setForeground(Color.BLUE);
		t4.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t4.setBounds(12, 241, 135, 29);
		frame.getContentPane().add(t4);
		aktu = new JButton("Aktualisieren");
		aktu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BarNR.setText("");
				name.setText("");
				vorname.setText("");
				strasse.setText("");
				stadt.setText("");
				plz.setText("");
				tel.setText("");
				email.setText("");
				bname.setText("");
				msg.setText("");
			}
		});
		aktu.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		aktu.setBounds(308, 633, 151, 29);
		frame.getContentPane().add(aktu);

		quit = new JButton("Exit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				int YesorNo = JOptionPane.showConfirmDialog(null, "Wollen sie das AnmeldeFormular verlassen!!!!!","Anmelden",JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){
					Var=0;
					btnRegi.setText("Registrieren");
					msg.setText("");
					msg.setEditable(true);
					t1.setText("Bitte fühlen sie Sorgfälltig dieses Anmelderformular Vielen DANK :)");
					t01.setVisible(false);
					epwd.setVisible(false);
					t1.setVisible(false);
					btnRegi.setVisible(false);
					aktu.setVisible(false);
					quit.setVisible(false);
					msg.setVisible(false);
					t2.setVisible(false);
					t3.setVisible(false);
					t4.setVisible(false);
					t5.setVisible(false);
					t6.setVisible(false);
					t6.setVisible(false);
					t7.setVisible(false);
					t8.setVisible(false);
					t9.setVisible(false);
					t10.setVisible(false);
					t11.setVisible(false);
					name.setVisible(false);
					vorname.setVisible(false);
					strasse.setVisible(false);
					stadt.setVisible(false);
					plz.setVisible(false);
					tel.setVisible(false);
					email.setVisible(false);
					bname.setVisible(false);
					BarNR.setVisible(false);
					scrollPane.setVisible(false);
					pwd.setText("Password:");
					Benutzer.setText("Benutzer_Name:");
					nein.setSelected(false);
					login.setText("Anmelden");
					Benutzer.setVisible(false);
					pwd.setVisible(false);
					Name.setVisible(false);
					pass.setVisible(false);
					exit.setVisible(false);
					login.setVisible(false);
					Account.setVisible(true);
					ja.setVisible(true);
					nein.setVisible(true);
					pwd1.setVisible(false);
					t1.setVisible(false);
					pwd1.setVisible(false);
					t001.setVisible(false);
					barnr0.setVisible(false);
					pwd01.setVisible(false);
					login.setText("Anmelden");

					b1.setVisible(true);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				else{

				}
			}
		});
		quit.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		quit.setBounds(155, 633, 151, 29);
		frame.getContentPane().add(quit);

		btnRegi = new JButton("Registrieren");
		btnRegi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Var==0){
					try {

						long Bar_Nummer =Long.parseLong(BarNR.getText());
						long Bar_PLZ =Long.parseLong(plz.getText());
						long Bar_tel =Long.parseLong(tel.getText());
						int Note=1;
						long  PWD = Bar_PLZ+100000;


						DB_Anfragen.Bar_Registration(name.getText(),vorname.getText(),strasse.getText(),stadt.getText(),Bar_PLZ,Bar_tel,email.getText(),bname.getText(),msg.getText(),Note,PWD);


						ta.setText("");
						ta.append("\t\t Bar_Registration: \n\n"+"Kneipe_Nr:\t"+BarNR.getText()+"\n============================================================================\n"+"Name:\t"+name.getText()+"\n\n"+"Vorname:\t"+vorname.getText()+"\n"+"\n\n============================================================================\n"+
								" "+"Straße:\t"+BarNR.getText()+"\n\n"+"PLZ:\t"+plz.getText()+"\n\n"+"Stadt:\t"+stadt.getText()+"\n\n"+"\n============================================================================\n"+tel.getText()+"\n\n"+email.getText()+"\n"+"\n============================================================================\n"+"Benutzer_Name:\t"+bname.getText()+"\n"+"Password:\t"+"\n\n"+PWD+"\n============================================================================\n"+Zeit.getText()+"\n============================================================================\n");

						BarNR.setText("");
						name.setText("");
						vorname.setText("");
						strasse.setText("");
						stadt.setText("");
						plz.setText("");
						tel.setText("");
						email.setText("");
						bname.setText("");
						msg.setText("");

						ta.print();


						Var=0;
						btnRegi.setText("Registrieren");
						msg.setText("");
						msg.setEditable(true);
						t1.setText("Bitte fühlen sie Sorgfälltig dieses Anmelderformular Vielen DANK :)");
						t01.setVisible(false);
						epwd.setVisible(false);
						t1.setVisible(false);
						btnRegi.setVisible(false);
						aktu.setVisible(false);
						quit.setVisible(false);
						msg.setVisible(false);
						t2.setVisible(false);
						t3.setVisible(false);
						t4.setVisible(false);
						t5.setVisible(false);
						t6.setVisible(false);
						t6.setVisible(false);
						t7.setVisible(false);
						t8.setVisible(false);
						t9.setVisible(false);
						t10.setVisible(false);
						t11.setVisible(false);
						name.setVisible(false);
						vorname.setVisible(false);
						strasse.setVisible(false);
						stadt.setVisible(false);
						plz.setVisible(false);
						tel.setVisible(false);
						email.setVisible(false);
						bname.setVisible(false);
						BarNR.setVisible(false);
						scrollPane.setVisible(false);
						pwd.setText("Password:");
						Benutzer.setText("Benutzer_Name:");
						nein.setSelected(false);
						login.setText("Anmelden");
						Benutzer.setVisible(false);
						pwd.setVisible(false);
						Name.setVisible(false);
						pass.setVisible(false);
						exit.setVisible(false);
						login.setVisible(false);
						Account.setVisible(true);
						ja.setVisible(true);
						nein.setVisible(true);
						pwd1.setVisible(false);
						t1.setVisible(false);
						pwd1.setVisible(false);
						t001.setVisible(false);
						barnr0.setVisible(false);
						pwd01.setVisible(false);
						login.setText("Anmelden");


						b2.setVisible(true);
						b1.setVisible(false);
						b3.setVisible(false);

					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null,"Bitte Gültige Anträger eingeben");

					}










				}
				if(Var==66)	{



					//////////Prüfen ob Die Angegeben Daten Richtig sind
					///// Dann neue Pssword ausdrucken
					DB_Anfragen.Passwort_Neu(email.getText(),pasw);

					try{

						long z =Long.parseLong(BarNR.getText());
						long z1 =Long.parseLong(pasw.getText());

						if(z==z1){

							long x= (z+z1 )*964;


							DB_Anfragen.Update_Pass_Neu(x, z);
							ta.setText("");
							ta.append("\t\t Password_Ersetzer: \n\n"+"Kneipe_Nr:\t"+BarNR.getText()+"\n============================================================================\n"+"Name:\t"+name.getText()+"\n\n"+"Vorname:\t"+vorname.getText()+"\n"+"\n\n============================================================================\n"+
									" "+"Straße:\t"+BarNR.getText()+"\n\n"+"PLZ:\t"+plz.getText()+"\n\n"+"Stadt:\t"+stadt.getText()+"\n\n"+"\n============================================================================\n"+tel.getText()+"\n\n"+email.getText()+"\n"+"\n============================================================================\n"+"Benutzer_Name:\t"+bname.getText()+"\n"+"Password:\t"+"\n\n"+x+"\n============================================================================\n"+Zeit.getText()+"\n============================================================================\n");

							BarNR.setText("");
							name.setText("");
							vorname.setText("");
							strasse.setText("");
							stadt.setText("");
							plz.setText("");
							tel.setText("");
							email.setText("");
							bname.setText("");
							msg.setText("");
							Var=0;
							///


							btnRegi.setVisible(false);
							aktu.setVisible(false);
							quit.setVisible(false);
							msg.setVisible(false);
							t2.setVisible(false);
							t3.setVisible(false);
							t4.setVisible(false);
							t5.setVisible(false);
							t6.setVisible(false);
							t6.setVisible(false);
							t7.setVisible(false);
							t8.setVisible(false);
							t9.setVisible(false);
							t10.setVisible(false);
							t11.setVisible(false);
							t1.setVisible(false);
							name.setVisible(false);
							vorname.setVisible(false);
							strasse.setVisible(false);
							stadt.setVisible(false);
							plz.setVisible(false);
							tel.setVisible(false);
							email.setVisible(false);
							bname.setVisible(false);
							BarNR.setVisible(false);
							scrollPane.setVisible(false);
							pwd.setText("Password:");
							Benutzer.setText("Benutzer_Name:");

							login.setText("Anmelden");




							////
							btnRegi.setText("Registrieren");
							ta.print();

							pwd.setText("Password:");
							Benutzer.setText("Benutzer_Name:");
							nein.setSelected(false);
							t01.setVisible(false);
							epwd.setVisible(false);
							Benutzer.setVisible(true);
							pwd.setVisible(true);
							Name.setVisible(true);
							pass.setVisible(true);
							exit.setVisible(true);
							login.setVisible(true);
							Account.setVisible(false);
							ja.setVisible(false);
							nein.setVisible(false);
							pwd1.setVisible(true);
							t1.setVisible(false);
							t001.setVisible(false);
							barnr0.setVisible(false);
							login.setText("Anmelden");
							pwd01.setVisible(true);
							barnr0.setText("");
							epwd.setText("");
							pass.setText("");
							Name.setText("");
							b1.setVisible(true);
							b2.setVisible(false);
							b3.setVisible(false);
						}


					}catch(Exception ee){

					}




				}

			}
		});

		btnRegi.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		btnRegi.setBounds(155, 675, 303, 38);
		frame.getContentPane().add(btnRegi);

		vorname = new JTextField();
		vorname.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		vorname.setColumns(10);
		vorname.setBounds(155, 237, 303, 37);
		frame.getContentPane().add(vorname);

		t5 = new JLabel("Straße:");
		t5.setForeground(Color.BLUE);
		t5.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t5.setBounds(12, 291, 135, 29);
		frame.getContentPane().add(t5);

		t8 = new JLabel("Telefon_Nr:");
		t8.setForeground(Color.BLUE);
		t8.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t8.setBounds(12, 391, 135, 29);
		frame.getContentPane().add(t8);


		pub = new JLabel("");
		pub.setBounds(554, 542, 56, 16);
		frame.getContentPane().add(pub);



		tel = new JTextField();
		tel.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		tel.setColumns(10);
		tel.setBounds(155, 387, 303, 37);
		frame.getContentPane().add(tel);

		strasse = new JTextField();
		strasse.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		strasse.setColumns(10);
		strasse.setBounds(155, 287, 303, 37);
		frame.getContentPane().add(strasse);
		psp = new JLabel("");
		psp.setBounds(640, 496, 56, 16);
		frame.getContentPane().add(psp);

		t6 = new JLabel("Stadt:");
		t6.setForeground(Color.BLUE);
		t6.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t6.setBounds(74, 336, 75, 29);
		frame.getContentPane().add(t6);

		stadt = new JTextField();
		stadt.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		stadt.setColumns(10);
		stadt.setBounds(165, 337, 114, 37);
		frame.getContentPane().add(stadt);

		t7 = new JLabel("PLZ:");
		t7.setForeground(new Color(0, 0, 255));
		t7.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t7.setBounds(295, 337, 37, 29);
		frame.getContentPane().add(t7);

		t9 = new JLabel("Email:");
		t9.setForeground(Color.BLUE);
		t9.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t9.setBounds(12, 441, 135, 29);
		frame.getContentPane().add(t9);

		email = new JTextField();
		email.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		email.setColumns(10);
		email.setBounds(155, 437, 303, 37);
		frame.getContentPane().add(email);


		plz = new JTextField();
		plz.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		plz.setColumns(10);
		plz.setBounds(344, 337, 114, 37);
		frame.getContentPane().add(plz);

		t10 = new JLabel("Name_Kneipe:");
		t10.setForeground(Color.BLUE);
		t10.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t10.setBounds(12, 491, 135, 29);
		frame.getContentPane().add(t10);


		ppwd = new JLabel("");
		ppwd.setBounds(554, 377, 56, 16);
		frame.getContentPane().add(ppwd);
		test22 = new JTextField();
		test22.setText("0");
		test22.setBounds(470, 338, 21, 22);
		frame.getContentPane().add(test22);
		test22.setColumns(10);

		bname = new JTextField();
		bname.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		bname.setColumns(10);
		bname.setBounds(155, 487, 303, 37);
		frame.getContentPane().add(bname);
		test = new JLabel("");
		test.setBounds(554, 454, 56, 16);
		frame.getContentPane().add(test);
		pasw = new JLabel("");
		pasw.setBounds(554, 638, 56, 16);
		frame.getContentPane().add(pasw);
		labelname = new JLabel("");
		labelname.setBounds(554, 419, 56, 16);
		frame.getContentPane().add(labelname);

		t11 = new JLabel("Nachricht:");
		t11.setForeground(Color.BLUE);
		t11.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		t11.setBounds(12, 537, 135, 29);
		frame.getContentPane().add(t11);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 537, 301, 83);
		frame.getContentPane().add(scrollPane);

		bar = new JLabel("");
		bar.setBounds(554, 496, 56, 16);
		frame.getContentPane().add(bar);
		msg = new JTextArea();
		scrollPane.setViewportView(msg);
		msg.setFont(new Font("Arial", Font.BOLD, 14));


		Zeit = new JLabel("New label");
		Zeit.setBounds(1614, 33, 88, 23);
		frame.getContentPane().add(Zeit);


		frame.getContentPane().add(t1);
		pass = new JPasswordField();
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pass.setBounds(765, 329, 379, 38);
		frame.getContentPane().add(pass);




		pwd1 = new JButton("Password Ändern??");
		pwd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int YesorNo = JOptionPane.showConfirmDialog(null, "Wollen sie ihre Password ändern!!!!!","PWD Ändern",JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){


					DB_Anfragen.Select_BarNr1(Name.getText(),test22);

					int test221 = Integer.parseInt(test22.getText());

					if(test221==0){
						JOptionPane.showMessageDialog(null,"Sie müssen ID eingeben (ZB: Email_Adresse)");
					}else{

						barnr0.setText(test22.getText());
						barnr0.setEditable(false);

						DB_Anfragen.Select_Password_Bar_Nr(barnr0.getText(),psp);
						epwd.setText("000000");
						Name.setText("00000");
						pass.setText("00000");
						Var=55;

						t001.setVisible(true);
						barnr0.setVisible(true);
						t01.setVisible(true);
						epwd.setVisible(true);
						Benutzer.setText("Neue Password:");
						pwd.setText("Bestätigen:");
						login.setText("Ändern");
						pwd1.setVisible(false);

						pwd01.setVisible(false);
					}

				}

			}
		});
		pwd1.setBackground(Color.DARK_GRAY);
		pwd1.setForeground(new Color(255, 0, 0));
		pwd1.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		pwd1.setBounds(765, 441, 176, 44);
		frame.getContentPane().add(pwd1);
		login = new JButton("Anmelden");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Var==0){


					try {


						DB_Anfragen.Login(Name.getText(),ppwd,P1,labelname);


						try{

							int Pass1 =Integer.parseInt(pass.getText());
							int Pass2= Integer.parseInt(ppwd.getText());
							if(Pass1==Pass2){


								DB_Anfragen.PWD_Update1(Name.getText(),ppwd,P2);

								int Note1= Integer.parseInt(ppwd.getText());
								if(Note1==1){


									int YesorNo = JOptionPane.showConfirmDialog(null, "Achtung sie haben ihren Password noch nicht geändert , Wollen sie es jetzt Ändern!!!!!","PWD Ändern",JOptionPane.YES_NO_OPTION);

									if(YesorNo==0){

										t001.setVisible(true);
										barnr0.setVisible(true);
										t01.setVisible(true);
										epwd.setVisible(true);
										Benutzer.setText("Neue Password:");
										pwd.setText("Bestätigen:");
										login.setText("Ändern");
										pwd1.setVisible(false);
										Name.setText("");
										pass.setText("");
										pwd01.setVisible(false);

										barnr0.setText("0000000");
										epwd.setText("0000000");
										Name.setText("0000000");
										pass.setText("0000000");
										Var=2;
									}else{


										DB_Anfragen.Select_BarNr(Name.getText(), bar);
										pub.setText(Name.getText());

										Kneipen_Besitzer KB= new Kneipen_Besitzer();
										try {
											KB.NewScreen();
										} catch (ClassNotFoundException
												| InstantiationException
												| IllegalAccessException
												| UnsupportedLookAndFeelException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										frame.dispose();


									}


								}

								else  if (Note1==0){



									DB_Anfragen.Select_BarNr(Name.getText(), bar);
									pub.setText(Name.getText());

									Kneipen_Besitzer KB= new Kneipen_Besitzer();
									try {
										KB.NewScreen();
									} catch (ClassNotFoundException
											| InstantiationException
											| IllegalAccessException
											| UnsupportedLookAndFeelException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									frame.dispose();
								}}

							else{
								JOptionPane.showMessageDialog(null,"Ihre Password ist falsch");
							}


						}catch(Exception e3){
							JOptionPane.showMessageDialog(null,"Ungültiges Password");
						}






					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Nickname ist Falsch");

					}





				}

		 		/*
		 		if(Var==2){
		 			P3=0;
		 			if(epwd.getText()!="0000000" && Name.getText()!="0000000"&&barnr0.getText()!="0000000" && pass.getText()!="0000000"){




		 			try{


		 				int Pass10 =Integer.parseInt(epwd.getText());
		 				int Pass20= Integer.parseInt(Name.getText());
		 				int BarNummer= Integer.parseInt(barnr0.getText());
		 				int PassB=Integer.parseInt(pass.getText());

		 				try{

		 				if(PassB==Pass20){


		 					DB_Anfragen.Update_PWD(Pass10, Pass20, BarNummer, P3);




		 				}else{

		 					JOptionPane.showMessageDialog(null,"Bitte Bestätigen sie Ihren Password!!!!");



		 				}





		 				}catch(Exception e4){


		 					JOptionPane.showMessageDialog(null,"Password Kann nicht Akzeptiert werden , Prüfen sie ihre Angaben");



		 				}



		 			}catch (Exception e3) {
						JOptionPane.showMessageDialog(null,"Nickname und Oder Ehemaliges Password und Bar_Nr müssen Richtig sein ");

                    }}else{

                    }

		 			if(P3==5){





	 					Kneipen_Besitzer KB= new Kneipen_Besitzer();
						try {
							KB.NewScreen();
						} catch (ClassNotFoundException
								| InstantiationException
								| IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.dispose();





		 			}


		 		}

		 		*/


				if(Var==2){

					barnr0.setEditable(false);
					DB_Anfragen.Select_BarNr(Name.getText(), labelname);

					DB_Anfragen.Select_BarNr1(labelname.getText(), barnr0);


					Var=3;
				}



				if(Var==3){
					DB_Anfragen.Select_Password(labelname.getText(), test);


					float p1= Integer.parseInt(epwd.getText());

					float p2 = Integer.parseInt(test.getText());


					if(p1==p2){


						float p3= Integer.parseInt(Name.getText());

						float p4 = Integer.parseInt(pass.getText());

						if(p3==p4){

							////////  UPDATE_Password

							int BarNummer = Integer.parseInt(barnr0.getText());

							int NeuePass = Integer.parseInt(pass.getText());
							DB_Anfragen.Update_PWD(BarNummer, NeuePass);

							bar.setText(barnr0.getText());
							pub.setText(labelname.getText());
							Kneipen_Besitzer KB= new Kneipen_Besitzer();
							try {
								KB.NewScreen();
							} catch (ClassNotFoundException
									| InstantiationException
									| IllegalAccessException
									| UnsupportedLookAndFeelException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							frame.dispose();




						}else{


							JOptionPane.showMessageDialog(null,"Bestätigen Sie ihren Password Bitte !!! ");



						}

					}






				}


				if(Var==55)	{

					try{
						int N1= Integer.parseInt(epwd.getText());
						int N2 = Integer.parseInt(psp.getText());

						if(N1==N2){

							try{

								int N11= Integer.parseInt(Name.getText());
								int N22 = Integer.parseInt(pass.getText());

								if(N11 == N22){
									int N111= Integer.parseInt(barnr0.getText());

									DB_Anfragen.Update_PWD(N111, N22);

									ta.setText("");

									ta.append("\t\t Password_Ändern: \n\n"+"Kneipe_Nr:\t"+barnr0.getText()+"\n============================================================================\n"+"\n\n============================================================================\n"+
											" "+"Neue_Password:\t"+pass.getText()+"\n============================================================================\n"+Zeit.getText()+"\n============================================================================\n");

									ta.print();

									barnr0.setText("");
									Name.setText("");
									pass.setText("");
									epwd.setText("");
									Var=0;

									Benutzer.setText("Benutzer_Name:");
									pwd.setText("Password:");
									login.setText("Anmelden");
									pwd1.setVisible(true);
									pwd01.setVisible(true);
									barnr0.setVisible(false);
									t001.setVisible(false);
									epwd.setVisible(false);
									t01.setVisible(false);

								}else{


									JOptionPane.showMessageDialog(null,"Bitte Bestätigen sie Ihren Password !!! ");


								}

							}catch(Exception e55)	{


								JOptionPane.showMessageDialog(null,"Ihre Neue Password kann nicht Akzeptiert werden bitte nur Zahlen Verwenden !!! ");


							}




						}else{
							JOptionPane.showMessageDialog(null,"Ihre Password ist Falsch !!! ");
						}




					}catch(Exception e55)	{


						JOptionPane.showMessageDialog(null,"Ihre Password ist Falsch !!! ");


					}



				}



			}
		});
		login.setFont(new Font("Traditional Arabic", Font.BOLD, 13));
		login.setBounds(966, 386, 178, 38);
		frame.getContentPane().add(login);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				int YesorNo = JOptionPane.showConfirmDialog(null, "Wollen sie diese Seite Verlassen!!!!!","PWD Ändern",JOptionPane.YES_NO_OPTION);

				if(YesorNo==0){

					b2.setVisible(false);
					b1.setVisible(true);
					pass.setText("");
					Name.setText("");
					epwd.setText("");
					barnr0.setText("");
					Var=0;
					pwd.setText("Password:");
					Benutzer.setText("Benutzer_Name:");
					Benutzer.setVisible(false);
					pwd.setVisible(false);
					Name.setVisible(false);
					pass.setVisible(false);
					exit.setVisible(false);
					login.setVisible(false);
					Account.setVisible(true);
					ja.setVisible(true);
					nein.setVisible(true);
					ja.setSelected(false);
					nein.setSelected(false);
					t1.setVisible(false);
					pwd1.setVisible(false);
					t01.setVisible(false);
					epwd.setVisible(false);
					login.setText("Anmelden");
					t001.setVisible(false);
					barnr0.setVisible(false);
					pwd01.setVisible(false);
					Var=0;
				}

			}
		});
		exit.setFont(new Font("Traditional Arabic", Font.BOLD, 13));
		exit.setBounds(765, 386, 174, 38);
		frame.getContentPane().add(exit);

		Account = new JLabel("Haben sie einen Account ?");
		Account.setFont(new Font("Traditional Arabic", Font.BOLD, 22));
		Account.setBounds(524, 33, 303, 29);
		frame.getContentPane().add(Account);

		ja = new JRadioButton("Ja");
		ja.setBackground(Color.ORANGE);
		ja.setForeground(Color.BLACK);
		ja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pwd.setText("Password:");
				Benutzer.setText("Benutzer_Name:");
				nein.setSelected(false);
				t01.setVisible(false);
				epwd.setVisible(false);
				Benutzer.setVisible(true);
				pwd.setVisible(true);
				Name.setVisible(true);
				pass.setVisible(true);
				exit.setVisible(true);
				login.setVisible(true);
				Account.setVisible(false);
				ja.setVisible(false);
				nein.setVisible(false);
				pwd1.setVisible(true);
				t1.setVisible(false);
				t001.setVisible(false);
				barnr0.setVisible(false);
				login.setText("Anmelden");
				pwd01.setVisible(true);
				Var=0;
				b1.setVisible(false);
				b2.setVisible(true);
			}
		});
		ja.setFont(new Font("Traditional Arabic", Font.BOLD, 15));
		ja.setBounds(849, 37, 82, 25);
		frame.getContentPane().add(ja);

		nein = new JRadioButton("Nein");
		nein.setBackground(Color.ORANGE);
		nein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwd.setText("Password:");
				Benutzer.setText("Benutzer_Name:");
				ja.setSelected(false);
				Account.setVisible(false);
				ja.setVisible(false);
				nein.setVisible(false);
				pwd1.setVisible(true);
				Benutzer.setVisible(false);
				pwd.setVisible(false);
				Name.setVisible(false);
				pass.setVisible(false);
				exit.setVisible(false);
				login.setVisible(false);
				pwd1.setVisible(false);
				t1.setVisible(true);
				t001.setVisible(false);
				barnr0.setVisible(false);
				t01.setVisible(false);
				epwd.setVisible(false);
				///


				Var=0;
				pwd01.setVisible(false);
				btnRegi.setVisible(true);
				aktu.setVisible(true);
				quit.setVisible(true);
				msg.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				t6.setVisible(true);
				t6.setVisible(true);
				t7.setVisible(true);
				t8.setVisible(true);
				t9.setVisible(true);
				t10.setVisible(true);
				t11.setVisible(true);
				name.setVisible(true);
				vorname.setVisible(true);
				strasse.setVisible(true);
				stadt.setVisible(true);
				plz.setVisible(true);
				tel.setVisible(true);
				email.setVisible(true);
				bname.setVisible(true);
				BarNR.setVisible(true);
				scrollPane.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				DB_Anfragen.Max_BarNR(BarNR);
				int N41= Integer.parseInt(BarNR.getText());
				int N42 = N41+1;

				BarNR.setText(String.valueOf(N42));



				///
			}
		});
		nein.setFont(new Font("Traditional Arabic", Font.BOLD, 15));
		nein.setBounds(947, 37, 82, 25);
		frame.getContentPane().add(nein);

		b1 = new JLabel("New label");
		b1.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\image_content_828136805_20180122145147.jpg"));
		b1.setBounds(0, 0, 1755, 789);
		frame.getContentPane().add(b1);


		b2 = new JLabel("");
		b2.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\krombacher-spot-mood-flaschen.jpg"));
		b2.setBounds(0, 0, 1755, 789);
		frame.getContentPane().add(b2);



		b3 = new JLabel("");
		b3.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\Krombacher-kuendigt-Preiserhoehung-an_big_teaser_article.jpg"));
		b3.setBounds(0, 0, 1755, 789);
		frame.getContentPane().add(b3);


	}
}
