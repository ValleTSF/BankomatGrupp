package Controller;
import Model.Model;
import Model.Repository.SPSRepository;
import View.ViewGui;
import View.ViewGuiAdmin;

import java.sql.SQLException;


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

    public int getLoanBalance(int kundId) throws SQLException {
        return model.returnLoanBalanc(kundId);
    }

    public boolean createUserAccount (int userID, String username, int password) throws SQLException {
        return spsRepository.callCreateUserAccountFromDB(userID, username, password);
    }
}


