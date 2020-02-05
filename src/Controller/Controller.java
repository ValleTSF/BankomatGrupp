package Controller;

import Model.Model;
import Model.Repository.SPSRepository;
import Pojos.Rate;
import View.ViewGui;
import View.ViewGuiAdmin;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;


public class Controller {

    private ViewGui view;
    private ViewGuiAdmin viewAdmin;
    private Model model = new Model();
    private SPSRepository spsRepository = new SPSRepository();

    public Controller(ViewGui view) {
        this.view = view;
    }

    public Controller(ViewGuiAdmin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    public int getAccountByString(String password) throws SQLException {
        return model.returnAccountID(password);

    }

    public boolean getAccountType(String userName, String password) throws SQLException {
        return model.returnAccountType(userName, password).equalsIgnoreCase("admin");
    }


    public String insertwithdrawal(int accountID, String amountToInsert, int rateID) throws SQLException {
        return model.returnBalance(accountID, amountToInsert, rateID);
    }

    public double getLoanBalance(int kundId) throws SQLException {
        return model.returnLoanBalance(kundId);
    }

    public boolean createUserAccount(int userID, String username, int password) throws SQLException {
        return spsRepository.callCreateUserAccountFromDB(userID, username, password);
    }

    public boolean deleteUserAccount(int userID) throws SQLException {
        return spsRepository.callDeleteUserAccountFromDB(userID);
    }

    public boolean createUser(String firstName, String lastName, String email) throws SQLException {
        return spsRepository.callCreateUserFromDB(firstName, lastName, email);
    }

    public boolean deleteUser(int userID) throws SQLException {
        return spsRepository.callDeleteUserFromDB(userID);
    }

    public String[] getDropDownAccounts(int account_id) throws SQLException {
        return spsRepository.balanceAccountlistToArray(account_id);
    }

    public String[] getDropDownEmail() throws SQLException {
        return spsRepository.emaillistToArray();
    }
    public Rate[] getDropDownRate() throws SQLException {
        return model.ratelistToArray();
    }

    public int getAccountIdWhereEmail(String email) throws SQLException {
        return spsRepository.getAccountIDWhereUserEmail(email);
    }

    public int getAccountIdWhereBalanceAccount(String accountName, String email) throws SQLException {
        return spsRepository.getAccountIDWhereBalanceAccount(accountName, email);
    }
    public void editLoanRateById(int accountID, int loanRate) throws SQLException {
        model.changeLoanRateByID(accountID, loanRate);
    }
    public void editBalanceRateByAccountName(String balanceAccountName, int loanRate) throws SQLException {
        model.changeBalanceRateByAccountName(balanceAccountName, loanRate);
    }

    public List<String> getBalanceHistoryForMonth(int account_id, String first_date, String second_date) {
        return getBalanceHistoryForMonth(account_id, first_date, second_date);
    }
    public String showPaymentPlanByAccountId(String accountID) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanFixedYear(Integer.parseInt(accountID)));
    }
    public String editPaymentPlanByAccountId(String accountID,int paymentPlan) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanChangeYear(Integer.parseInt(accountID),paymentPlan));
    }
}


