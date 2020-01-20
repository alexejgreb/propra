package LogicLayer;

import DataLayer.DataBaseConnector;
import DataLayer.Question;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageQuestions {
    private Connection con = DataBaseConnector.dbConnectorMariaDB();

    public void insertQuestion(String question, String answer_1, String answer_2, String answer_3, String answer_4) {

        String insert = "INSERT INTO FragenPool (Frage, ErsteWahl, ZweiteWahl, DritteWahl, VierteWahl, RichtigeAntwort, Besitzer) VALUES(?,?,?,?,?,?,?)";

        try {
        PreparedStatement pstmt = con.prepareStatement(insert);
        pstmt.setString(1,question);
        pstmt.setString(2,answer_1);
        pstmt.setString(3,answer_2);
        pstmt.setString(4,answer_3);
        pstmt.setString(5,answer_4);
        pstmt.setString(6,"A");
        pstmt.setInt(7,0);
        pstmt.executeUpdate();
        pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuestion(JComboBox questionNumber) {
        String temp = questionNumber.getSelectedItem().toString();
        String delete = "DELETE FROM FragenPool WHERE FrageNr= '" + temp + "'";

        try {
            PreparedStatement pstmt = con.prepareStatement(delete);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editQuestion(JComboBox questionNr,String question, String answer_1, String answer_2, String answer_3, String answer_4) {
        String temp = questionNr.getSelectedItem().toString();
        String update = "Update FragenPool SET Frage ='"+ question +"', ErsteWahl ='"+ answer_1 +"', ZweiteWahl ='"+ answer_2 +"', DritteWahl ='"+ answer_3 +"', VierteWahl ='"+ answer_4 +"'WHERE FrageNr ='"+ temp +"'";

        try {
            PreparedStatement pstmt = con.prepareStatement(update);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectQuestionNumbersforComboBox(JComboBox questionNumbers) {

        String questionNr = "";
        String query = "SELECT FrageNr FROM FragenPool WHERE Besitzer = 0";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                questionNr = res.getString("FrageNr");
                questionNumbers.addItem(questionNr);
            }
            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshComboBox(JComboBox questionNumbers){

        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        String questionNr = "";
        String query = "SELECT FrageNr FROM FragenPool WHERE Besitzer = 0";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                questionNr = res.getString("FrageNr");
                defaultComboBoxModel.addElement(questionNr);
            }
            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        questionNumbers.setModel(defaultComboBoxModel);
    }

    public void selectQuestionsforTable(JTable table) {

        String query = "SELECT FrageNr AS Fragennummer, Frage AS Frage, ErsteWahl AS Richtige_Antwort, ZweiteWahl AS Antwort_2, DritteWahl AS Antwort_3, VierteWahl AS Antwort_4 FROM FragenPool WHERE Besitzer = 0";

        try {

            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(res));

            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Question selectQuestionbyQuestionNumber(String questionNr) {

        Question question = new Question(0,"","","","","");
        String query = "SELECT * FROM FragenPool WHERE FrageNr='" + questionNr + "'";

        try {

            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {

                question.setQuestion(res.getString(2));
                question.setAnswer_1(res.getString(3));
                question.setAnswer_2(res.getString(4));
                question.setAnswer_3(res.getString(5));
                question.setAnswer_4(res.getString(6));

                pstmt.close();
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public void setColumnsSizeInOnScreenTable(JTable table){

        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(5);
        tcm.getColumn(1).setPreferredWidth(750);
        tcm.getColumn(2).setPreferredWidth(100);
        tcm.getColumn(3).setPreferredWidth(100);
        tcm.getColumn(4).setPreferredWidth(100);
        tcm.getColumn(5).setPreferredWidth(100);
    }

    public void clearTextFields(JTextArea question, JTextField correctAnswer,JTextField answer_2, JTextField answer_3, JTextField answer_4){

        question.setText("");
        correctAnswer.setText("");
        answer_2.setText("");
        answer_3.setText("");
        answer_4.setText("");
    }
}

