package LogicLayer;

public class Guest {

    private int guestID;
    private String userName;
    private String email;
    private String password;
    private int gameNumber;
    private int iDNumber;
    private int points;
    private int placing;

    public Guest(int guestID, String userName, String email, String password, int gameNumber, int iDNumber){
        this.guestID = guestID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gameNumber = gameNumber;
        this.iDNumber = iDNumber;
        this.points = 0;
        this.placing = 0;
    }
    public int getGuestID() { return guestID; }

    public void setGuestID(int guestID) { this.guestID = guestID; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getGameNumber() { return gameNumber; }

    public void setGameNumber(int gameNumber) { this.gameNumber = gameNumber; }

    public int getIDNumber() { return iDNumber; }

    public void setIDNumber(int iDNumber) { this.iDNumber = iDNumber; }

    public int getPoints() { return points; }

   public void setPoints(int points) { this.points = points; }

   public int getPlacing(){ return placing; }

   public void setPlacing(int placing){ this.placing = placing; }

}
