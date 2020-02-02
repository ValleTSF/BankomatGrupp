package Model;

import java.time.LocalDateTime;

public class AdminAccount {
    private int id;
    private BankUser bankUser;
    private Credentials credentials;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public AdminAccount() {
    }

    public AdminAccount(BankUser bankUser, Credentials credentials, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.bankUser = bankUser;
        this.credentials = credentials;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public AdminAccount(int id, BankUser bankUser, Credentials credentials, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.id = id;
        this.bankUser = bankUser;
        this.credentials = credentials;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public BankUser getBankUser() {
        return bankUser;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
