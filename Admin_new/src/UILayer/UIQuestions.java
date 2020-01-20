package UILayer;

import LogicLayer.ManageQuestions;
import DataLayer.Question;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class UIQuestions {

    private JFrame frame;
    private static JTable table = new JTable();
    private static JComboBox questionNumberCB;
    private static ManageQuestions manageQuestions = new ManageQuestions();



    public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {

                    UIQuestions uiQuestions = new UIQuestions();
                    uiQuestions.frame.setVisible(true);

                    manageQuestions.selectQuestionsforTable(table);
                    manageQuestions.setColumnsSizeInOnScreenTable(table);
                   manageQuestions.selectQuestionNumbersforComboBox(questionNumberCB);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public UIQuestions() {
        initialize();
        frame.setResizable(false);
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1751, 768);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextArea questionTextArea = new JTextArea();
        questionTextArea.setFont(new Font("Tahoma", Font.BOLD, 13));
        questionTextArea.setBounds(520, 161, 690, 68);
        questionTextArea.setLineWrap(true);
        frame.getContentPane().add(questionTextArea);

        JTextField correctAnswerA = new JTextField();
        correctAnswerA.setFont(new Font("Tahoma", Font.BOLD, 13));
        correctAnswerA.setBounds(520, 250, 690, 36);
        frame.getContentPane().add(correctAnswerA);
        correctAnswerA.setColumns(10);

        JTextField answerB = new JTextField();
        answerB.setFont(new Font("Tahoma", Font.BOLD, 13));
        answerB.setBounds(520, 291, 690, 36);
        frame.getContentPane().add(answerB);
        answerB.setColumns(10);

        JTextField answerC = new JTextField();
        answerC.setFont(new Font("Tahoma", Font.BOLD, 13));
        answerC.setBounds(520, 332, 690, 36);
        frame.getContentPane().add(answerC);
        answerC.setColumns(10);

        JTextField answerD = new JTextField();
        answerD.setFont(new Font("Tahoma", Font.BOLD, 13));
        answerD.setBounds(520, 373, 690, 36);
        frame.getContentPane().add(answerD);
        answerD.setColumns(10);

        questionNumberCB = new JComboBox();
        questionNumberCB.setFont(new Font("Tahoma", Font.BOLD, 13));
        questionNumberCB.setBounds(520, 106, 70, 22);
        frame.getContentPane().add(questionNumberCB);
        questionNumberCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String temp = questionNumberCB.getSelectedItem().toString();

                Question question = manageQuestions.selectQuestionbyQuestionNumber(temp);
                questionTextArea.setText(question.getQuestion());
                correctAnswerA.setText(question.getAnswer_1());
                answerB.setText(question.getAnswer_2());
                answerC.setText(question.getAnswer_3());
                answerD.setText(question.getAnswer_4());
            }
        });

        JLabel questionNumLabel = new JLabel("Fragennummer:");
        questionNumLabel.setForeground(Color.WHITE);
        questionNumLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        questionNumLabel.setBounds(352, 100, 200, 30);
        frame.getContentPane().add(questionNumLabel);

        JLabel questionLabel = new JLabel("Frage:");
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        questionLabel.setBounds(352, 161, 70, 36);
        frame.getContentPane().add(questionLabel);

        JLabel answerALabel = new JLabel("Richtige Antwort:");
        answerALabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        answerALabel.setForeground(Color.WHITE);
        answerALabel.setBounds(352, 248, 200, 36);
        frame.getContentPane().add(answerALabel);

        JLabel answerBLabel = new JLabel("2. Antwort:");
        answerBLabel.setForeground(Color.WHITE);
        answerBLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        answerBLabel.setBounds(352, 289, 150, 36);
        frame.getContentPane().add(answerBLabel);

        JLabel answerCLabel = new JLabel("3. Antwort:");
        answerCLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        answerCLabel.setForeground(Color.WHITE);
        answerCLabel.setBounds(352, 330, 150, 36);
        frame.getContentPane().add(answerCLabel);

        JLabel answerDLabel = new JLabel("4. Antwort:");
        answerDLabel.setForeground(Color.WHITE);
        answerDLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        answerDLabel.setBounds(352, 371, 150, 43);
        frame.getContentPane().add(answerDLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 492, 1721, 216);
        scrollPane.setViewportView(table);
        frame.getContentPane().add(scrollPane);

        JButton insertQuestion = new JButton("Hinzufügen");
        insertQuestion.setForeground(Color.BLACK);
        insertQuestion.setBackground(Color.WHITE);
        insertQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
        insertQuestion.setBounds(28, 135, 240, 45);
        frame.getContentPane().add(insertQuestion);
        insertQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String question = questionTextArea.getText();
                String correctAnswer = correctAnswerA.getText();
                String answer_2 = answerB.getText();
                String answer_3 = answerC.getText();
                String answer_4 = answerD.getText();

                manageQuestions.insertQuestion(question, correctAnswer, answer_2, answer_3, answer_4);
                manageQuestions.refreshComboBox(questionNumberCB);
                manageQuestions.selectQuestionsforTable(table);
                manageQuestions.setColumnsSizeInOnScreenTable(table);
                manageQuestions.clearTextFields(questionTextArea, correctAnswerA, answerB, answerC, answerD);

                JOptionPane.showMessageDialog(null,"Ihre Frage wurde dem Fragenpool hinzugefügt.");
            }
        });

        JButton editQuestion = new JButton("Anpassen");
        editQuestion.setForeground(Color.BLACK);
        editQuestion.setBackground(Color.WHITE);
        editQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
        editQuestion.setBounds(28, 190, 240, 45);
        frame.getContentPane().add(editQuestion);
        editQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String questionNr = questionNumberCB.getSelectedItem().toString();
                String question = questionTextArea.getText();
                String correctAnswer = correctAnswerA.getText();
                String answer_2 = answerB.getText();
                String answer_3 = answerC.getText();
                String answer_4 = answerD.getText();

                manageQuestions.editQuestion(questionNumberCB,question,correctAnswer,answer_2,answer_3,answer_4);
                manageQuestions.refreshComboBox(questionNumberCB);
                manageQuestions.selectQuestionsforTable(table);
                manageQuestions.setColumnsSizeInOnScreenTable(table);
                manageQuestions.clearTextFields(questionTextArea, correctAnswerA, answerB, answerC, answerD);

                JOptionPane.showMessageDialog(null,"Die Frage "+questionNr+" wurde angepasst.");

            }
        });

        JButton deleteButton = new JButton("Löschen");
        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        deleteButton.setBounds(28, 245, 240, 45);
        frame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int yesOrNo = JOptionPane.showConfirmDialog(null, "Sind Sie sicher, dass Sie die Frage "+questionNumberCB.getSelectedItem().toString()+" entfernen wollen?","Frage entfernen",JOptionPane.YES_NO_OPTION);
                if(yesOrNo==0){
                    manageQuestions.deleteQuestion(questionNumberCB);
                    manageQuestions.refreshComboBox(questionNumberCB);
                    manageQuestions.selectQuestionsforTable(table);
                    manageQuestions.setColumnsSizeInOnScreenTable(table);
                    manageQuestions.clearTextFields(questionTextArea, correctAnswerA, answerB, answerC, answerD);
                }
                }
        });

        JButton clearButton = new JButton("Felder leeren");
        clearButton.setForeground(Color.BLACK);
        clearButton.setBackground(Color.WHITE);
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        clearButton.setBounds(28, 300, 240, 45);
        frame.getContentPane().add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                questionTextArea.setText("");
                correctAnswerA.setText("");
                answerB.setText("");
                answerC.setText("");
                answerD.setText("");
            }
        });

        JButton returnButton = new JButton("Zurück");
        returnButton.setForeground(Color.BLACK);
        returnButton.setBackground(Color.WHITE);
        returnButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        returnButton.setBounds(28, 355, 240, 45);
        frame.getContentPane().add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    UIMainMenu.main(null);
                } catch (ClassNotFoundException
                        | UnsupportedLookAndFeelException
                        | InstantiationException
                        | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
            }
        });

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Ressources/image_content_828136805_20180122145147.jpg"));
        background.setBounds(0, 0, 1733, 721);
        frame.getContentPane().add(background);
    }
}