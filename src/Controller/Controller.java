package Controller;
import Model.Model;
import View.ViewGui;
import View.ViewGuiAdmin;

import java.sql.SQLException;


public class Controller {

    private ViewGui view;
    private ViewGuiAdmin viewAdmin;
    private Model model = new Model();


    public Controller(ViewGui view){
        this.view = view;
    }

    public Controller(ViewGuiAdmin viewAdmin){
        this.viewAdmin = viewAdmin;
    }

    public int getAccountByString(String password) throws SQLException {
        return model.returnAccountID(password);


    }


    public int getAccountByStringAdmin(String userName,String password) throws SQLException {
        return model.returnAccountAdminID(userName,password);


    }


    public String insertwithdrawal(int accountID, String amountToInsert, int rateID) throws SQLException {
        return model.returnBalance(accountID,amountToInsert,rateID);
    }
}


