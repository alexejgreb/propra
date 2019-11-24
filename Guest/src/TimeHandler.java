import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;


public class TimeHandler {

    Connection con = DataBaseConnector.dbConnector();
    Timestamp timeStampNow;
    Timestamp timeStampStart;

    // Hole Timestamp von Databank
    public Timestamp getTimeStampFromDB() {
        String queryForTimeStamp = "SELECT datetime('now',  'localtime');";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
      try {
            preparedStatement = con.prepareStatement(queryForTimeStamp);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    timeStampNow = resultSet.getTimestamp(1);
                    resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStampNow;
    }
    public Timestamp getStartTimeofQuiz (String numberOfGame) {
        // TODO Start-Zeitpunkt des Spiels auslesen

        return timeStampStart;
    }

    public void getMillisWaitingUntilStartQuiz() {
      //Abfragen, ob daten sich gleichen...
        // oder wie viel Zeit zwischen den zeitPunkten liegt
    }

}
