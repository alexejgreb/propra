package LogicLayer;


import java.util.ArrayList;

public class Quiz {
    private  int indexCurrentQuestion;
    private ArrayList<Question> listQuestions;


    public Quiz() {
        this.listQuestions = new ArrayList<>();
        this.indexCurrentQuestion = 0;
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
