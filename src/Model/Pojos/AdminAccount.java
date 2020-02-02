package Model.Pojos;

import java.sql.Timestamp;

public class AdminAccount {
    private int id;
    private BankUser bankUser;
    private Credentials credentials;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public AdminAccount() {
    }

    public AdminAccount(BankUser bankUser, Credentials credentials, Timestamp createdOn, Timestamp lastUpdated) {
        this.bankUser = bankUser;
        this.credentials = credentials;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public AdminAccount(int id, BankUser bankUser, Credentials credentials, Timestamp createdOn, Timestamp lastUpdated) {
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
