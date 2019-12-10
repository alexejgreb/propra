import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Logic {


    Connection con = DataBaseConnector.dbConnectorMariaDB();
    private PreparedStatement preparedStatement;

    public int howManyQuestionInDatabase(int besitzer) {

        String query = "SELECT * FROM FragenPool WHERE Besitzer= " + besitzer;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        int i=0;
        try {
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                i++;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public ArrayList<Integer> randomDefaultQuestion(int besitzer , int howMany){
        int max;
        ArrayList<Integer> x =new ArrayList();
        int i=0;
        Logic temp = new Logic();
        max=temp.howManyQuestionInDatabase(besitzer);

        while (i<=howMany){
            int index = (int)((Math.random()) * max + 1);
            if(!x.contains(index)){
                x.add(index);
                i++;
            }
        }

        return x;
    }

    public ArrayList<Integer> getQuestionNumbersOfBarowner(int besitzer) throws SQLException {
        ArrayList<Integer> questionNumbers =new ArrayList<>();
        int number=-1;

        String query = "SELECT FrageNr FROM FragenPool WHERE Besitzer= '" + besitzer + "'";
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(query);
        resultSet= preparedStatement.executeQuery();
        while(resultSet.next()){

            number=resultSet.getInt(1);
            questionNumbers.add(number);
        }
        resultSet.close();
        preparedStatement.close();
        return questionNumbers;
    }

    public ArrayList<Integer> randomQuestion(int besitzer, int howMany) throws SQLException {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        ArrayList<Integer> questionNumbersOfBarowner = new ArrayList<>();
        questionNumbersOfBarowner= getQuestionNumbersOfBarowner(besitzer);
        int max=questionNumbersOfBarowner.size();
        int i=0;

        while (i<howMany){

            int index = (int)((Math.random()) * max + 1);
            index = index -1;
            if(index < questionNumbersOfBarowner.size()){
                if(!randomNumber.contains(questionNumbersOfBarowner.get(index))){
                    randomNumber.add(questionNumbersOfBarowner.get(index));
                    i++;
                }
            }

        }
        return randomNumber;
    }


}

