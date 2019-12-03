package DataLayer;

import LogicLayer.Question;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class BarQuestionHandler {

    Connection con = DataBaseConnector.dbConnector();
    static ArrayList<Question> questions = new ArrayList<Question>();

    public BarQuestionHandler() {
        String queryForQuiz = "SELECT FrageNr, Frage, ErsteWahl, ZweiteWahl, DritteWahl, VierteWahl, RichtigeAntwort, Besitzer FROM FragenPool WHERE Besitzer = " + BarOwner.getId();
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        int numberOfQuestion;
        String question;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        String correctAnswer;
        Question questionFull;
        try {
            assert con != null;
            preparedStatement = con.prepareStatement(queryForQuiz);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfQuestion = resultSet.getInt(1);
                question = resultSet.getString(2);
                answer1 = resultSet.getString(3);
                answer2 = resultSet.getString(4);
                answer3 = resultSet.getString(5);
                answer4 = resultSet.getString(6);
                correctAnswer = resultSet.getString(7);

                questionFull = new Question(numberOfQuestion, question, answer1, answer2, answer3, answer4, correctAnswer);
                questions.add(questionFull);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void addQuestion(Question question){
        //TODO
    }

    public static void editQuestion(Question question){
        //TODO
        Connection con = DataBaseConnector.dbConnector();


        String query = "UPDATE `FragenPool` SET `Frage`=?, `ErsteWahl`=?, `ZweiteWahl`=?, `DritteWahl`=?, `VierteWahl`=? WHERE `FrageNr`=?";

        // String query = "UPDATE FragenPool SET Frage = '" + question.getQuestion() + "', ErsteWahl = '" + question.getAnswer1() + "', ZweiteWahl = '" + question.getAnswer2() + "', DritteWahl = '" + question.getAnswer3() + "', VierteWahl = '" + question.getAnswer4() + "' WHERE FrageNr = '" + question.getNumberOfQuestion() + "'";

        System.out.println("question = " + question.getQuestion());
        System.out.println("question = " + question.getAnswer1());
        System.out.println("question = " + question.getAnswer2());
        System.out.println("question = " + question.getAnswer3());
        System.out.println("question = " + question.getAnswer4());
        System.out.println("question = " + question.getNumberOfQuestion());

        try {
            assert con != null;

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getAnswer1());
            preparedStatement.setString(3, question.getAnswer2());
            preparedStatement.setString(4, question.getAnswer3());
            preparedStatement.setString(5, question.getAnswer4());
            preparedStatement.setInt(6, question.getNumberOfQuestion());

            //preparedStatement.addBatch();
            //preparedStatement.executeBatch();
            //preparedStatement.clearBatch();
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteQuestion(Question question){
        //TODO Frage noch aus ArrayList löschen
        Connection con = DataBaseConnector.dbConnector();
        String query = "DELETE FROM FragenPool WHERE FrageNr = " + question.getNumberOfQuestion();
        PreparedStatement preparedStatement;

        try {
            assert con != null;
            preparedStatement = con.prepareStatement(query);
            //preparedStatement.executeUpdate(); // delete from Database

            questions.remove(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getOnlyQuestions() {
        ArrayList<String> onlyQuestions = new ArrayList<String>();
        for (int i = 0; i < questions.size(); i++) {
            onlyQuestions.add(questions.get(i).getQuestion());
        }
        return onlyQuestions;
    }
}
