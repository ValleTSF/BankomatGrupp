package Model;

import java.time.LocalDateTime;

public class Credentials {
    private int id;
    private String adminUsername;
    private String adminPassword;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public Credentials(int id, String adminUsername, String adminPassword, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
