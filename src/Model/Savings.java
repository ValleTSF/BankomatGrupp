package Model;

import java.time.LocalDateTime;

public class Savings {
    private int id;
    private UserAccount userAccount;
    private int amount;
    private Rate rate;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public Savings() {
    }

    public Savings(UserAccount userAccount, int amount, Rate rate, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.rate = rate;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Savings(int id, UserAccount userAccount, int amount, Rate rate, LocalDateTime createdOn, LocalDateTime lastUpdated) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
