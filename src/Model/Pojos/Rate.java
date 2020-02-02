package Model.Pojos;

import java.sql.Timestamp;

public class Rate {
    private int id;
    private int rate;
    private String rateType;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Rate() {
    }

    public Rate(int rate, String rateType, Timestamp createdOn, Timestamp lastUpdated) {
        this.rate = rate;
        this.rateType = rateType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Rate(int id, int rate, String rateType, Timestamp createdOn, Timestamp lastUpdated) {
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
