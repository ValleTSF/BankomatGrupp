package Pojos;

import java.sql.Timestamp;

public class Account_Balance {

    private int id;
    private Account user_id;
    private int amount;
    private Rate rate_id;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Account_Balance() {
    }

    public Account_Balance(Account user_id, int amount, Rate rate_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.user_id = user_id;
        this.amount = amount;
        this.rate_id = rate_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Account_Balance(int id, Account user_id, int amount, Rate rate_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.user_id = user_id;
        this.amount = amount;
        this.rate_id = rate_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getUser_id() {
        return user_id;
    }

    public void setUser_id(Account user_id) {
        this.user_id = user_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Rate getRate_id() {
        return rate_id;
    }

    public void setRate_id(Rate rate_id) {
        this.rate_id = rate_id;
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
