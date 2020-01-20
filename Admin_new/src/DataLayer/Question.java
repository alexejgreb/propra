package DataLayer;

public class Question {

    int questionNumber;
    String question;
    String answer_1;
    String answer_2;
    String answer_3;
    String answer_4;

    public Question(int questionNumber, String question, String answer_1, String answer_2, String answer_3, String answer_4) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
    }

    public int getQuestionNumber() { return questionNumber; }

    public void setQuestionNumber(int questionNumber) { this.questionNumber = questionNumber; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public String getAnswer_1() { return answer_1; }

    public void setAnswer_1(String answer_1) { this.answer_1 = answer_1; }

    public String getAnswer_2() { return answer_2; }

    public void setAnswer_2(String answer_2) { this.answer_2 = answer_2; }

    public String getAnswer_3() { return answer_3; }

    public void setAnswer_3(String answer_3) { this.answer_3 = answer_3; }

    public String getAnswer_4() { return answer_4; }

    public void setAnswer_4(String answer_4) { this.answer_4 = answer_4; }

}
