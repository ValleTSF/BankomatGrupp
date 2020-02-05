package Model;


import Model.Repository.*;
import Pojos.Account;
import Pojos.Account_Balance;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Model {
    SPSRepository rep = new SPSRepository();
    MapRepository map = new MapRepository();

    public int returnAccountID(String password) throws SQLException {
        return rep.callSpVerifyCredentialsPasswordFromDB(password);
    }


    public String returnAccountType(String username, String password) throws SQLException {
        String userid =""+rep.callSpVerifyCredentialsFromDB(username,password);
        Map<Integer, Account> accountMap = map.mapAccountFromDb();

        String userTypeId = map.mapAccountFromDb().entrySet().stream()
                .filter(v-> userid.equals(v.getKey().toString())).map(x->x.getValue().getAccount_type_id().getAccount_type())
                .collect(Collectors.joining());
        return userTypeId;

    }
    public List<Integer> returnAccountBalance(String username, String password) throws SQLException {
        String userid =""+rep.callSpVerifyCredentialsFromDB(username,password);
        Map<Integer, Account_Balance> accountBalanceMap = map.mapAccountBalanceLoanFromDb();

        List<Integer> userTypeId = accountBalanceMap.entrySet().stream()
                .filter(v-> userid.equals(v.getKey().toString())).map(x->x.getKey())
                        .collect(Collectors.toList());
        return userTypeId;
    }

    public String returnBalance(int accountID, String amountToInsert, int rateID) throws SQLException {
        return rep.callBalanceChangeFromDB(accountID,amountToInsert,rateID);
    }

    public int returnLoanBalanc(int kundId) throws SQLException {
        return rep.callSpGetLoanFromDB(kundId+"");
    }


    public static void main(String[] args) throws SQLException {
        Model model = new Model();
        System.out.println("Förväntas: [2,5]");
        System.out.println(model.returnAccountBalance("userName1","12345"));
    }


}
