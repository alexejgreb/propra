package LogicLayer;

import java.util.ArrayList;

import java.util.Collections;


public class Question {

    public Question(String numberOfQuestion, String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.numberOfQuestion = numberOfQuestion;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getNumberOfQuestion() {
        return numberOfQuestion;
    }

    private String numberOfQuestion;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {return answer1;}

    @Override
    public String toString() {
        return "LogicLayer.Question{" +
                "numberOfQuestion=" + numberOfQuestion +
                ", question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    public boolean isAnswerCorrect(String AnswerToValidate) {
        return AnswerToValidate.equals(answer1);
    }

    public ArrayList<String> getRandomizedAnswers() {

        ArrayList<String> listAnswer = new ArrayList<>();
        listAnswer.add(answer1);
        listAnswer.add(answer2);
        listAnswer.add(answer3);
        listAnswer.add(answer4);
        Collections.shuffle(listAnswer);

        return listAnswer;
    }

}
