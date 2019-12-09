package UILayer;

import LogicLayer.Login;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIFinishedGame extends JFrame {

    private JPanel contentPane;
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
        setBounds(100, 100, 300, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblHeader = new JLabel("Ergebnis");
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblHeader.setBounds(5, 5, 424, 14);
        contentPane.add(lblHeader);

        //Benutzername, bleibt leer wenn als Gast gespielt wird
        JLabel LabelUserName = new JLabel(""+ Login.guest.getUserName());
        LabelUserName.setBounds(5, 64, 92, 14);
        contentPane.add(LabelUserName);

        //Spielnummer
        JLabel LabelGameNr = new JLabel("Spiel Nr: "+ Login.guest.getGameNumber());
        LabelGameNr.setBounds(5, 157, 97, 14);
        contentPane.add(LabelGameNr);

        //Punkte
        JLabel LabelPoints = new JLabel("Punkte: "+ Login.guest.getPoints());
        LabelPoints.setBounds(5, 126, 97, 14);
        contentPane.add(LabelPoints);

        //Platzierung
        JLabel LabelUserPlacing = new JLabel("Platz: "+ Login.guest.getPlacing());
        LabelUserPlacing.setBounds(5, 95, 97, 14);
        contentPane.add(LabelUserPlacing);

        JButton buttonNewGame = new JButton("Neues Spiel");
        buttonNewGame.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonNewGame.setForeground(new Color(255, 0, 0));
        buttonNewGame.setBounds(80, 210, 130, 25);
        contentPane.add(buttonNewGame);
        buttonNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

				if(Login.guest.getGuestID()==0) {
					UIGuest.main(null);
					dispose();
				}
				else {
					UIUserDefault.main(null);
					dispose();
				}

            }
        });

        JButton buttonLogout = new JButton("Zurück");
        buttonLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonLogout.setForeground(new Color(255, 0, 0));
        buttonLogout.setBounds(80, 250, 130, 25);
        contentPane.add(buttonLogout);
        buttonLogout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                UIDefault.main(null);
                dispose();

            }
        });
    }

}
