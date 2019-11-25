package LogicLayer;

import LogicLayer.Question;

import java.util.ArrayList;

public class Quiz {
    private  int indexCurrentQuestion;
    private ArrayList<Question> listQuestions = new ArrayList<Question>();


    public Quiz(ArrayList<Question> listQuestions) {
        this.listQuestions = listQuestions;
        this.indexCurrentQuestion = 0;
    }

    public Quiz() {
        this.listQuestions = new ArrayList<Question>();
        this.indexCurrentQuestion = 0;
    }


    public ArrayList<Question> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(ArrayList<Question> listQuestions) {
        this.listQuestions = listQuestions;
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
