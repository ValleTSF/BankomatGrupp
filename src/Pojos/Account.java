package Pojos;

import java.sql.Timestamp;

public class Account {
    private int id;
    private User user_id;
    private String account_name;
    private Account_Type account_type_id;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Account() {
    }

    public Account(User user_id, String account_name, Account_Type account_type_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.user_id = user_id;
        this.account_name = account_name;
        this.account_type_id = account_type_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Account(int id, User user_id, String account_name, Account_Type account_type_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.user_id = user_id;
        this.account_name = account_name;
        this.account_type_id = account_type_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Account_Type getAccount_type_id() {
        return account_type_id;
    }

    public void setAccount_type_id(Account_Type account_type_id) {
        this.account_type_id = account_type_id;
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
        return "Account{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", account_type_id=" + account_type_id +
                ", createdOn=" + createdOn +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
