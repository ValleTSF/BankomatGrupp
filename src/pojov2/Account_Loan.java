package pojov2;

import java.sql.Timestamp;

public class Account_Loan {

    private int id;
    private Account account_id;
    private int amount;
    private int amount_paid;
    private Rate rate_id;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Account_Loan() {
    }

    public Account_Loan(Account account_id, int amount, int amount_paid, Rate rate_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.account_id = account_id;
        this.amount = amount;
        this.amount_paid = amount_paid;
        this.rate_id = rate_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Account_Loan(int id, Account account_id, int amount, int amount_paid, Rate rate_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.account_id = account_id;
        this.amount = amount;
        this.amount_paid = amount_paid;
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

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(int amount_paid) {
        this.amount_paid = amount_paid;
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
