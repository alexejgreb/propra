package UILayer;
import DataLayer.TimeHandler;
import LogicLayer.Guest;
import LogicLayer.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class UIGameWaitingroom extends JFrame {
//k
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIGameWaitingroom frame = new UIGameWaitingroom();
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
    public UIGameWaitingroom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


        /*JProgressBar progressBar = new JProgressBar(0, Math.toIntExact(TimeHandler.getMillisWaitingUntilStartQuiz(Login.guest.getGameNumber())));
        progressBar.addAncestorListener(new AncestorListener() {
            public void ancestorAdded(AncestorEvent arg0) {
            }
            public void ancestorMoved(AncestorEvent arg0) {
            }
            public void ancestorRemoved(AncestorEvent arg0) {
            }
        });
        contentPane.add(progressBar, BorderLayout.CENTER);

        */
        JLabel lblGameClock = new JLabel("Das Spiel startet demnächst.");
        contentPane.add(lblGameClock, BorderLayout.SOUTH);

    }

}