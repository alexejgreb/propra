package UILayer;

import DataLayer.DataBaseConnector;
import DataLayer.QuestionHandler;
import LogicLayer.Question;
import LogicLayer.Quiz;
import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static java.awt.GridBagConstraints.PAGE_START;

public class UIGame extends JFrame {


	JPanel contentPane;
	Timer timer;
	QuestionHandler questionHandler = new QuestionHandler();
	Quiz selectedQuiz;
	JTextArea lblQuestion;
	JButton jButtonAnswer1;
	JButton jButtonAnswer2;
	JButton jButtonAnswer3;
	JButton jButtonAnswer4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DataBaseConnector.setServerAddress(args[0]);
		DataBaseConnector.setServerUsername(args[1]);
		DataBaseConnector.setServerPassword(args[2]);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGame frame = new UIGame();
					frame.setVisible(true);
					frame.initializeQuizAndTimer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}


	private void initializeQuizAndTimer() {
		selectedQuiz = questionHandler.getQuizFromDB("906");
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!selectedQuiz.isQuizFinished()) {
					Question actualQuestion = selectedQuiz.getNextQuestionOfQuiz();
					lblQuestion.setText(actualQuestion.getQuestion());
					jButtonAnswer1.setText(actualQuestion.getAnswer1());
					jButtonAnswer2.setText(actualQuestion.getAnswer2());
					jButtonAnswer3.setText(actualQuestion.getAnswer3());
					jButtonAnswer4.setText(actualQuestion.getAnswer4());
				}
			}
		});
		timer.setDelay(5000);
		timer.setRepeats(true);
		timer.start();
	}


	/**
	 * Create the frame.
	 */
	public UIGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		/*
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 0;
		contentPane.add(progressBar, gbc_progressBar);
		*/
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
		
		JButton jButtonAnswer1 = new JButton("Antwort1");
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
