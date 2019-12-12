package UILayer;

import DataLayer.DataBaseConnector;
import LogicLayer.Login;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIFinishedGame extends JFrame {

    private JPanel contentPane;
    private JPanel northPanel;
    private JPanel southPanel;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        	//DataBaseConnector.setServerAddress(args[0]);
             //DataBaseConnector.setServerUsername(args[1]);
        	//DataBaseConnector.setServerPassword(args[2]);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIFinishedGame frame = new UIFinishedGame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UIFinishedGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //getContentPane().setLayout(null);


        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contentPane.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contentPane.add(southPanel,BorderLayout.SOUTH);

        JLabel lblHeader = new JLabel("Ergebnis");
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblHeader.setBounds(5, 5, 424, 14);
        northPanel.add(lblHeader);

        //Benutzername, bleibt leer wenn als Gast gespielt wird
        JLabel LabelUserName = new JLabel(""+ Login.guest.getUserName());
        LabelUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
        LabelUserName.setBounds(5, 64, 92, 14);
        contentPane.add(LabelUserName);

        //Spielnummer
        JLabel labelGameNr = new JLabel("Spiel Code: "+ Login.guest.getIDNumber());
        labelGameNr.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelGameNr.setBounds(5, 157, 170, 14);
        contentPane.add(labelGameNr);

        //Punkte
        JLabel labelPoints = new JLabel("Punkte: "+ Login.guest.getPoints());
        labelPoints.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelPoints.setBounds(5, 126, 120, 14);
        contentPane.add(labelPoints);

        //Platzierung
        JLabel labelUserPlacing = new JLabel("Platz: "+ Login.guest.getPlacing());
        labelUserPlacing.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelUserPlacing.setBounds(5, 95, 120, 14);
        contentPane.add(labelUserPlacing);


        JButton buttonLogout = new JButton("Logout");
        buttonLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonLogout.setForeground(new Color(255, 0, 0));
        buttonLogout.setBounds(80, 250, 130, 25);
        southPanel.add(buttonLogout);
        buttonLogout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                Login.guest.setPoints(0);
                Login.guest.setPlacing(0);
                Login.guest.setGameNumber(0);
                Login.guest.setGuestID(0);
                Login.guest.setUserName("");
                Login.guest.setPassword("");
                Login.guest.setEmail("");
                Login.guest.setIDNumber(0);

                UIDefault.main(DataBaseConnector.getArgs());
                dispose();

            }
        });


        JButton buttonNewGame = new JButton("Neues Spiel");
        buttonNewGame.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonNewGame.setForeground(new Color(255, 0, 0));
        buttonNewGame.setBounds(80, 210, 130, 25);
        southPanel.add(buttonNewGame);
        buttonNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

				if(Login.guest.getGuestID()==0) {
					UIGuest.main(DataBaseConnector.getArgs());
					dispose();
				}
				else {
					UIUserDefault.main(DataBaseConnector.getArgs());
					dispose();
				}

            }
        });
        //Hintergrundbild
        ImageIcon imageIcon = new ImageIcon("Ressources/Startbild.jpg");
        JLabel backgroundImage = new JLabel(imageIcon);
        backgroundImage.setBounds(0, 0, 900, 577);
        contentPane.add(backgroundImage);

    }

}
