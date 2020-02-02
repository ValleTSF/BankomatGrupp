package Model.Pojos;

import java.sql.Timestamp;

public class Savings {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private Rate rate;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Savings() {
    }

    public Savings(UserAccount userAccount, int amount, Rate rate, Timestamp createdOn, Timestamp lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.rate = rate;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Savings(int id, UserAccount userAccount, int amount, Rate rate, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.userAccount = userAccount;
        this.amount = amount;
        this.rate = rate;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public int getAmount() {
        return amount;
    }

    public Rate getRate() {
        return rate;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
