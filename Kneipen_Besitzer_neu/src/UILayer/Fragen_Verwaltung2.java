package UILayer;

import DataLayer.BarQuestionHandler;
import LogicLayer.Question;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Fragen_Verwaltung2 {

	private int numberOfQuestion;
	private Question currentSelectedQuestion;

	private JFrame frame;
	private JTextField txtFrage;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;

	/**
	 * Launch the application.
	 */
	public static void Screen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fragen_Verwaltung2 window = new Fragen_Verwaltung2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fragen_Verwaltung2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1124, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(6, 6, 1112, 200);
		//frame.getContentPane().add(scrollPane);
		
		JList listOfQuestions = new JList(BarQuestionHandler.getOnlyQuestions().toArray());
		listOfQuestions.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				currentSelectedQuestion = BarQuestionHandler.getQuestions().get(listOfQuestions.getSelectedIndex());
				txtFrage.setText(currentSelectedQuestion.getQuestion());
				txtA.setText(currentSelectedQuestion.getAnswer1());
				txtB.setText(currentSelectedQuestion.getAnswer2());
				txtC.setText(currentSelectedQuestion.getAnswer3());
				txtD.setText(currentSelectedQuestion.getAnswer4());
			}
		});
		//scrollPane.setViewportView(listOfQuestions);
		listOfQuestions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listOfQuestions.setBounds(6, 6, 1112, 200);
		frame.getContentPane().add(listOfQuestions);

		txtFrage = new JTextField();
		txtFrage.setBounds(300, 218, 700, 26);
		frame.getContentPane().add(txtFrage);
		txtFrage.setColumns(10);

		txtA = new JTextField();
		txtA.setBounds(300, 256, 700, 26);
		frame.getContentPane().add(txtA);
		txtA.setColumns(10);

		txtB = new JTextField();
		txtB.setBounds(300, 294, 700, 26);
		frame.getContentPane().add(txtB);
		txtB.setColumns(10);

		txtC = new JTextField();
		txtC.setBounds(300, 332, 700, 26);
		frame.getContentPane().add(txtC);
		txtC.setColumns(10);

		txtD = new JTextField();
		txtD.setBounds(300, 370, 700, 26);
		frame.getContentPane().add(txtD);
		txtD.setColumns(10);
		
		JButton btnNeueFrageHinzufgen = new JButton("Neue Frage hinzufügen");
		btnNeueFrageHinzufgen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				//TODO
			}
		});
		btnNeueFrageHinzufgen.setBounds(6, 218, 169, 29);
		frame.getContentPane().add(btnNeueFrageHinzufgen);
		
		JButton btnFrageBearbeiten = new JButton("Frage bearbeiten");
		/*btnFrageBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//TODO
				String numberOfQuestion =
				currentSelectedQuestion = new Question();
				BarQuestionHandler.editQuestion(currentSelectedQuestion);
			}
		});*/
		btnFrageBearbeiten.setBounds(6, 256, 169, 29);
		frame.getContentPane().add(btnFrageBearbeiten);
		
		JButton btnFrageLschen = new JButton("Frage löschen");
		btnFrageLschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				BarQuestionHandler.deleteQuestion(currentSelectedQuestion);
				listOfQuestions.remove(listOfQuestions.getSelectedIndex());
			}
		});

		btnFrageLschen.setBounds(6, 294, 169, 29);
		frame.getContentPane().add(btnFrageLschen);

		JButton buttonBack = new JButton("Zurück");
		buttonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Kneipen_Besitzer KB= new Kneipen_Besitzer();
				try {
					KB.NewScreen();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();

			}
		});
		buttonBack.setBounds(6, 400, 169, 29);
		frame.getContentPane().add(buttonBack);


		JLabel lblFrage = new JLabel("Frage:");
		lblFrage.setBounds(227, 223, 61, 16);
		frame.getContentPane().add(lblFrage);
		
		JLabel lblA = new JLabel("A:");
		lblA.setBounds(227, 261, 61, 16);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("B:");
		lblB.setBounds(227, 299, 61, 16);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C:");
		lblC.setBounds(227, 337, 61, 16);
		frame.getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D:");
		lblD.setBounds(227, 375, 61, 16);
		frame.getContentPane().add(lblD);
	}
}
