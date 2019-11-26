package LogicLayer;

import DataLayer.DataBaseConnector;
import DataLayer.TimeHandler;

import java.util.Timer;
import DataLayer.QuestionHandler;

public class Main implements TaskShowQuestion.Callback {
    private Timer timer;

    public static void main(String[] args) {
        DataBaseConnector.setServerAddress(args[0]);
        DataBaseConnector.setServerUsername(args[1]);
        DataBaseConnector.setServerPassword(args[2]);
        Main ma = new Main();
        ma.start();

    }

    private void start() {
        TimeHandler timeHandler = new TimeHandler();
        System.out.println(timeHandler.getTimeStampFromDB().toLocalDateTime());
        System.out.println(timeHandler.getMillisWaitingUntilStartQuiz());

        timer = new Timer();

        QuestionHandler questionHandler = new QuestionHandler();
        Quiz selectedQuiz = questionHandler.getQuizFromDB("906");
        // TODO Diese beiden oberen Codezeilen müssen später ersetzt werden, da dann das vom User
        //  ausgewählte Spiel geladen wird und hier als statische Variable referenziert wird.

        //Start in einer Sekunde dann Ablauf alle 30 Sekunden
        TaskShowQuestion task = new TaskShowQuestion(selectedQuiz, this);
        timer.scheduleAtFixedRate(task, 100, 30000);

        System.out.println("LogicLayer.Main finished");
    }

    @Override
    public void call() {
        if (timer != null) {
            timer.cancel();
        }

        System.out.println("Timer finished");
    }
}
