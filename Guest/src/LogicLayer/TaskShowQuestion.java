package LogicLayer;

import LogicLayer.Quiz;

import java.util.TimerTask;

public class TaskShowQuestion extends TimerTask {
    private Quiz selectedQuiz;
    private Callback callback;

    public TaskShowQuestion(Quiz quizToStart, Callback callback) {
        this.selectedQuiz = quizToStart;
        this.callback = callback;
    }


    @Override
    public void run() {
        if(!selectedQuiz.isQuizFinished()) {
            Question questionActual = selectedQuiz.getNextQuestionOfQuiz();
            System.out.println(questionActual);
            String correctAnswer = questionActual.getAnswer1();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // disable Answer-Buttons
            // getLastTime buttonclick
            // correct Answer or falseselectedQuiz.getNextQuestionOfQuiz()
            // berechne punktZahl für Antwort und speichere sie zwischen

            return;
        } else {
            System.out.println("LogicLayer.Quiz finished and Tread canceled");
            // schreibe GesamtpunktZahl in Gesamtscore von Nutzer und zeige score des Spiels an
            // schreibe Gesamtpunktzahl in Tabelle, sodass Wirt sie auslesen kann.
             if (callback != null) {
            callback.call();
            this.cancel();
        }
        }


    }

    public interface Callback {
        void call();
    }
}
