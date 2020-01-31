package Model;

import java.time.LocalDateTime;

public class TypeOfUser {
    private int id;
    private String userType;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public TypeOfUser(int id, String userType, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
