package LogicLayer;

public class Admin {


    private int master;
    private String user;
    private String password;
    private int id;

    public Admin(int id, String user , String password, int master){
        this.id=id;
        this.user=user;
        this.password=password;
        this.master=master;
    }

    //Getter and Setter

    public int getMaster() {
        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
