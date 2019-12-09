package UILayer;

import DataLayer.DataBaseConnector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UIPlayerIDGenerator {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField t1;
    private static JComboBox CB1;
    private JLabel l5, l6, l1, l2, l3, l4;
    private static JLabel lblNewLabel;
    private JTextArea ta;

    /**
     * Launch the application.
     *
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIPlayerIDGenerator window = new UIPlayerIDGenerator();
                    window.frame.setVisible(true);


                    try {
                        String query2 = "select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1";
                        PreparedStatement pst1 = con.prepareStatement(query2);

                        ResultSet rs = pst1.executeQuery();
                        CB1.removeAllItems();
                        while (rs.next()) {
                            String Spiel_Nummer = rs.getString("Spiel_Nummer");
                            CB1.addItem(Spiel_Nummer);
                        }

                        rs.close();

                    } catch (Exception e2) {
                        e2.printStackTrace();

                    }


                    try {


                        String query2 = "select max (ID_Nummer )from Teilnehmer_Spiel ";
                        PreparedStatement pst1 = con.prepareStatement(query2);

                        ResultSet rs = pst1.executeQuery();
                        //c1.removeAllItems();
                        while (rs.next()) {


                            String ID_Nummer = rs.getString("max (ID_Nummer )");
                            lblNewLabel.setText(ID_Nummer);

                        }

                        rs.close();


                        int i2121 = Integer.parseInt(lblNewLabel.getText());
                        int s = i2121 + 12;
                        lblNewLabel.setText(String.valueOf(s));


                        JButton btnExit_1 = new JButton("EXIT");
                        btnExit_1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                            }
                        });


                    } catch (Exception e2) {
                        e2.printStackTrace();

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
    static Connection con = null;
    private static JButton btnExit_2;

    public UIPlayerIDGenerator() {
        initialize();

        con = DataBaseConnector.dbConnector();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 779, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setText("#KneipeXXXY");
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(576, 39, 93, 22);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setText("310514");
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(681, 39, 68, 22);
        frame.getContentPane().add(textField_1);

        JLabel label = new JLabel("Kneipe_Nummer:");
        label.setForeground(Color.RED);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        label.setBounds(581, 10, 168, 16);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("Spiel_Nummer:");
        label_1.setForeground(Color.RED);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label_1.setBounds(12, 27, 125, 16);
        frame.getContentPane().add(label_1);

        CB1 = new JComboBox();
        CB1.setFont(new Font("Tahoma", Font.BOLD, 13));
        CB1.setBounds(149, 25, 149, 22);
        frame.getContentPane().add(CB1);

        JLabel label_2 = new JLabel("Kunden-Mail:");
        label_2.setForeground(Color.RED);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label_2.setBounds(12, 70, 93, 16);
        frame.getContentPane().add(label_2);

        t1 = new JTextField();
        t1.setText("0000");
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setBounds(101, 68, 197, 22);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        /*l1 = new JLabel("NameKunde");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(12, 154, 93, 16);
        frame.getContentPane().add(l1);

        l2 = new JLabel("VornameKunde");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(173, 154, 125, 16);
        frame.getContentPane().add(l2);

        l3 = new JLabel("Geburtsdatum");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(12, 183, 103, 16);
        frame.getContentPane().add(l3);

        l4 = new JLabel("Adresse");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(139, 183, 174, 16);
        frame.getContentPane().add(l4);

        l6 = new JLabel("Email_Adresse");
        l6.setFont(new Font("Tahoma", Font.BOLD, 13));
        l6.setBounds(149, 212, 188, 16);
        frame.getContentPane().add(l6);

        l5 = new JLabel("Tele_Nummer");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(12, 212, 125, 16);
        frame.getContentPane().add(l5);
        */
        JButton button = new JButton("Suchen");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {


                int i2 = Integer.parseInt(t1.getText());
                if (i2 == 0) {
                    JOptionPane.showMessageDialog(null, "Bitte Kunden-Mail eingeben");
                } else {

                    try {     ///

                        String query = "select name , Vorname,adresse,email,Tel_Nr,Geburts from Kunden_Info where kundenNr=?";

                        PreparedStatement pst1 = con.prepareStatement(query);
                        pst1.setString(1, t1.getText());

                        ResultSet rs = pst1.executeQuery();

                        if ((rs.next())) {

                            l1.setText(rs.getString("name"));
                            l2.setText(rs.getString("Vorname"));
                            l4.setText(rs.getString("adresse"));
                            l6.setText(rs.getString("email"));
                            l5.setText(rs.getString("Tel_Nr"));
                            l3.setText(rs.getString("Geburts"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Bitte gültige Nummer eingeben");
                        }

                        pst1.close();


                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }


                }


            }
        });
        button.setForeground(Color.ORANGE);
        button.setFont(new Font("Tahoma", Font.BOLD, 18));
        button.setBounds(596, 81, 153, 31);
        frame.getContentPane().add(button);

        JButton btnExit = new JButton("Erstellen");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                con = DataBaseConnector.dbConnector();

                try {
                    String sql = "insert into Teilnehmer_Spiel (Spiel_NR,ID_Nummer)values (?,?)";
                    PreparedStatement pst1 = con.prepareStatement(sql);
                    pst1.setString(1, CB1.getSelectedItem().toString());
                    pst1.setString(2, lblNewLabel.getText());


                    pst1.execute();
                    JOptionPane.showMessageDialog(null, "ist erfolgreich zum Spiel  hinzugefügt");

                    String sql2 = "insert into Kunde_Spiel (Kunden_Nr,Spiel_Nr,ID_Nummer)values (?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql2);
                    pst.setString(1, t1.getText());
                    pst.setString(2, CB1.getSelectedItem().toString());
                    pst.setString(3, lblNewLabel.getText());


                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Für den Spiel '" + CB1.getSelectedItem().toString() + "' erfolgreich angemeldet ");


                    ta.append("\t Anmeldung_Spiel: \n\n" + "Spiel_Nr: " + CB1.getSelectedItem().toString() + "\n======================================\n" + "Kunden_Nummer:" + t1.getText() + "\n\n" + "Kunden_name:" + l1.getText() + "\n======================================\n" + "Kunden_Vorname:" + l2.getText() + "\n\n" + "Zugang_Daten :\t" + lblNewLabel.getText() + "\n\n" +
                            " \t" + " \n======================================\n" + " \n======================================\n" + " \n Wichtig!! Die Zugangsnummer aufbewahren\n");


                } catch (Exception e11) {
                    //e11.printStackTrace();
                    JOptionPane.showMessageDialog(null, e11);
                }
				/*
				try{
					String sql2 = "insert into Kunde_Spiel (Kunden_Nr,Spiel_Nr,ID_Nummer)values (?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql2);
					pst.setString(1, t1.getText());
					pst.setString(2, CB1.getSelectedItem().toString());
					pst.setString(3, lblNewLabel.getText());
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null,"Für den Spiel '"+CB1.getSelectedItem().toString()+"' erfolgreich angemeldet ");
					
					
					
					ta.append("\t Anmeldung_Spiel: \n\n"+"Spiel_Nr: "+CB1.getSelectedItem().toString()+"\n======================================\n"+"Kunden_Nummer:"+t1.getText()+"\n\n"+"Kunden_name:"+l1.getText()+"\n======================================\n"+"Kunden_Vorname:"+l2.getText()+"\n\n"+"Zugang_Daten :\t"+lblNewLabel.getText()+"\n\n"+
							" \t"+" \n======================================\n"+" \n======================================\n"+" \n Wichtig!! Die Zugangsnummer aufbewahren\n");
					
					
					
					
						}
						catch(Exception e111){
							//e111.printStackTrace();
							JOptionPane.showMessageDialog(null,e111);
						}
				
				
				*/
            }
        });
        btnExit.setForeground(Color.ORANGE);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit.setBounds(596, 125, 153, 31);
        frame.getContentPane().add(btnExit);

        JButton btnPrint = new JButton("Print");
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    ta.print();
                } catch (PrinterException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        btnPrint.setForeground(Color.ORANGE);
        btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPrint.setBounds(596, 209, 153, 31);
        frame.getContentPane().add(btnPrint);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(349, 8, 222, 232);
        frame.getContentPane().add(scrollPane);

        ta = new JTextArea();
        scrollPane.setViewportView(ta);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(12, 125, 56, 16);
        frame.getContentPane().add(lblNewLabel);
        lblNewLabel.setVisible(false);


        btnExit_2 = new JButton("EXIT");
        btnExit_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnExit_2.setForeground(Color.ORANGE);
        btnExit_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit_2.setBounds(596, 168, 153, 31);
        frame.getContentPane().add(btnExit_2);


    }
}
