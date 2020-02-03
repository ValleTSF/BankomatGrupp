
package Model;


import java.sql.SQLException;

public class Model {
    Repository rep = new Repository();

    public int returnAccountID(String accountName,String password) throws SQLException {
        return rep.verifyCredentials(accountName,password);
    }

}
