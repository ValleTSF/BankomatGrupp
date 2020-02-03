package Controller;
import Model.Repository.*;
import Model.Model;
import View.ViewGui;

import java.sql.SQLException;


public class Controller {

    private ViewGui view;
    private Model model = new Model();

    public Controller(ViewGui view){
        this.view = view;
    }

    public int getAccountByString(String password) throws SQLException {
        return model.returnAccountID(password);


    }


}


