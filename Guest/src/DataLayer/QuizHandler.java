package DataLayer;


import LogicLayer.Question;
import LogicLayer.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizHandler {

    Connection con = DataBaseConnector.dbConnectorMariaDB();
    Quiz quiz = new Quiz();
    private PreparedStatement preparedStatement;


    public Quiz getQuizFromDB(int NumberGame) {
        String queryForQuiz = "SELECT DISTINCT FrageNr, Frage, ErsteWahl, ZweiteWahl, DritteWahl, VierteWahl, RichtigeAntwort FROM FragenPool, Quiz_Fragen WHERE Quiz_Fragen.Spiel_Nummer = '" + NumberGame + "' AND FragenPool.FrageNr = Quiz_Fragen.Frage_Nr";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String numberOfQuestion;
        String question;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        String correctAnswer;
        Question questionFull;
        try {
            preparedStatement = con.prepareStatement(queryForQuiz);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfQuestion = resultSet.getString(1);
                question = resultSet.getString(2);
                answer1 = resultSet.getString(3);
                answer2 = resultSet.getString(4);
                answer3 = resultSet.getString(5);
                answer4 = resultSet.getString(6);
                correctAnswer = resultSet.getString(7);

                questionFull = new Question(numberOfQuestion, question, answer1, answer2, answer3, answer4, correctAnswer);
                quiz.getListQuestions().add(questionFull);
            }
            resultSet.close();
            getAmountRoundsAndQuestion(NumberGame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return quiz;
    }

    private void getAmountRoundsAndQuestion(int NumberGame) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        String queryForQuiz = "SELECT Anzahl_Runden, Anzahl_Fragen FROM Spiel_Gnehmigt WHERE Spiel_Nummer =" + NumberGame;
        try {
            preparedStatement = con.prepareStatement(queryForQuiz);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rounds = resultSet.getInt("Anzahl_Runden");
                int questionCount = resultSet.getInt("Anzahl_Fragen");

                quiz.setQuestionAmountPerRound(questionCount);
                quiz.setRoundAmount(rounds);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteQuiz (int NumberGame) {
        // lösche alle Zeilen der Tabelle Quiz_Fragen mit der entsprechenden Spielnummer
        String delete = "DELETE FROM Quiz_Fragen WHERE Spiel_Nummer = '" + NumberGame + "'";
        try {

            PreparedStatement pstmt = con.prepareStatement(delete);
            pstmt.executeUpdate();
            pstmt.close();

        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void setQuizUsedUp (int NumberGame) {
        // setze bei Spiel mit Nummer NumberGame in Tabelle Spiel_Gnehmigt "Status auf 0"
        String update = "UPDATE Spiel_Gnehmigt SET Status ='" + 0 + "'WHERE Spiel_Nummer = '" + NumberGame + "'";
        try {

            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException se){
            se.printStackTrace();
        }
    }
}
