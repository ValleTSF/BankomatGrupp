package Model;

import java.time.LocalDateTime;

public class Loan {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private int amountPaid;
    private Rate rate;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public Loan() {
    }

    public Loan(UserAccount userAccount, int amount, int amountPaid, Rate rate, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.rate = rate;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Loan(int id, UserAccount userAccount, int amount, int amountPaid, Rate rate, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
