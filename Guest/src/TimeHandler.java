import java.sql.*;


public class TimeHandler {

    Connection con = DataBaseConnector.dbConnector();
    Timestamp timeStamp;

    // Hole Timestamp von Databank
    public Timestamp getTimeStampFromDB() {
        String queryForTimeStamp = "SELECT datetime('now',  'localtime');";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
      try {
            preparedStatement = con.prepareStatement(queryForTimeStamp);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    timeStamp = resultSet.getTimestamp(1);
                    resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStamp;
    }

}
