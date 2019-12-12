package UILayer;

import DataLayer.TimeHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UIGameWaitingroom extends JFrame {
    private JPanel contentPane;
    private int numberOfGame;
    JLabel lblGameClock;
    JLabel labelClock;
    boolean quizAlreadyStarted;

    /**
     * Launch the application.
     */
    public static void showWaitingroom(int numberOfGame) {
       /* try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIGameWaitingroom frame = new UIGameWaitingroom(numberOfGame);
                    frame.setVisible(true);
                    frame.startTimer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




    private void startTimer() {
        quizAlreadyStarted = false;
        LocalDateTime dateTime = TimeHandler.getStartTimeOfQuiz(numberOfGame).toLocalDateTime();
        lblGameClock.setText("Das Spiel startet am " + dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " um " + dateTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        new ClockSeconds().execute();

    }

    class ClockSeconds extends SwingWorker<Integer, Integer> {

        @Override
        protected Integer doInBackground() throws Exception {
            if (TimeHandler.getMillisWaitingUntilStartQuiz(numberOfGame) <= 0) {
                lblGameClock.setText("Das Spiel hat schon angefangen. Sei beim nächsten Quiz dabei.");
                quizAlreadyStarted = true;
                return 0;
            }
            System.out.println("numberOfGame: " + numberOfGame);
            Integer result;
            do {

                result = (int) (TimeHandler.getMillisWaitingUntilStartQuiz(numberOfGame) / 1000);
               // System.out.println("result: " + result);
                publish(result);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (result > 0);
            return 0;

        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            if (chunks != null) {
                for (Integer s : chunks) {
                    labelClock.setText(s.toString() + "s");
                }
            }
        }

        @Override
        protected void done() {

                try {
                    int i = get();
                    labelClock.setText("" + i + "s");
                    if (!quizAlreadyStarted) {
                        UIGame.showGame();
                        dispose();
                    }
                } catch ( /* InterruptedException, ExecutionException */ Exception e) {
                    e.printStackTrace();
                }

        }


    }


    /**
     * Create the frame.
     */
    public UIGameWaitingroom(int numberOfGame) {
        this.numberOfGame = numberOfGame;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        labelClock = new JLabel();
        //labelClock.setFont(new Font("Tahoma", Font.BOLD, 15));
        Font font = labelClock.getFont().deriveFont(70f);
        labelClock.setFont(font);
        labelClock.setHorizontalAlignment(JLabel.CENTER);
        labelClock.setVerticalAlignment(JLabel.CENTER);
        contentPane.add(labelClock, BorderLayout.CENTER);


        lblGameClock = new JLabel("Das Spiel startet demnächst.");
       // lblGameClock.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblGameClock, BorderLayout.SOUTH);

        /*

        ImageIcon imageIcon = new ImageIcon("Ressources/10_kp_zentriert_strich_edit.jpg");
        JLabel backgroundImage = new JLabel(imageIcon);
        backgroundImage.setBounds(0, 0, 900, 577);
        contentPane.add(backgroundImage);

        */
    }

}