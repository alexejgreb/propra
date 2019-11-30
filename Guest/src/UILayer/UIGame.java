package UILayer;

import DataLayer.DataBaseConnector;
import DataLayer.QuestionHandler;
import DataLayer.TimeHandler;
import LogicLayer.Question;
import LogicLayer.Quiz;
import LogicLayer.ResultingAnswerPerQuestion;

import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static java.awt.GridBagConstraints.PAGE_START;

public class UIGame extends JFrame {

    private static final int TIME_PER_QUESTION_IN_SECONDS = 20;

	JPanel contentPane;
	Timer timer;
	QuestionHandler questionHandler = new QuestionHandler();
	Quiz selectedQuiz;
	JTextArea lblQuestion;
	JButton jButtonAnswer1;
	JButton jButtonAnswer2;
	JButton jButtonAnswer3;
	JButton jButtonAnswer4;
    static JProgressBar progressBar;
	private ResultingAnswerPerQuestion lastAnswerPerQuestion;
	long timeStartShowQuestion;
	Question actualQuestion;
	int totalScoreQuiz;
	Color defaultColorButton;

	public void setLastClickedAnswerPerQuestion(String answer, JButton sourceButton, long timeButtonClicked) {
		this.lastAnswerPerQuestion = new ResultingAnswerPerQuestion(answer, timeButtonClicked, sourceButton);
	}



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
                    frame.initializeQuizAndTimer("906");
                    frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
    }
	class ClockSeconds extends SwingWorker<Integer, Integer> {
        @Override
        protected Integer doInBackground() throws Exception {
            long startNano = System.currentTimeMillis();
            Integer result;
            do {

                result = (int) ((System.currentTimeMillis() - startNano) / 1000) % 60;
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
                calculatePointsPerQuestion();
            }
            catch ( /* InterruptedException, ExecutionException */ Exception e ) {
                e.printStackTrace();
            }
        }
    }


	private void calculatePointsPerQuestion() {
		jButtonAnswer1.setEnabled(false);
		jButtonAnswer2.setEnabled(false);
		jButtonAnswer3.setEnabled(false);
		jButtonAnswer4.setEnabled(false);
		if (lastAnswerPerQuestion != null) {
			double remainingSeconds = ((timeStartShowQuestion - lastAnswerPerQuestion.getTimeButtonClicked())/1000);
			boolean isCorrectAnswer = actualQuestion.isAnswerCorrect(lastAnswerPerQuestion.getAnswer());
			if(isCorrectAnswer){
			int tempPoints = (int)(remainingSeconds * 10);
			tempPoints = (tempPoints + 10) % 201;
			totalScoreQuiz = totalScoreQuiz + tempPoints;
			System.out.println(totalScoreQuiz);
			lastAnswerPerQuestion.getSourceButton().setBackground(Color.green);
			} else {
				lastAnswerPerQuestion.getSourceButton().setBackground(Color.red);
				System.out.println("You earned 0 points");}
		} else {
			System.out.println("no Answer selected. You earned 0 Points");
		}
	}

	private void resetButtons(){
		jButtonAnswer1.setEnabled(true);
		jButtonAnswer2.setEnabled(true);
		jButtonAnswer3.setEnabled(true);
		jButtonAnswer4.setEnabled(true);
		jButtonAnswer1.setBackground(defaultColorButton);
		jButtonAnswer2.setBackground(defaultColorButton);
		jButtonAnswer3.setBackground(defaultColorButton);
		jButtonAnswer4.setBackground(defaultColorButton);
	}


    private void initializeQuizAndTimer(String NumberGame) {
		selectedQuiz = questionHandler.getQuizFromDB(NumberGame);
		totalScoreQuiz = 0;

		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!selectedQuiz.isQuizFinished()) {
					timeStartShowQuestion = TimeHandler.getTimeStampFromDB().getTime();
					lastAnswerPerQuestion = null;
					actualQuestion = selectedQuiz.getNextQuestionOfQuiz();
					ArrayList<String> answersRandom = actualQuestion.getRandomizedAnswers();
					lblQuestion.setText(actualQuestion.getQuestion());
					jButtonAnswer1.setText(answersRandom.get(0));
					jButtonAnswer2.setText(answersRandom.get(1));
					jButtonAnswer3.setText(answersRandom.get(2));
					jButtonAnswer4.setText(answersRandom.get(3));
					resetButtons();
					new ClockSeconds().execute();
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
			public void actionPerformed(ActionEvent e) {
				setLastClickedAnswerPerQuestion(jButtonAnswer1.getText(), jButtonAnswer1, e.getWhen());
			}
		});
		GridBagConstraints gbc_ButtonAnswer1 = new GridBagConstraints();
		gbc_ButtonAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_ButtonAnswer1.gridx = 0;
		gbc_ButtonAnswer1.gridy = 4;
		defaultColorButton = jButtonAnswer1.getBackground();


		contentPane.add(jButtonAnswer1, gbc_ButtonAnswer1);

		jButtonAnswer2 = new JButton("Antwort2");
		jButtonAnswer2.setPreferredSize(new Dimension(150, 100));
		jButtonAnswer2.setMinimumSize(new Dimension(150,80));
		jButtonAnswer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setLastClickedAnswerPerQuestion(jButtonAnswer2.getText(), jButtonAnswer2, e.getWhen());
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
				setLastClickedAnswerPerQuestion(jButtonAnswer3.getText(), jButtonAnswer3, e.getWhen());
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
				setLastClickedAnswerPerQuestion(jButtonAnswer4.getText(), jButtonAnswer4, e.getWhen());
			}
		});
		GridBagConstraints gbc_jButtonAnswer4 = new GridBagConstraints();
		gbc_jButtonAnswer4.gridx = 2;
		gbc_jButtonAnswer4.gridy = 5;
		contentPane.add(jButtonAnswer4, gbc_jButtonAnswer4);
	}
}
