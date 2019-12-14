package UILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIMainMenu {

    private JFrame frame;
    private  static  JTable table;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    UIMainMenu mainMenu = new UIMainMenu();
                    mainMenu.frame.setVisible(true);

                    //Tabelle füllen
                    // TODO DB_Anfragen.Table_Bar(table);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UIMainMenu() {
        initialize();
        frame.setResizable(false);
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1751, 768);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 459, 1696, 249);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton mangageQuestions = new JButton("Fragen verwalten");
        mangageQuestions.setForeground(Color.BLACK);
        mangageQuestions.setBackground(Color.WHITE);
        mangageQuestions.setFont(new Font("Tahoma", Font.BOLD, 17));
        mangageQuestions.setBounds(25, 127, 291, 51);
        frame.getContentPane().add(mangageQuestions);
        mangageQuestions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    UIQuestions.main(null);
                } catch (ClassNotFoundException
                        | UnsupportedLookAndFeelException
                        | InstantiationException
                        | IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });

        JButton statsButton = new JButton("Statistiken");
        statsButton.setForeground(Color.BLACK);
        statsButton.setBackground(Color.WHITE);
        statsButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        statsButton.setBounds(25, 207, 291, 51);
        frame.getContentPane().add(statsButton);
        statsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                //frame.dispose();

            }
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        logoutButton.setBounds(25, 286, 291, 51);
        frame.getContentPane().add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {


                frame.dispose();
            }
        });

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Ressources/image_content_828136805_20180122145147.jpg"));
        background.setBounds(0, 0, 1733, 721);
        frame.getContentPane().add(background);
    }
}