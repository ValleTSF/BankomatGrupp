package Pojos;

import java.sql.Timestamp;

public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String mail_adress;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public User() {
    }

    public User(String first_name, String last_name, String mail_adress, Timestamp createdOn, Timestamp lastUpdated) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail_adress = mail_adress;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public User(int id, String first_name, String last_name, String mail_adress, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail_adress = mail_adress;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail_adress() {
        return mail_adress;
    }

    public void setMail_adress(String mail_adress) {
        this.mail_adress = mail_adress;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
