package Controller;

import Model.Model;
import View.ViewGui;

import java.sql.SQLException;


public class Controller {
    ViewGui view;
    Model mod = new Model();

    public Controller(ViewGui view) {
        this.view = view;
    }

    public int getAccountByString(String accountName, String password) throws SQLException {
        return mod.returnAccountID(accountName,password);


    }

}