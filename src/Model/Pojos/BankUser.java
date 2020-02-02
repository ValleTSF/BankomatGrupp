package Model.Pojos;

import java.sql.Timestamp;

public class BankUser {
    private int id;
    private String firstName;
    private String lastName;
    private TypeOfUser typeOfUser;
    private Timestamp createdOn;
    private Timestamp lastUpdated;


    public BankUser() {
    }

    public BankUser(String firstName, String lastName, TypeOfUser typeOfUser, Timestamp createdOn, Timestamp lastUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfUser = typeOfUser;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public BankUser(int id, String firstName, String lastName, TypeOfUser typeOfUser, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfUser = typeOfUser;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
