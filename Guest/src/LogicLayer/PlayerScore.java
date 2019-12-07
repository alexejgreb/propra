package LogicLayer;

public class PlayerScore {

    private int iD_Number;
    private int points;

    public PlayerScore(int iD_Number, int points){
    this.iD_Number = iD_Number;
    this.points = points;
    }

    public int getiD_Number() { return iD_Number; }

    public void setiD_Number(int iD_Number) { this.iD_Number = iD_Number; }

    public int getPoints() { return points; }

    public void setPoints(int points) { this.points = points; }

}
