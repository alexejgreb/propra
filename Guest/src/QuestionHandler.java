import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class QuestionHandler {

    Connection con = DataBaseConnector.dbConnector();
    Quiz quiz = new Quiz();



    public Quiz getQuizFromDB(String NumberGame) {
        String queryForQuiz = "SELECT DISTINCT FrageNr, Frage, ErsteWahl, ZweiteWahl, DritteWahl, VierteWahl, RichtigeAntwort FROM Fragen_Pool, Quiz_Fragen WHERE Quiz_Fragen.Spiel_Nummer = " + NumberGame + " AND Fragen_Pool.FrageNr = Quiz_Fragen.Frage_Nr";
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return quiz;
    }

}
