package Model.Pojos;

import java.sql.Timestamp;

public class Transactions {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private Loan loan;
    private Savings savings;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Transactions() {
    }

    public Transactions(UserAccount userAccount, int amount, Loan loan, Savings savings, Timestamp createdOn, Timestamp lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.loan = loan;
        this.savings = savings;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Transactions(int id, UserAccount userAccount, int amount, Loan loan, Savings savings, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.userAccount = userAccount;
        this.amount = amount;
        this.loan = loan;
        this.savings = savings;
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

    public Loan getLoan() {
        return loan;
    }

    public Savings getSavings() {
        return savings;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
