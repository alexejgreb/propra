package LogicLayer;

public class Validator {
    private int tempInt;


    public int stringToInt(String tempString){
        try {
            tempInt = Integer.parseInt(tempString);
        }
            catch (Exception e){
                System.out.println("String kann nicht zum Interger umgewandelt werden!");

        }
        return tempInt;
    }
}
