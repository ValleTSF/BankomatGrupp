package Model.Pojos;

import java.sql.Timestamp;

public class Credentials {
    private int id;
    private String adminUsername;
    private String adminPassword;
    private Timestamp createdOn;
    private Timestamp lastUpdated;


    public Credentials() {
    }

    public Credentials(String adminUsername, String adminPassword, Timestamp createdOn, Timestamp lastUpdated) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Credentials(int id, String adminUsername, String adminPassword, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
