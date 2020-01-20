package DataLayer;

public class Bar {
    private int id;
    private String surename;
    private String firstname;
    private String street;
    private String city;
    private int post;
    private int telefonenummer;
    private String mail;
    private String BarName;
    private String message;
    private int note;
    private int passwort;

    public Bar (){

    }
    public Bar(int id, String surename, String firstname, String street, String city, int post, int telefonenummer, String mail, String barName, String message, int note, int passwort) {
        this.id = id;
        this.surename = surename;
        this.firstname = firstname;
        this.street = street;
        this.city = city;
        this.post = post;
        this.telefonenummer = telefonenummer;
        this.mail = mail;
        BarName = barName;
        this.message = message;
        this.note = note;
        this.passwort = passwort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getTelefonenummer() {
        return telefonenummer;
    }

    public void setTelefonenummer(int telefonenummer) {
        this.telefonenummer = telefonenummer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBarName() {
        return BarName;
    }

    public void setBarName(String barName) {
        BarName = barName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getPasswort() {
        return passwort;
    }

    public void setPasswort(int passwort) {
        this.passwort = passwort;
    }
}
