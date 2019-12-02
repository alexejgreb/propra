package LogicLayer;

import javax.swing.*;

public class ResultingAnswerPerQuestion {
    private long timeButtonClicked;
    private JButton sourceButton;
    private String answer;

    public JButton getSourceButton() {
        return sourceButton;
    }

    public String getAnswer() {
        return answer;
    }

    public long getTimeButtonClicked() {
        return timeButtonClicked;
    }


    @Override
    public String toString() {
        return "ResultingAnswerPerQuestion{" +
                "answer='" + answer + '\'' +
                ", timeButtonClicked=" + timeButtonClicked +
                ", sourceButton=" + sourceButton +
                '}';
    }

    public ResultingAnswerPerQuestion(String answer, long timeButtonClicked, JButton sourcceButton) {
        this.answer = answer;
        this.timeButtonClicked = timeButtonClicked;
        this.sourceButton = sourcceButton;
    }
}
