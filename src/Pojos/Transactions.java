package Pojos;

import java.sql.Timestamp;

public class Transactions {

    private int id;
    private Account account_id;
    private int amount;
    private Account_Loan account_loan_id;
    private Account_Balance account_balance_id;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Transactions() {
    }

    public Transactions(Account account_id, int amount, Account_Loan account_loan_id, Account_Balance account_balance_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.account_id = account_id;
        this.amount = amount;
        this.account_loan_id = account_loan_id;
        this.account_balance_id = account_balance_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Transactions(int id, Account account_id, int amount, Account_Loan account_loan_id, Account_Balance account_balance_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.account_id = account_id;
        this.amount = amount;
        this.account_loan_id = account_loan_id;
        this.account_balance_id = account_balance_id;
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

    public Account_Loan getAccount_loan_id() {
        return account_loan_id;
    }

    public void setAccount_loan_id(Account_Loan account_loan_id) {
        this.account_loan_id = account_loan_id;
    }

    public Account_Balance getAccount_balance_id() {
        return account_balance_id;
    }

    public void setAccount_balance_id(Account_Balance account_balance_id) {
        this.account_balance_id = account_balance_id;
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
