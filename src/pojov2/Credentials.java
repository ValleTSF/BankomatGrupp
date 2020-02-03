package pojov2;

import java.sql.Timestamp;

public class Credentials {

    private int id;
    private Account account_id;
    private String userName;
    private String passWord;
    private Timestamp createdOn;
    private Timestamp lastUpdated;

    public Credentials() {
    }

    public Credentials(Account account_id, String userName, String passWord, Timestamp createdOn, Timestamp lastUpdated) {
        this.account_id = account_id;
        this.userName = userName;
        this.passWord = passWord;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

    public Credentials(int id, Account account_id, String userName, String passWord, Timestamp createdOn, Timestamp lastUpdated) {
        this.id = id;
        this.account_id = account_id;
        this.userName = userName;
        this.passWord = passWord;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
