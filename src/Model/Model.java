package Model;


import Model.Repository.*;
import Pojos.Account;
import Pojos.Account_Balance;
import Pojos.Rate;

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

    public String returnBalance(int accountID, String accountName, String amountToInsert, int rateID) throws SQLException {
        return rep.callBalanceChangeFromDB(accountID,accountName,amountToInsert,rateID);
    }
    public double returnLoanBalance(int kundId) throws SQLException {
        return rep.callSpGetLoanFromDB(kundId + "");
    }
    public double returnLoanRate(int kundId) throws SQLException {
        return rep.callSpGetLoanRateFromDB(kundId + "");
    }
    public double balanceOwed(double loanBalance, int paymentInterval, double interestRate) {
        if (paymentInterval == 0) {
            return loanBalance;
        } else {
            return balanceOwed(loanBalance, paymentInterval - 1, interestRate) * (1 + interestRate);
        }
    }
    public Double paymentPlanFixedYear(int accountID) throws SQLException {
        return balanceOwed(returnLoanBalance(accountID), 1, (returnLoanRate(accountID) / 100));
    }
    public Double paymentPlanChangeYear(int accountID, int paymentInterval) throws SQLException {
        return balanceOwed(returnLoanBalance(accountID), paymentInterval, (returnLoanRate(accountID) / 100));
    }
    public void changeLoanRateByID(int accountID, int loanRate) throws SQLException {
        rep.callChangeLoanRateFromDB(accountID, loanRate);
    }
    public void changeBalanceRateByAccountName(String balanceAccountName, int loanRate) throws SQLException {
        rep.callChangeBalanceRateFromDB(balanceAccountName, loanRate);
    }

    public Rate[] ratelistToArray() throws SQLException {
        List<Rate> rateList = rep.getRates();
        return rateList.toArray(new Rate[rateList.size()]);
    }

    public static void main(String[] args) throws SQLException {
        Model model = new Model();
    }


}
