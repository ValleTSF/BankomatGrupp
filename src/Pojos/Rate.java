package Pojos;

import java.sql.Timestamp;

public class Rate {

    private int id;
    private double rate;
    private String rateType;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Rate() {
    }
    public Rate(double rate, String rateType) {
        this.rate = rate;
        this.rateType = rateType;
    }

    public Rate(double rate, String rateType, Timestamp createdOn, Timestamp lastUpdated) {
        this.rate = rate;
        this.rateType = rateType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Rate(int id, double rate, String rateType, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.rate = rate;
        this.rateType = rateType;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
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

    @Override
    public String toString() {
        return rateType + " value: " + rate;
    }
}
