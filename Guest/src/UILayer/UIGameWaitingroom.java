package UILayer;
import DataLayer.TimeHandler;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UIGameWaitingroom extends JFrame {
    private JPanel contentPane;
    private int numberOfGame;
    JLabel lblGameClock;
    JLabel labelClock;

    /**
     * Launch the application.
     */
    public static void showWaitingroom(int numberOfGame) {
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
        new ClockSeconds().execute();
        LocalDateTime dateTime = TimeHandler.getStartTimeOfQuiz(numberOfGame).toLocalDateTime();

        lblGameClock.setText( "Das Spiel startet am " + dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " um "+ dateTime.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
    class ClockSeconds extends SwingWorker<Integer, Integer> {
        @Override
        protected Integer doInBackground() throws Exception {

            Integer result;
            do {

                result = (int) (TimeHandler.getMillisWaitingUntilStartQuiz(numberOfGame) / 1000);
                publish(result);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (result >= 0);

            return 0;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            if( chunks != null) {
                for( Integer s : chunks ) {
                    labelClock.setText(s.toString() + "s");
                }
            }
        }

        @Override protected void done()
        {
            try
            {
                int i = get();
                labelClock.setText("" + i + "s");
            }
            catch ( /* InterruptedException, ExecutionException */ Exception e ) {
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
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        labelClock = new JLabel();
        Font font = labelClock.getFont().deriveFont(70f);
        labelClock.setFont(font);
        labelClock.setHorizontalAlignment(JLabel.CENTER);
        labelClock.setVerticalAlignment(JLabel.CENTER);
        contentPane.add(labelClock, BorderLayout.CENTER);


        lblGameClock = new JLabel("Das Spiel startet demnächst.");
        contentPane.add(lblGameClock, BorderLayout.SOUTH);

    }

}