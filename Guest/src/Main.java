import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        //sTimeHandler timeHandler = new TimeHandler();
       // System.out.println(timeHandler.getTimeStampFromDB().toLocalDateTime());

        Timer timer = new Timer();

        // Start in 2 Sekunden
        timer.schedule(new TaskShowQuestion(), 2000);

        // Start in einer Sekunde dann Ablauf alle 5 Sekunden
        timer.schedule(new TaskShowQuestion(), 1000, 5000);
        QuestionHandler questionHandler = new QuestionHandler();
        for (Question question: questionHandler.getQuiz("906")){
            System.out.println(question);
        }

    }


}
