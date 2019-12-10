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
import javax.swing.ImageIcon;


public class Quiz_Terminer {

    private JFrame frame;
    private static JTextField tname;
    private static JTextField tnummer;
    private JTextField t1;
    private static JComboBox CB1;
    private static JLabel lblNewLabel;
    private JTextArea ta;
    /**
     * Launch the application.
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
                    Quiz_Terminer window = new Quiz_Terminer();
                    window.frame.setVisible(true);



                    tname.setText(Kneipen_Besitzer.txtkneipexxxy.getText());
                    tnummer.setText(Kneipen_Besitzer.ff.getText());

                    try{
                        String query2="select Spiel_Nummer from Spiel_Gnehmigt WHERE status =1 and Bar_Nr='"+tnummer.getText()+"'";
                        PreparedStatement pst1=con.prepareStatement(query2);

                        ResultSet rs= pst1.executeQuery();
                        CB1.removeAllItems();
                        while (rs.next()){
                            String Spiel_Nummer = rs.getString("Spiel_Nummer");
                            CB1.addItem(Spiel_Nummer);
                        }

                        rs.close();

                    }
                    catch(Exception e2){
                        e2.printStackTrace();

                    }


                    try{


                        String query2="select max(ID_Nummer )from Kunde_Spiel ";
                        PreparedStatement pst1=con.prepareStatement(query2);

                        ResultSet rs= pst1.executeQuery();
                        //c1.removeAllItems();
                        while (rs.next()){


                            String ID_Nummer = rs.getString("max(ID_Nummer )");
                            lblNewLabel.setText(ID_Nummer);

                        }

                        rs.close();


                        int i2121 =Integer.parseInt(lblNewLabel.getText());
                        int s = i2121+12;
                        lblNewLabel.setText(String.valueOf(s));







                        JButton btnExit_1 = new JButton("Schließen");
                        btnExit_1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                            }
                        });









                    }
                    catch(Exception e2){
                        e2.printStackTrace();

                    }


                }





                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    static Connection con =null;
    private static JButton btnExit_2;
    private static JLabel lblNewLabel_1;
    public Quiz_Terminer() {
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

        tname = new JTextField();
        tname.setText("#KneipeXXXY");
        tname.setEditable(false);
        tname.setColumns(10);
        tname.setBounds(576, 39, 93, 22);
        frame.getContentPane().add(tname);

        tnummer = new JTextField();
        tnummer.setText("310514");
        tnummer.setEditable(false);
        tnummer.setColumns(10);
        tnummer.setBounds(681, 39, 68, 22);
        frame.getContentPane().add(tnummer);

        JLabel label = new JLabel("Kneipennummer:");
        label.setForeground(Color.RED);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        label.setBounds(581, 10, 168, 16);
        frame.getContentPane().add(label);

        JLabel lblLocalespielnr = new JLabel("Lokale SpielNr:");
        lblLocalespielnr.setForeground(Color.RED);
        lblLocalespielnr.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLocalespielnr.setBounds(12, 27, 125, 16);
        frame.getContentPane().add(lblLocalespielnr);

        CB1 = new JComboBox();
        CB1.setFont(new Font("Tahoma", Font.BOLD, 13));
        CB1.setBounds(149, 25, 149, 22);
        frame.getContentPane().add(CB1);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.RED);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmail.setBounds(12, 116, 56, 16);
        frame.getContentPane().add(lblEmail);

        t1 = new JTextField();
        t1.setText("0000");
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setBounds(101, 114, 197, 22);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        JButton btnExit = new JButton("Anmelden");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                con = DataBaseConnector.dbConnectorMariaDB();
                //con=Database.dbConnector();

                try{


                    String sql2 = "insert into Kunde_Spiel (Kunden_Nr,Spiel_Nr,ID_Nummer,Vermerk,Punkte,Bar_Nr)values (?,?,?,?,?,?)";
                    PreparedStatement pst=con.prepareStatement(sql2);
                    pst.setString(1, t1.getText());
                    pst.setString(2, CB1.getSelectedItem().toString());
                    pst.setString(3, lblNewLabel.getText());
                    pst.setString(4,"1");
                    pst.setString(5,"0");
                    pst.setString(6, tnummer.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Für den Spiel '"+CB1.getSelectedItem().toString()+"' erfolgreich angemeldet ");



                    ta.append("\t Anmeldung_Spiel: \n\n"+"Spiel_Nr: "+CB1.getSelectedItem().toString()+"\n======================================\n"+"\n======================================\n"+"Zugang_Daten :\t"+lblNewLabel.getText()+"\n\n"+
                            " \t"+" \n======================================\n"+" \n======================================\n"+" \n Wichtig!! Die Zugangsnummer aufbewahren\n");





                }
                catch(Exception e11){
                    //e11.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Anmeldung Unmöglich !!!");
                }

            }
        });
        btnExit.setForeground(Color.ORANGE);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit.setBounds(596, 125, 153, 31);
        frame.getContentPane().add(btnExit);

        JButton btnPrint = new JButton("Drucken");
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    ta.print();
                } catch (PrinterException e) {
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
        ta.setEditable(false);
        scrollPane.setViewportView(ta);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(264, 236, 56, 16);
        frame.getContentPane().add(lblNewLabel);
        lblNewLabel.setVisible(false);


        btnExit_2 = new JButton("Schließen");
        btnExit_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnExit_2.setForeground(Color.ORANGE);
        btnExit_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit_2.setBounds(596, 168, 153, 31);
        frame.getContentPane().add(btnExit_2);
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("Ressources/download Krombacher Hintergrundbild 1024x768-1.jpg"));
        lblNewLabel_1.setBounds(0, 0, 773, 265);
        frame.getContentPane().add(lblNewLabel_1);

    }
}
