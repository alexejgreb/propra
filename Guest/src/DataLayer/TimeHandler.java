package DataLayer;

import java.sql.*;


public class TimeHandler {

    private static Connection con = DataBaseConnector.dbConnectorMariaDB();
    private static Timestamp timeStampNow;
    private static Timestamp timeStampStart;

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

    public static Timestamp getStartTimeOfQuiz(int numberOfGame) {

        String queryForTimeStamp = "SELECT Uhr_Spiel, Min_Spiel, Tag_Spiel, Monat_Spiel, Jahr_Spiel FROM Spiel_Gnehmigt WHERE Spiel_Nummer =" + numberOfGame;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        int hour;
        int minute;
        int day;
        int month;
        int year;
        try {
            preparedStatement = con.prepareStatement(queryForTimeStamp);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hour = resultSet.getInt(1);
                minute = resultSet.getInt(2);
                day = resultSet.getInt(3);
                month = resultSet.getInt(4);
                year = resultSet.getInt(5);

                timeStampStart = new Timestamp(year-1900, month-1, day, hour, minute, 0, 0);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStampStart;
    }

    public static long getMillisWaitingUntilStartQuiz(int numberOfGame) {

        timeStampNow = getTimeStampFromDB();
        timeStampStart = getStartTimeOfQuiz(numberOfGame);
        long diff = timeStampStart.getTime() - timeStampNow.getTime();

        if (diff <= 0) {
            return -1;
        }
        return diff;
    }

}
