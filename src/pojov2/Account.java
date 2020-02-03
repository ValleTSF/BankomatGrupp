package pojov2;

import java.sql.Timestamp;

public class Account {
    private int id;
    private User user_id;
    private Account_Type account_type_id;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Account() {
    }


    public Account(User user_id, Account_Type account_type_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.user_id = user_id;
        this.account_type_id = account_type_id;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Account(int id, User user_id, Account_Type account_type_id, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.user_id = user_id;
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
}
