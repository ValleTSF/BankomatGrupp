package Model;

import java.time.LocalDateTime;

public class Rate {
    private int id;
    private int rate;
    private String rateType;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;

    public Rate() {
    }

    public Rate(int rate, String rateType, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.rate = rate;
        this.rateType = rateType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Rate(int id, int rate, String rateType, LocalDateTime createdOn, LocalDateTime lastUpdated) {
        this.id = id;
        this.rate = rate;
        this.rateType = rateType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getRateType() {
        return rateType;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
