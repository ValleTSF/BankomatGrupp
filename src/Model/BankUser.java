package Model;

import java.time.LocalDateTime;

public class BankUser {
    private int id;
    private String firstName;
    private String lastName;
    private TypeOfUser typeOfUser;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public BankUser(int id, String firstName, String lastName, TypeOfUser typeOfUser, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
