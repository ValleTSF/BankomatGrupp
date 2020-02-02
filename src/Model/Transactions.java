package Model;

import java.time.LocalDateTime;

public class Transactions {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private Loan loan;
    private Savings savings;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public Transactions() {
    }

    public Transactions(UserAccount userAccount, int amount, Loan loan, Savings savings, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.loan = loan;
        this.savings = savings;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Transactions(int id, UserAccount userAccount, int amount, Loan loan, Savings savings, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
