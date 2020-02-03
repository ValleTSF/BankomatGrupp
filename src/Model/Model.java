package Model;


import Model.Repository.*;

import java.sql.SQLException;

public class Model {
    SPSRepository rep = new SPSRepository();


    public int returnAccountID(String password) throws SQLException {
        return rep.callSpVerifyCredentialsPasswordFromDB(password);
    }

}
