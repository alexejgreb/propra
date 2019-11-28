package UILayer;

import DataLayer.DataBaseConnector;
import DataLayer.QuestionHandler;
import LogicLayer.Question;
import LogicLayer.Quiz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static java.awt.GridBagConstraints.PAGE_START;

public class UIGame extends JFrame {

    private static final int TIME_PER_QUESTION_IN_SECONDS = 20;

	JPanel contentPane;
	Timer timer;
    Timer timerTosetProgressBar;
	QuestionHandler questionHandler = new QuestionHandler();
	Quiz selectedQuiz;
	JTextArea lblQuestion;
	JButton jButtonAnswer1;
	JButton jButtonAnswer2;
	JButton jButtonAnswer3;
	JButton jButtonAnswer4;
    static JProgressBar progressBar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
		DataBaseConnector.setServerPassword(args[2]);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGame frame = new UIGame();
                    frame.initializeQuizAndTimer();
                    frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
    }
	class Seconds extends SwingWorker<Integer, Integer> {
        @Override
        protected Integer doInBackground() throws Exception {
            long startNano = System.currentTimeMillis();
            Integer result;
            do {

                result = (int) ((System.currentTimeMillis() - startNano) / 1000) % 60;
                System.out.println("result: " + result);
                publish(result);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (result < TIME_PER_QUESTION_IN_SECONDS && result >=0);

            return TIME_PER_QUESTION_IN_SECONDS;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            if( chunks != null) {
                for( Integer s : chunks ) {
                    progressBar.setValue(s);
                    int timeRemaining = TIME_PER_QUESTION_IN_SECONDS - s;
                    progressBar.setString("" + timeRemaining + "s");
                    progressBar.paint(progressBar.getGraphics());
                }
            }
        }

        @Override protected void done()
        {
            try
            {
                int i = get();
                progressBar.setValue(i);
                int timeRemaining = TIME_PER_QUESTION_IN_SECONDS - i;
                progressBar.setString("" + timeRemaining + "s");
            }
            catch ( /* InterruptedException, ExecutionException */ Exception e ) {
                e.printStackTrace();
            }
        }
    }





    private void initializeQuizAndTimer() {
		selectedQuiz = questionHandler.getQuizFromDB("906");

		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!selectedQuiz.isQuizFinished()) {
					Question actualQuestion = selectedQuiz.getNextQuestionOfQuiz();
					lblQuestion.setText(actualQuestion.getQuestion());
					jButtonAnswer1.setText(actualQuestion.getAnswer1());
					jButtonAnswer2.setText(actualQuestion.getAnswer2());
					jButtonAnswer3.setText(actualQuestion.getAnswer3());
					jButtonAnswer4.setText(actualQuestion.getAnswer4());

					new Seconds().execute();
					progressBar.paint(progressBar.getGraphics());
				}
			}
		});
		timer.setDelay(30000);
		timer.setRepeats(true);
		timer.start();

	}






	/**
	 * Create the frame.
	 */
	public UIGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 20, 5, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		progressBar = new JProgressBar(0, TIME_PER_QUESTION_IN_SECONDS);
        progressBar.setStringPainted(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(10, 0, 5, 0);
        progressBar.setPreferredSize(new Dimension(100, 20));
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.weightx = 0.0;
        gbc_progressBar.gridwidth = 3;
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 6;
		contentPane.add(progressBar, gbc_progressBar);

		lblQuestion = new JTextArea("");
		lblQuestion.setEditable(false);
		lblQuestion.setLineWrap(true);
		lblQuestion.setMargin(new Insets(10,10,10,10));
		lblQuestion.setPreferredSize(new Dimension(100, 150));
		lblQuestion.setWrapStyleWord(true);
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridx = 0;
		gbc_lblQuestion.gridy = 1;
		gbc_lblQuestion.ipady = 40;      //make this component tall
		gbc_lblQuestion.weightx = 0.0;
		gbc_lblQuestion.gridwidth = 3;

		gbc_lblQuestion.anchor = PAGE_START;

		contentPane.add(lblQuestion, gbc_lblQuestion);
		
		jButtonAnswer1 = new JButton("Antwort1");
		jButtonAnswer1.setPreferredSize(new Dimension(150, 100));
		jButtonAnswer1.setMinimumSize(new Dimension(150,80));
		jButtonAnswer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_ButtonAnswer1 = new GridBagConstraints();
		gbc_ButtonAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_ButtonAnswer1.gridx = 0;
		gbc_ButtonAnswer1.gridy = 4;


		contentPane.add(jButtonAnswer1, gbc_ButtonAnswer1);

		jButtonAnswer2 = new JButton("Antwort2");
		jButtonAnswer2.setPreferredSize(new Dimension(150, 100));
		jButtonAnswer2.setMinimumSize(new Dimension(150,80));
		jButtonAnswer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//jButtonAnswer2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jButtonAnswer2 = new GridBagConstraints();
		gbc_jButtonAnswer2.insets = new Insets(0, 0, 5, 0);
		gbc_jButtonAnswer2.gridx = 2;
		gbc_jButtonAnswer2.gridy = 4;
		contentPane.add(jButtonAnswer2, gbc_jButtonAnswer2);
		
		jButtonAnswer3 = new JButton("Antwort3");
		jButtonAnswer3.setPreferredSize(new Dimension(150, 100));
		jButtonAnswer3.setMinimumSize(new Dimension(150,80));
		jButtonAnswer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jButtonAnswer3 = new GridBagConstraints();
		gbc_jButtonAnswer3.insets = new Insets(0, 0, 0, 5);
		gbc_jButtonAnswer3.gridx = 0;
		gbc_jButtonAnswer3.gridy = 5;
		contentPane.add(jButtonAnswer3, gbc_jButtonAnswer3);
		
		jButtonAnswer4 = new JButton("Antwort4");
		jButtonAnswer4.setPreferredSize(new Dimension(150, 100));
		jButtonAnswer4.setMinimumSize(new Dimension(150,80));
		jButtonAnswer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jButtonAnswer4 = new GridBagConstraints();
		gbc_jButtonAnswer4.gridx = 2;
		gbc_jButtonAnswer4.gridy = 5;
		contentPane.add(jButtonAnswer4, gbc_jButtonAnswer4);
	}
}
