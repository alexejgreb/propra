import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;


public class Kneipen {

    private JFrame frame;
    private static JTable table;
    private JLabel lblKneipenr;
    private JLabel lblBesitzer;
    private JLabel lblAdresse;
    private JLabel lblTelefon;
    private JLabel lblEmail;
    private JLabel lblKneipename;
    private JLabel lblNachricht;
    private static JComboBox nr;
    private JTextField besitzer;
    private JTextField adresse;
    private JTextField tel;
    private JTextField mail;
    private JTextField kneipe;
    private JTextArea msg;
    private JTextArea ta;
    private static JTextField name;
    private static JTextField vorname;
    private static JTextField strasse;
    private static JTextField city;
    private static JTextField post;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void NewScreen1()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {



        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kneipen window = new Kneipen();
                    window.frame.setVisible(true);
                    DB_Anfragen.Table_Bar_Reg(table);
                    DB_Anfragen.Bar_Nr_2(nr);
                    vorname.setVisible(false);
                    name.setVisible(false);
                    strasse.setVisible(false);
                    post.setVisible(false);
                    city.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Kneipen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1751, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(12, 476, 1709, 232);
        frame.getContentPane().add(scrollPane_1);

        table = new JTable();
        scrollPane_1.setViewportView(table);

        JButton btnSperren = new JButton("Sperren");
        btnSperren.setForeground(Color.RED);
        btnSperren.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnSperren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int YesorNo = JOptionPane.showConfirmDialog(null, "Wollen sie die Kneipe Nr: '"+nr.getSelectedItem().toString()+"' entfernen!!!!!","Bar_Delete",JOptionPane.YES_NO_OPTION);

                if(YesorNo==0){}


            }
        });
        btnSperren.setBounds(12, 52, 204, 46);
        frame.getContentPane().add(btnSperren);

        lblKneipenr = new JLabel("Kneipe_Nr:");
        lblKneipenr.setForeground(Color.RED);
        lblKneipenr.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblKneipenr.setBounds(278, 58, 106, 30);
        frame.getContentPane().add(lblKneipenr);

        lblBesitzer = new JLabel("Besitzer:");
        lblBesitzer.setForeground(Color.RED);
        lblBesitzer.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblBesitzer.setBounds(278, 101, 122, 30);
        frame.getContentPane().add(lblBesitzer);

        lblAdresse = new JLabel("Adresse:");
        lblAdresse.setForeground(Color.RED);
        lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblAdresse.setBounds(278, 161, 122, 30);
        frame.getContentPane().add(lblAdresse);

        lblTelefon = new JLabel("Telefon:");
        lblTelefon.setForeground(Color.RED);
        lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblTelefon.setBounds(278, 210, 122, 30);
        frame.getContentPane().add(lblTelefon);

        lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.RED);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblEmail.setBounds(278, 259, 122, 30);
        frame.getContentPane().add(lblEmail);

        lblKneipename = new JLabel("Kneipe_Name:");
        lblKneipename.setForeground(Color.RED);
        lblKneipename.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblKneipename.setBounds(278, 302, 142, 30);
        frame.getContentPane().add(lblKneipename);

        lblNachricht = new JLabel("Nachricht:");
        lblNachricht.setForeground(Color.RED);
        lblNachricht.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNachricht.setBounds(278, 381, 122, 30);
        frame.getContentPane().add(lblNachricht);

        nr = new JComboBox();
        nr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DB_Anfragen.Select_Bar_Info(name,vorname,strasse,city,post,tel,mail,kneipe,msg,nr);
                besitzer.setText(name.getText()+"   "+vorname.getText());
                adresse.setText(strasse.getText()+"     "+ post.getText()+"    "+city.getText());
            }
        });
        nr.setFont(new Font("Tahoma", Font.BOLD, 13));
        nr.setBounds(432, 64, 134, 22);
        frame.getContentPane().add(nr);

        besitzer = new JTextField();
        besitzer.setFont(new Font("Tahoma", Font.BOLD, 13));
        besitzer.setColumns(10);
        besitzer.setBounds(432, 105, 796, 36);
        frame.getContentPane().add(besitzer);

        adresse = new JTextField();
        adresse.setFont(new Font("Tahoma", Font.BOLD, 13));
        adresse.setColumns(10);
        adresse.setBounds(432, 154, 796, 36);
        frame.getContentPane().add(adresse);

        tel = new JTextField();
        tel.setFont(new Font("Tahoma", Font.BOLD, 13));
        tel.setColumns(10);
        tel.setBounds(432, 203, 796, 36);
        frame.getContentPane().add(tel);

        mail = new JTextField();
        mail.setFont(new Font("Tahoma", Font.BOLD, 13));
        mail.setColumns(10);
        mail.setBounds(432, 252, 796, 36);
        frame.getContentPane().add(mail);

        kneipe = new JTextField();
        kneipe.setFont(new Font("Tahoma", Font.BOLD, 13));
        kneipe.setColumns(10);
        kneipe.setBounds(432, 301, 796, 36);
        frame.getContentPane().add(kneipe);

        msg = new JTextArea();
        msg.setFont(new Font("Tahoma", Font.BOLD, 16));
        msg.setBounds(432, 350, 796, 112);
        frame.getContentPane().add(msg);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(1240, 58, 481, 353);
        frame.getContentPane().add(scrollPane);

        ta = new JTextArea();
        scrollPane.setViewportView(ta);

        JButton button = new JButton("Print");
        button.setForeground(Color.RED);
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.setBounds(1624, 433, 97, 30);
        frame.getContentPane().add(button);

        JButton btnNachrichtsenden = new JButton("Nachricht_Senden");
        btnNachrichtsenden.setForeground(Color.RED);
        btnNachrichtsenden.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNachrichtsenden.setBounds(12, 111, 204, 46);
        frame.getContentPane().add(btnNachrichtsenden);

        JButton btnLeeren = new JButton("Leeren");
        btnLeeren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                besitzer.setText("");
                adresse.setText("");
                msg.setText("");
                tel.setText("");
                mail.setText("");
                kneipe.setText("");
            }
        });
        btnLeeren.setForeground(Color.RED);
        btnLeeren.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnLeeren.setBounds(12, 180, 204, 46);
        frame.getContentPane().add(btnLeeren);

        JButton btnZurck = new JButton("Zurück");
        btnZurck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin ad= new Admin();
                try {
                    ad.NewScreen();
                } catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
        btnZurck.setForeground(Color.RED);
        btnZurck.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnZurck.setBounds(12, 252, 204, 46);
        frame.getContentPane().add(btnZurck);

        JButton btnPrint = new JButton("Print");
        btnPrint.setForeground(Color.RED);
        btnPrint.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnPrint.setBounds(12, 324, 204, 46);
        frame.getContentPane().add(btnPrint);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnExit.setForeground(Color.RED);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnExit.setBounds(12, 386, 204, 46);
        frame.getContentPane().add(btnExit);

        name = new JTextField();
        name.setBounds(432, 29, 116, 22);
        frame.getContentPane().add(name);
        name.setColumns(10);

        vorname = new JTextField();
        vorname.setColumns(10);
        vorname.setBounds(578, 66, 116, 22);
        frame.getContentPane().add(vorname);

        strasse = new JTextField();
        strasse.setColumns(10);
        strasse.setBounds(706, 66, 116, 22);
        frame.getContentPane().add(strasse);

        city = new JTextField();
        city.setColumns(10);
        city.setBounds(834, 66, 116, 22);
        frame.getContentPane().add(city);

        post = new JTextField();
        post.setColumns(10);
        post.setBounds(962, 66, 116, 22);
        frame.getContentPane().add(post);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Downloads\\2015-10-26_Krombacher Marke des Jahres (1).jpg"));
        lblNewLabel.setBounds(0, 0, 1733, 721);
        frame.getContentPane().add(lblNewLabel);
    }
}

