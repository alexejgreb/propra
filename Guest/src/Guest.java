public class Guest {

    private int guestID;
    private String userName;
    private String email;
    private String password;
    ///private int points;

    public Guest(int guestID, String userName, String email, String password){
        this.guestID = guestID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public int getGuestID() { return guestID; }

    public void setGuestID(int guestID) { this.guestID = guestID; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

   // public int getPoints() { return points; }

   // public void setPoints(int points) { this.points = points; }

}
