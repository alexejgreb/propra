package UILayer;


import DataLayer.PointQuizHandler;

import DataLayer.DataBaseConnector;

import DataLayer.QuizHandler;
import DataLayer.TimeHandler;
import DataLayer.DataBaseConnector;
import LogicLayer.*;

import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static java.awt.GridBagConstraints.PAGE_START;

public class UIGame extends JFrame {

    private static final int TIME_PER_QUESTION_IN_SECONDS = 20;

	private JPanel contentPane;
	private Timer timer;
	private QuizHandler quizHandler = new QuizHandler();
	private Quiz selectedQuiz;
	private JTextArea lblQuestion;
	private JButton jButtonAnswer1;
	private JButton jButtonAnswer2;
	private JButton jButtonAnswer3;
	private JButton jButtonAnswer4;
    private JProgressBar progressBar;
	private ResultingAnswerPerQuestion lastAnswerPerQuestion;
	private long timeStartShowQuestion;
	private Question actualQuestion;
	private int totalScoreQuiz;
	private Color defaultColorButton;
	private JTextField textFieldresultingPoints;
	public Connection con = DataBaseConnector.dbConnectorMariaDB();
	ClockSeconds clock;

	private void setLastClickedAnswerPerQuestion(String answer, JButton sourceButton, long timeButtonClicked) {
		this.lastAnswerPerQuestion = new ResultingAnswerPerQuestion(answer, timeButtonClicked, sourceButton);
	}



	/**
	 * Launch the application.
	 */
	/*
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
                    frame.initializeQuizAndTimer(907);
                    frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
    }

	 */
    public static void showGame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGame frame = new UIGame();
					//TODO ersetze die Zeile mit:
					frame.initializeQuizAndTimer(Login.guest.getGameNumber());
					//frame.initializeQuizAndTimer(907);
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * InnerClass to get seconds for launching progressbar.
	 */
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
			long remainingSeconds = 20-(((lastAnswerPerQuestion.getTimeButtonClicked()-timeStartShowQuestion)/1000)%60);
			boolean isCorrectAnswer = actualQuestion.isAnswerCorrect(lastAnswerPerQuestion.getAnswer());
			if(isCorrectAnswer){
			int points = 0;
			if (remainingSeconds > 17) {
				points = 100;
			}
			if (remainingSeconds <= 17 && remainingSeconds >= 15 ) {
				points = 80;
			}
			if (remainingSeconds <= 14 && remainingSeconds >= 12 ) {
				points = 65;
			}
			if (remainingSeconds <= 11 && remainingSeconds >= 9){
				points = 50;
			}
			if (remainingSeconds <= 8 && remainingSeconds >= 6) {
				points = 35;
			}
			if (remainingSeconds <= 5) {
				points = 20;
			}
			totalScoreQuiz = totalScoreQuiz + points;
			lastAnswerPerQuestion.getSourceButton().setBackground(Color.green);
			textFieldresultingPoints.setText("Sehr gut! Du bekommst " + points + " Punkte.");
			} else {
				lastAnswerPerQuestion.getSourceButton().setBackground(Color.red);
				getButtonWithRightAnswer().setBackground(Color.green);
				textFieldresultingPoints.setText("Schade! Du bekommst leider 0 Punkte.");
			}

		} else {
			textFieldresultingPoints.setText("Keine Anwort ausgewählt. Du bekommst 0 Punkte.");
		}
	}

	private void onQuizFinished() {
		/*  totalScoreQuiz wird in Kunde_Spiel geschrieben und dem Gast zuwiesen.
			Platzierung des Spielers wird ermittelt.
		*/
		Login.guest.setPoints(totalScoreQuiz);

		int tempPoints = totalScoreQuiz;
		ArrayList<PlayerScore> score = new ArrayList<PlayerScore>();
		int gameNumber = Login.guest.getGameNumber();
		int placing = 1;
		PointQuizHandler PointHandler = new PointQuizHandler();
		// TODO ausommentierter Code auskommentieren
		quizHandler.deleteQuiz(gameNumber);
		quizHandler.setQuizUsedUp(gameNumber);
		PointHandler.setPointsGuestForBarOwner(totalScoreQuiz);
		PointHandler.setPointsForCustomer(totalScoreQuiz);
		PointHandler.setTotalPointsforCustomer(totalScoreQuiz);

		try {
			Thread.sleep(1000); //warten um sicherzugehen, dass die Punkte aller Teilnehmer in der Datenbank zu finden sind.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String query= "SELECT* FROM Kunde_Spiel WHERE Spiel_Nr = '" + gameNumber + "'";
		try {
			PreparedStatement pstmt2 = con.prepareStatement(query);
			ResultSet res = pstmt2.executeQuery();

			while(res.next()){
				PlayerScore playerscore = new PlayerScore (res.getInt(3), res.getInt(5));
				score.add(playerscore);
			}
			res.close();
			pstmt2.close();

		} catch(SQLException se){
			se.printStackTrace();
		}

		for (PlayerScore p : score){
			if(tempPoints < p.getPoints()){
				placing++;
			}
		}
		Login.guest.setPlacing(placing);
		UIFinishedGame.main(null);
		dispose();
	}

	private JButton getButtonWithRightAnswer() {
		String correctAnswer = actualQuestion.getCorrectAnswer();
		JButton buttonWithCorrectAnswer = jButtonAnswer1;
		if (jButtonAnswer2.getText().equals(correctAnswer)){
			buttonWithCorrectAnswer = jButtonAnswer2;
		}else if (jButtonAnswer3.getText().equals(correctAnswer)){
			buttonWithCorrectAnswer = jButtonAnswer3;
		}else if (jButtonAnswer4.getText().equals(correctAnswer)){
			buttonWithCorrectAnswer = jButtonAnswer4;
		}
		return buttonWithCorrectAnswer;
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

	private String getClippedAnswer(String toClip) {

		String result = toClip;
		ArrayList<String> fragments = new ArrayList<>();
		if(toClip.length() >= 10) {
			result = "";
			for (int i = 0; i < toClip.split(" ").length; i++) {
				fragments.add(toClip.split(" ")[i]);
			}
			result = result.concat("<html>");

			for (String fragment : fragments) {

				if (fragment.length() >= 9) {

					result = result.concat(" " + fragment + "<br>");
				} else {
					result =result.concat(" " + fragment);
				}

			}
			result = result.concat("</html>");
		}
		System.out.println(result);
		return result;
	}


    private void initializeQuizAndTimer(int NumberGame) {
		selectedQuiz = quizHandler.getQuizFromDB(NumberGame);

		totalScoreQuiz = 0;

		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!selectedQuiz.isQuizFinished()) {
					timeStartShowQuestion = TimeHandler.getTimeStampFromDB().getTime();
					lastAnswerPerQuestion = null;
					actualQuestion = selectedQuiz.getNextQuestionOfQuiz();
					textFieldresultingPoints.setText("Wähle bitte eine Antwort aus.");
					ArrayList<String> answersRandom = actualQuestion.getRandomizedAnswers();
					lblQuestion.setText(actualQuestion.getQuestion());
					jButtonAnswer1.setText(getClippedAnswer(answersRandom.get(0)));
					jButtonAnswer2.setText(getClippedAnswer(answersRandom.get(1)));
					jButtonAnswer3.setText(getClippedAnswer(answersRandom.get(2)));
					jButtonAnswer4.setText(getClippedAnswer(answersRandom.get(3)));
					resetButtons();
					clock = new ClockSeconds();
					clock.execute();

				} else {
					onQuizFinished();
					timer.stop();
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

		textFieldresultingPoints = new JTextField("Bitte wähle eine Antwort aus!");
		GridBagConstraints gbc_textfield = new GridBagConstraints();
		gbc_textfield.insets = new Insets(10, 0, 5, 0);
		textFieldresultingPoints.setEditable(false);
		gbc_textfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfield.weightx = 0.0;
		gbc_textfield.gridwidth = 3;
		gbc_textfield.gridx = 0;
		gbc_textfield.gridy = 7;
		contentPane.add(textFieldresultingPoints, gbc_textfield);


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
				long time = TimeHandler.getTimeStampFromDB().getTime();
				setLastClickedAnswerPerQuestion(jButtonAnswer1.getText(), jButtonAnswer1, time);
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
				long time = TimeHandler.getTimeStampFromDB().getTime();
				setLastClickedAnswerPerQuestion(jButtonAnswer2.getText(), jButtonAnswer2, time);

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
				long time = TimeHandler.getTimeStampFromDB().getTime();
				setLastClickedAnswerPerQuestion(jButtonAnswer3.getText(), jButtonAnswer3, time);
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
				long time = TimeHandler.getTimeStampFromDB().getTime();
				setLastClickedAnswerPerQuestion(jButtonAnswer4.getText(), jButtonAnswer4, time);
			}
		});
		GridBagConstraints gbc_jButtonAnswer4 = new GridBagConstraints();
		gbc_jButtonAnswer4.gridx = 2;
		gbc_jButtonAnswer4.gridy = 5;
		contentPane.add(jButtonAnswer4, gbc_jButtonAnswer4);
	}
}
