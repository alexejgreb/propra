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

import javax.swing.JRadioButton;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import Old.DB_Anfragen;


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
private static JLabel ppwd;
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
				pwd.setText("Password:");
				Benutzer.setText("Benutzer_Name:");
				
			
			
			
			
				
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
					
					ppwd.setVisible(false);
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
		Benutzer.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		Benutzer.setBounds(554, 265, 176, 29);
		frame.getContentPane().add(Benutzer);
		
		 pwd = new JLabel("Password:");
		pwd.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		pwd.setBounds(554, 335, 176, 29);
		frame.getContentPane().add(pwd);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Name.setBounds(765, 259, 379, 38);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		t1 = new JLabel("Bitte fühlen sie Sorgfälltig dieses Anmelderformular \r\nVielen DANK :)");
		t1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		t1.setBounds(12, 80, 446, 29);
		
		t2 = new JLabel("Kneipen_Nr:");
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t2.setBounds(12, 141, 97, 29);
		frame.getContentPane().add(t2);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1445, 143, 276, 342);
		frame.getContentPane().add(scrollPane_1);
		
		ta = new JTextArea();
		scrollPane_1.setViewportView(ta);
		
		BarNR = new JTextField();
		BarNR.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		BarNR.setBounds(155, 137, 303, 37);
		frame.getContentPane().add(BarNR);
		BarNR.setColumns(10);
		t3 = new JLabel("Name:");
		t3.setForeground(Color.BLUE);
		t3.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
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
			}
		});
		pwd01.setBackground(Color.DARK_GRAY);
		pwd01.setForeground(Color.RED);
		pwd01.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		pwd01.setBounds(966, 441, 178, 44);
		frame.getContentPane().add(pwd01);
		
		t001 = new JLabel("Kneipen_Nr:");
		t001.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		t001.setBounds(554, 137, 176, 35);
		frame.getContentPane().add(t001);
		
		name = new JTextField();
		name.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		name.setColumns(10);
		name.setBounds(155, 187, 303, 37);
		frame.getContentPane().add(name);
		t01 = new JLabel("Ehemalige_Password:");
		t01.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		t01.setBounds(554, 202, 189, 29);
		frame.getContentPane().add(t01);

		t4 = new JLabel("Vorname:");
		t4.setForeground(Color.BLUE);
		t4.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
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
				
				
				try {
					
					long Bar_Nummer =Long.parseLong(BarNR.getText());
					long Bar_PLZ =Long.parseLong(plz.getText());	
					long Bar_tel =Long.parseLong(tel.getText());
	                int Note=1;
				long  PWD = Bar_PLZ+Bar_Nummer*2+100000;
				
				
				DB_Anfragen.Bar_Registration(Bar_Nummer,name.getText(),vorname.getText(),strasse.getText(),stadt.getText(),Bar_PLZ,Bar_tel,email.getText(),bname.getText(),msg.getText(),Note,PWD);
				

				
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
             	} 						
catch (Exception e1) {
						JOptionPane.showMessageDialog(null,"Bitte Gültige Anträger eingeben");
				
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
		t5.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t5.setBounds(12, 291, 135, 29);
		frame.getContentPane().add(t5);
		
		t8 = new JLabel("Telefon_Nr:");
		t8.setForeground(Color.BLUE);
		t8.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t8.setBounds(12, 391, 135, 29);
		frame.getContentPane().add(t8);
		
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
		
		t6 = new JLabel("Stadt:");
		t6.setForeground(Color.BLUE);
		t6.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t6.setBounds(112, 336, 37, 29);
		frame.getContentPane().add(t6);
		
		stadt = new JTextField();
		stadt.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		stadt.setColumns(10);
		stadt.setBounds(165, 337, 114, 37);
		frame.getContentPane().add(stadt);
		
		t7 = new JLabel("PLZ:");
		t7.setForeground(Color.BLUE);
		t7.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t7.setBounds(295, 337, 37, 29);
		frame.getContentPane().add(t7);

		t9 = new JLabel("Email:");
		t9.setForeground(Color.BLUE);
		t9.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
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

		t10 = new JLabel("Benutzer_Name:");
		t10.setForeground(Color.BLUE);
		t10.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t10.setBounds(12, 491, 135, 29);
		frame.getContentPane().add(t10);
		
		
		ppwd = new JLabel("");
		ppwd.setBounds(554, 377, 56, 16);
		frame.getContentPane().add(ppwd);
		
		
		bname = new JTextField();
		bname.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		bname.setColumns(10);
		bname.setBounds(155, 487, 303, 37);
		frame.getContentPane().add(bname);
		
		t11 = new JLabel("Nachricht:");
		t11.setForeground(Color.BLUE);
		t11.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		t11.setBounds(12, 537, 135, 29);
		frame.getContentPane().add(t11);
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(157, 537, 301, 83);
		 frame.getContentPane().add(scrollPane);
		
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
					  Var=1;
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
				
				  
				  }else{
					  
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
			 			
			 			
			 		DB_Anfragen.Login(Name.getText(),ppwd,P1);
			 			
			 			
			 			try{
			 				
			 				int Pass1 =Integer.parseInt(pass.getText());
			 				int Pass2= Integer.parseInt(ppwd.getText());
			 				if(Pass1==Pass2){
			 					
			 					
			 					DB_Anfragen.PWD_Update1(Name.getText(),ppwd,P2);
			 					
			 					int Note1= Integer.parseInt(ppwd.getText());
			 					if(Note1==1){
			 					

			 						  int YesorNo = JOptionPane.showConfirmDialog(null, "Achtung sie haben ihren Password noch nicht geändert , Wollen sie es jetzt Ändern!!!!!","PWD Ändern",JOptionPane.YES_NO_OPTION);
			 						
			 						  if(YesorNo==0){
			 							  Var=1;
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
			 					
			 					else{
			 					
			 						if(P1==20 && P2==10){
			 						
			 						
			 						
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
			 							JOptionPane.showMessageDialog(null,"Ungültiges Zugangsdaten	!!!");
		 							  }
								
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
		 	}
		 });
		login.setFont(new Font("Traditional Arabic", Font.BOLD, 13));
		login.setBounds(966, 386, 178, 38);
		frame.getContentPane().add(login);
		
		 exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		exit.setFont(new Font("Traditional Arabic", Font.BOLD, 13));
		exit.setBounds(765, 386, 174, 38);
		frame.getContentPane().add(exit);
		
		 Account = new JLabel("Haben sie einen Account ?");
		Account.setFont(new Font("Traditional Arabic", Font.BOLD, 22));
		Account.setBounds(522, 33, 303, 29);
		frame.getContentPane().add(Account);
		
		ja = new JRadioButton("Ja");
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
			}
		});
		ja.setFont(new Font("Traditional Arabic", Font.BOLD, 15));
		ja.setBounds(846, 37, 60, 25);
		frame.getContentPane().add(ja);
		
		 nein = new JRadioButton("Nein");
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
		 		
		 		
		 		///
		 	}
		 });
		nein.setFont(new Font("Traditional Arabic", Font.BOLD, 15));
		nein.setBounds(947, 37, 60, 25);
		frame.getContentPane().add(nein);
		
		
		
	}
}
