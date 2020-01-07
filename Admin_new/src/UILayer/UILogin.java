package UILayer;

import DataLayer.DataBase;
import DataLayer.DataBaseConnector;
import LogicLayer.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UILogin {

    private JFrame frame;


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        DataBaseConnector.setServerAddress(args[0]);
        DataBaseConnector.setServerUsername(args[1]);
        DataBaseConnector.setServerPassword(args[2]);

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UILogin login = new UILogin();
                    login.frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UILogin() {
        initialize();
        frame.setResizable(false);
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1751, 768);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Benutzername:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        usernameLabel.setBounds(661, 267, 186, 32);
        frame.getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Passwort:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordLabel.setBounds(661, 335, 153, 32);
        frame.getContentPane().add(passwordLabel);

        JTextField adminField = new JTextField();
        adminField.setText("Admin");
        adminField.setFont(new Font("Tahoma", Font.BOLD, 15));
        adminField.setBounds(803, 264, 296, 40);
        frame.getContentPane().add(adminField);
        adminField.setColumns(10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBounds(805, 332, 294, 40);
        frame.getContentPane().add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginButton.setBounds(1012, 397, 87, 40);
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String tempPassword = passwordField.getText();
                DataBase db = new DataBase();
                if(db.adminLogin(adminField.getText(),passwordField.getText())) {
                    try {
                      //  Admin admin = new Admin(1,adminField.getText(),passwordField.getText(););
                        UIMainMenu.main(null);
                    } catch (ClassNotFoundException
                            | UnsupportedLookAndFeelException
                            | InstantiationException
                            | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();
                } else{
                    JOptionPane.showMessageDialog(null,"Falscher Benutzername oder Passwort");
                }
            }
        });

        JButton closeButton = new JButton("Schließen");
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        closeButton.setBounds(870, 397, 117, 40);
        frame.getContentPane().add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
            }
        });

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Ressources/image_content_828136805_20180122145147.jpg"));
        background.setBounds(0, 0, 1745, 733);
        frame.getContentPane().add(background);
    }
}
