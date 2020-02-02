package Model.Pojos;

import java.sql.Timestamp;

public class Loan {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private int amountPaid;
    private Rate rate;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Loan() {
    }

    public Loan(UserAccount userAccount, int amount, int amountPaid, Rate rate, Timestamp createdOn, Timestamp lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.rate = rate;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Loan(int id, UserAccount userAccount, int amount, int amountPaid, Rate rate, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.userAccount = userAccount;
        this.amount = amount;
        this.amountPaid = amountPaid;
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

    public int getAmountPaid() {
        return amountPaid;
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
