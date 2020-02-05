package Controller;

import Model.Model;
import Model.Repository.SPSRepository;
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

    public Controller() {
    }

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


    public String insertwithdrawal(int accountID, String accountName, String amountToInsert, int rateID) throws SQLException {
        return model.returnBalance(accountID, accountName, amountToInsert, rateID);
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

    public String[] getDropDownBalanceAccounts(int account_id) throws SQLException {
        return spsRepository.balanceAccountlistToArray(account_id);
    }

    public String[] getArrayListUserEmail() throws SQLException {
        return spsRepository.userEmaillistToArray();
    }

    public int getAccountIdWhereEmail(String email) throws SQLException {
        return spsRepository.getAccountIDWhereUserEmail(email);
    }

    public int getAccountIdWhereBalanceAccount(String accountName, String email) throws SQLException {
        return spsRepository.getAccountIDWhereBalanceAccount(accountName, email);
    }

    public List<String> getBalanceHistoryTimePeriod(int account_id, int account_balance_id, String first_date, String second_date) throws SQLException {
        return spsRepository.getBalanceHistoryBetweenTwoDates(account_id, account_balance_id, first_date, second_date);
    }
    public String showPaymentPlanByAccountId(String accountID) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanFixedYear(Integer.parseInt(accountID)));
    }
    public String editPaymentPlanByAccountId(String accountID,int paymentPlan) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanChangeYear(Integer.parseInt(accountID),paymentPlan));
    }

    public int getBalanceIdByName(String balance_Account_Name) throws SQLException {
        return spsRepository.getBalanceAccountIdByName(balance_Account_Name);
    }

    public String getBalanceNameById(int balance_Account_Id) throws SQLException {
        return spsRepository.getBalanceAccountNameById(balance_Account_Id);
    }
    public List<String>getBalanceAccountsForWhereUserId (int accountID) throws SQLException {
        return spsRepository.getBalanceAccountsForWhereUserId(accountID);
    }
    public String[] listToStringArray(List<String> list){
        return spsRepository.listToStringArray(list);
    }

    public String updateUser(int user_id, String user_first_name, String user_last_name, String user_mail) throws SQLException {
        return spsRepository.callUpdateUserFromDB(user_id, user_first_name, user_last_name,user_mail);
    }

    public Boolean createLoanForUser(int accountID, int loanAmount, int rateID) throws SQLException {
        return spsRepository.callCreateLoanForUserFromDB(accountID, loanAmount, rateID);
    }
}


