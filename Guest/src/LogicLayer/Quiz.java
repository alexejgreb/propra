package LogicLayer;


import java.util.ArrayList;

public class Quiz {
    private  int indexCurrentQuestion;
    private ArrayList<Question> listQuestions;
    private int roundAmount;
    private int questionAmountPerRound;

    public int getRoundAmount() {
        return roundAmount;
    }

    public void setRoundAmount(int roundAmount) {
        this.roundAmount = roundAmount;
    }

    public int getQuestionAmountPerRound() {
        return questionAmountPerRound;
    }

    public void setQuestionAmountPerRound(int questionAmountPerRound) {
        this.questionAmountPerRound = questionAmountPerRound;
    }

    public Quiz() {
        this.listQuestions = new ArrayList<>();
        this.indexCurrentQuestion = 0;
        roundAmount = 1;
        questionAmountPerRound = 10;
    }

    public ArrayList<Question> getListQuestions() {
        return listQuestions;
    }

    public boolean isQuizFinished() {
        if(indexCurrentQuestion >= listQuestions.size()) {
            return true;
        }
        return false;
    }
    public Question getNextQuestionOfQuiz() {
        Question nextQuestion = getQuestionOfQuiz(indexCurrentQuestion);
        indexCurrentQuestion ++;
        return nextQuestion;
    }

    private Question getQuestionOfQuiz(int numberOfQuestion) {
        return listQuestions.get(numberOfQuestion);
    }
}
