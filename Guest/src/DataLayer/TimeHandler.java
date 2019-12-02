package DataLayer;



import java.sql.*;


public class TimeHandler {

    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
    private static Timestamp timeStampNow;
    private static Timestamp timeStampStart;

    // Hole Timestamp von Databank
    public static Timestamp getTimeStampFromDB() {
        String queryForTimeStamp = "SELECT NOW()";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(queryForTimeStamp);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                timeStampNow = resultSet.getTimestamp(1);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStampNow;
    }

    public static Timestamp getStartTimeOfQuiz(String numberOfGame) {
        // TODO Start-Zeitpunkt des Spiels auslesen

        String queryForTimeStamp = "SELECT Uhr_Spiel, Min_Spiel, Tag_Spiel, Monat_Spiel, Jahr_Spiel FROM Spiel_Gnehmigt WHERE Spiel_Nummer =" + numberOfGame;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        int hour;
        int minute;
        int date;
        int month;
        int year;
        try {
            preparedStatement = con.prepareStatement(queryForTimeStamp);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hour = resultSet.getInt(1);
                minute = resultSet.getInt(2);
                date = resultSet.getInt(3);
                month = resultSet.getInt(4);
                year = resultSet.getInt(5);

                timeStampStart = new Timestamp(year, month, date, hour, minute, 0, 0);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStampStart;
    }

    public static long getMillisWaitingUntilStartQuiz(String numberOfGame) {
        //Abfragen, ob daten sich gleichen...
        // oder wie viel Zeit zwischen den zeitPunkten liegt

        timeStampNow = getTimeStampFromDB();
        timeStampStart = getStartTimeOfQuiz(numberOfGame);
        long diff = timeStampStart.getTime() - timeStampNow.getTime();

        if (diff <= 0) {
            return 0;
        }
        return diff;
    }

}
