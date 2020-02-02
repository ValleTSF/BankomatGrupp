package Model.Pojos;

import java.sql.Timestamp;

public class TypeOfUser {
    private int id;
    private String userType;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public TypeOfUser() {
    }

    public TypeOfUser(String userType, Timestamp createdOn, Timestamp lastUpdated) {
        this.userType = userType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public TypeOfUser(int id, String userType, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.userType = userType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
