package Controller;
import Model.Model;
import Model.Repository.SPSRepository;
import View.ViewGui;
import View.ViewGuiAdmin;

import java.sql.SQLException;
import java.text.DecimalFormat;


public class Controller {

    private ViewGui view;
    private ViewGuiAdmin viewAdmin;
    private Model model = new Model();
    private SPSRepository spsRepository = new SPSRepository();

    public Controller(ViewGui view){
        this.view = view;
    }

    public Controller(ViewGuiAdmin viewAdmin){
        this.viewAdmin = viewAdmin;
    }

    public int getAccountByString(String password) throws SQLException {
        return model.returnAccountID(password);

    }

    public boolean getAccountType(String userName, String password) throws SQLException {
        return model.returnAccountType(userName, password).equalsIgnoreCase("admin");
    }


    public String insertwithdrawal(int accountID, String amountToInsert, int rateID) throws SQLException {
        return model.returnBalance(accountID,amountToInsert,rateID);
    }

    public double getLoanBalance(int kundId) throws SQLException {
        return model.returnLoanBalance(kundId);
    }

    public String showPaymentPlanByAccountId(String accountID) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanFixedYear(Integer.parseInt(accountID)));
    }
    public String editPaymentPlanByAccountId(String accountID,int paymentPlan) throws SQLException {
        DecimalFormat dem = new DecimalFormat("#.##");
        return dem.format(model.paymentPlanChangeYear(Integer.parseInt(accountID),paymentPlan));
    }

    public boolean createUserAccount (int userID, String username, int password) throws SQLException {
        return spsRepository.callCreateUserAccountFromDB(userID, username, password);
    }
}


