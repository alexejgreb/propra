package UILayer;

import DataLayer.DataBaseConnector;
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


        JLabel lblErgebnis = new JLabel("Ergebnis");
        lblErgebnis.setBounds(5, 5, 424, 14);
        contentPane.add(lblErgebnis);

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

        JButton ButtonNewGame = new JButton("Neues Spiel");
        ButtonNewGame.setBounds(80, 210, 115, 25);
        contentPane.add(ButtonNewGame);
        ButtonNewGame.addActionListener(new ActionListener() {
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

        JButton ButtonLogout = new JButton("Zurück");
        ButtonLogout.setBounds(80, 250, 115, 25);
        contentPane.add(ButtonLogout);
        ButtonLogout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                UIDefault.main(null);
                dispose();

            }
        });
    }

}
