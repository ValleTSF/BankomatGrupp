package Pojos;

import java.sql.Timestamp;

public class Account_Type {
    private int id;
    private String account_type;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Account_Type() {
    }

    public Account_Type(String account_type, Timestamp createdOn, Timestamp lastUpdated) {
        this.account_type = account_type;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Account_Type(int id, String account_type, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.account_type = account_type;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
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
        return "Account_Type{" +
                "id=" + id +
                ", account_type='" + account_type + '\'' +
                ", createdOn=" + createdOn +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
