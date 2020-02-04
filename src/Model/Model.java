package Model;


import Model.Repository.*;

import java.sql.SQLException;

public class Model {
    SPSRepository rep = new SPSRepository();


    public int returnAccountID(String password) throws SQLException {
        return rep.callSpVerifyCredentialsPasswordFromDB(password);
    }

    public int returnAccountAdminID(String username,String password) throws SQLException {
        return rep.callSpVerifyCredentialsFromDB(username,password);
    }

    public String returnBalance(int accountID, String amountToInsert, int rateID) throws SQLException {
        return rep.callBalanceChangeFromDB(accountID,amountToInsert,rateID);
    }
}
