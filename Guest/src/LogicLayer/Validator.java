package LogicLayer;

public class Validator {
    private static int tempInt;


    public static boolean stringToInt(String tempString){
        boolean isint = true;
        try {
            tempInt = Integer.parseInt(tempString);
        }
            catch (Exception e){
            isint = false;
                System.out.println("String kann nicht zum Interger umgewandelt werden!");

        }
        return isint;
    }
}
