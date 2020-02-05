package Model.Repository;

import Pojos.Rate;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SPSRepository {

    private Properties pro = new Properties();

    public SPSRepository() {
        try {
            pro.load(new FileInputStream("src/SQL/SQL-Info"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // User Methods

    public Boolean callCreateUserFromDB(String user_first_name, String user_last_name, String user_mail) throws SQLException {

        String sqlQuery = "call create_User(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
//            ResultSet rs;
            pstmt.setString(1, user_first_name);
            pstmt.setString(2, user_last_name);
            pstmt.setString(3, user_mail);
            int r = pstmt.executeUpdate();

            if (r == 0)
                return true;
            else
                return false;

        }

    }

    public Boolean callDeleteUserFromDB(int user_id) throws SQLException {

        String sqlQuery = "call delete_User(?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            pstmt.setInt(1, user_id);
            int r = pstmt.executeUpdate();

            if (r == 0)
                return true;
            else
                return false;

        }

    }

    public String callUpdateUserFromDB(int user_id, String user_first_name, String user_last_name, String user_mail) throws SQLException {

        String sqlQuery = "call update_User(?,?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, user_id);
            pstmt.setString(2, user_first_name);
            pstmt.setString(3, user_last_name);
            pstmt.setString(4, user_mail);
            pstmt.execute();
            int r = pstmt.getUpdateCount();
            System.out.println(pstmt.getUpdateCount());
            System.out.println(r);

            return ""+r;

        }

    }


    // Account Methods

    public Boolean callCreateUserAccountFromDB(int userID, String newUserName, int newPassword) throws SQLException {

        String sqlQuery = "call createUserAccount(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            pstmt.setInt(1, userID);
            pstmt.setString(2, newUserName);
            pstmt.setInt(3, newPassword);
            int r = pstmt.executeUpdate();

            System.out.println("rs= " + r);

            if (r == 0)
                return true;
            else
                return false;
        }

    }

    public boolean callDeleteUserAccountFromDB(int userID) throws SQLException {

        String sqlQuery = "call deleteUserAccount(?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            pstmt.setInt(1, userID);

            int r = pstmt.executeUpdate();

            System.out.println("rs= " + r);

            if (r == 0)
                return true;
            else
                return false;

        }

    }

    // Verification

    public int callSpVerifyCredentialsFromDB(String user_name, String user_password) throws SQLException {

        String sqlQuery = "call sp_verifyCredentials(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             CallableStatement pstmt = con.prepareCall(sqlQuery)) {

            pstmt.setString(1, user_name);
            pstmt.setString(2, user_password);
            pstmt.registerOutParameter(3, Types.INTEGER);
            pstmt.execute();

            return pstmt.getInt(3);

        }

    }

    public int callSpVerifyCredentialsPasswordFromDB(String user_password) throws SQLException {

        String sqlQuery = "call sp_verifyCredentials_pw(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             CallableStatement pstmt = con.prepareCall(sqlQuery)) {

            pstmt.setString(1, user_password);
            pstmt.registerOutParameter(2, Types.INTEGER);
            pstmt.execute();

            return pstmt.getInt(2);

        }

    }

    // Currency methods

    public String callBalanceChangeFromDB(int accountID, String accountName, String amountToInsert, int rateID) throws SQLException {
    public List<Rate> getRates() throws SQLException {
        List<Rate> rateList = new ArrayList<>();
        String sqlQuery = "select * from rate";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             CallableStatement stmt = con.prepareCall(sqlQuery)) {
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()){
                rateList.add(new Rate(rss.getDouble("rate"),rss.getString("rateType")));
            }
        }
        return rateList;
    }


    public void callChangeBalanceRateFromDB(String balanceAccountName, int rateID) throws SQLException {

        String sqlQuery = "call sp_change_balance_rate_by_account_name(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setString(1, balanceAccountName);
            pstmt.setInt(2, rateID);
            rs = pstmt.executeQuery();
        }
    }
    public void callChangeLoanRateFromDB(int accountID, int rateID) throws SQLException {

        String sqlQuery = "call sp_change_loan_rate_by_account_id(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, accountID);
            pstmt.setInt(2, rateID);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }
    }

    public String callBalanceChangeFromDB(int accountID, String amountToInsert, int rateID) throws SQLException {

        String sqlQuery = "call balanceChange(?,?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, accountID);
            pstmt.setString(2, accountName);
            pstmt.setInt(3, Integer.parseInt(amountToInsert));
            pstmt.setInt(4, rateID);
            rs = pstmt.executeQuery();

            return rs + "";

        }

    }

    public void callPayBackLoanFromDB(int account_loan_id, int pay_back_amount) throws SQLException {

        String sqlQuery = "call balanceChange(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, account_loan_id);
            pstmt.setInt(2, pay_back_amount);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }
    }

    public int callSpGetLoanFromDB(String account_id) throws SQLException {

        String sqlQuery = "call sp_get_loan_amount_by_account_id(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             CallableStatement pstmt = con.prepareCall(sqlQuery)) {

            pstmt.setString(1, account_id);
            pstmt.registerOutParameter(2, Types.INTEGER);
            pstmt.execute();

            return pstmt.getInt(2);

        }

    }
            }
        }
        public double callSpGetLoanRateFromDB(String account_id) throws SQLException {

            String sqlQuery = "call sp_get_rate_by_account_id(?,?)";
            try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                    pro.getProperty("login"),
                    pro.getProperty("password"));
                 CallableStatement pstmt = con.prepareCall(sqlQuery)) {

                pstmt.setString(1, account_id);
                pstmt.registerOutParameter(2, Types.DOUBLE);
                pstmt.execute();
                return pstmt.getInt(2);
            }
        }

    public List<String> getBalanceHistoryForCurrentMonth(int account_id) throws SQLException {
        List<String> his = new ArrayList<>();
        String sqlQuery = "select concat(transactions.createdOn,' ', transactions.amount) as balance\n" +
                "                from transactions\n" +
                "                inner join account on transactions.account_id = account.id\n" +
                "                where account.id = ? and account_loan_id is null\n" +
                "                and month(transactions.createdOn) = month(now())";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, account_id);
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()) {
                his.add(rss.getString("balance"));
            }
        }
        return his;
    }

    // formatet på datum måste vara åååå-mm-dd, testa mellan 2020-02-05 och 2020-02-06
    public List<String> getBalanceHistoryBetweenTwoDates(int account_id, int account_balance_id, String first_date, String second_date) throws SQLException {
        List<String> balanceHistoryList = new ArrayList<>();
        String sqlQuery = "select concat(transactions.createdOn, '              ', transactions.amount) as balance " +
                "from transactions " +
                "         inner join account on transactions.account_id = account.id" +
                "         inner join account_balance on account.id = account_balance.account_id" +
                " " +
                "  where account.id = ?" +
                "  and account_loan_id is null" +
                "  and account_balance_id = ? " +
                "  and date(transactions.createdOn) >= ?" +
                "  and date(transactions.createdOn) <= ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, account_id);
            stmt.setInt(2, account_balance_id);
            stmt.setString(3, first_date);
            stmt.setString(4, second_date);
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()){
                balanceHistoryList.add(rss.getString("balance"));
            }
        }
        return balanceHistoryList;
    }

    // formatet på datum måste vara åååå-mm-dd, testa mellan 2020-02-05 och 2020-02-06
    public List<String> getLoanHistoryBetweenTwoDates(int account_id, String first_date, String second_date) throws SQLException {
        List<String> his = new ArrayList<>();
        String sqlQuery = "select concat(transactions.createdOn,' ', transactions.amount) as balance\n" +
                "from transactions\n" +
                "         inner join account on transactions.account_id = account.id\n" +
                "where account.id = 1 and account_balance_id is null\n" +
                "  and date(transactions.createdOn) >= ?\n" +
                "  AND date(transactions.createdOn) <= ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, account_id);
            stmt.setString(2, first_date);
            stmt.setString(3, second_date);
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()) {
                his.add(rss.getString("balance"));
            }
        }
        return his;
    }

    public List<String> getBalanceAccountsForWhereUserId(int account_id) throws SQLException {
        List<String> accountList = new ArrayList<>();
        String sqlQuery = "select balance_account_name  from account_balance" +
                " where account_id = ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, account_id);
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()) {
                accountList.add(rss.getString("balance_account_name"));
            }
        }
        return accountList;
    }

    public String[] listToArray(int account_id) throws SQLException {
        List<String> accountList = getBalanceAccountsForWhereUserId(account_id);
        return accountList.toArray(new String[getBalanceAccountsForWhereUserId(account_id).size()]);
    }

    public String[] balanceAccountlistToArray(int account_id) throws SQLException {
        List<String> accountList = getBalanceAccountsForWhereUserId(account_id);
        return accountList.toArray(new String[getBalanceAccountsForWhereUserId(account_id).size()]);
    }

    public String[] userEmaillistToArray() throws SQLException {
        List<String> emailList = getAllUsersEmailFromDb();
        return emailList.toArray(new String[emailList.size()]);
    }
    public List<String> getAllUsersEmailFromDb() throws SQLException  {
        List<String> emailList = new ArrayList<>();
        String sqlQuery = "select email from bankomat.user " +
                "inner join account on user.id = account.user_id " +
                "inner join account_type on account.account_type_id = account_type.id " +
                "where account_type = 'USER'";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rss;
            rss = stmt.executeQuery(sqlQuery);

            while (rss.next()) {
                emailList.add(rss.getString("email"));
            }

        }
        return emailList;
    }
    public int getBalanceAccountIdByName(String accountName) throws SQLException {
        String sqlQuery = "select account_balance.id from account_balance " +
                "where balance_account_name = ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setString(1, accountName);
            ResultSet rss = stmt.executeQuery();
            int returnNumber = 0;
            if(rss.next()){
                returnNumber = rss.getInt("account_balance.id");
            }

             return returnNumber;
        }
    }

    public String getBalanceAccountNameById(int balance_account_id) throws SQLException {
        String sqlQuery = "select balance_account_name from account_balance " +
                "where account_balance.id = ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, balance_account_id);
            ResultSet rss = stmt.executeQuery();
            String returnString = null;
            if(rss.next()){
                returnString = rss.getString("balance_account_name");
            }
            return returnString;
        }
    }



    public int getAccountIDWhereUserEmail(String email_adress) throws SQLException {
        String sqlQuery = "select account.id from account " +
                "inner join user on account.user_id = user.id " +
                "where email = ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setString(1, email_adress);
            ResultSet rss = stmt.executeQuery();
            int returnValue = 0;
            if(rss.next()){
                returnValue = rss.getInt("account.id");
            }
            return returnValue;
        }
    }

    public int getAccountIDWhereBalanceAccount(String accountName, String email) throws SQLException {
        String sqlQuery = "select account.id from account " +
                "inner join account_balance on account.id = account_id " +
                "inner join user on account.user_id = user.id " +
                "where balance_account_name = ? " +
                "and email = ?";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setString(1, accountName);
            stmt.setString(2, email);
            ResultSet rss = stmt.executeQuery();
            rss.next();
            int returnInt = 0;

            if(rss.next()){
                returnInt = rss.getInt("account.id");
            }

            return returnInt;
        }
    }

    public void callChangeBalanceRateFromDB(String balanceAccountName, int rateID) throws SQLException {

        String sqlQuery = "call sp_change_balance_rate_by_account_name(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setString(1, balanceAccountName);
            pstmt.setInt(2, rateID);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }
    }

    public void callChangeLoanRateFromDB(int accountID, int rateID) throws SQLException {

        String sqlQuery = "call sp_change_balance_rate_by_account_name(?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, accountID);
            pstmt.setInt(2, rateID);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }
    }

    public double callSpGetLoanRateFromDB(String account_id) throws SQLException {


    public static void main(String[] args) throws SQLException {
        SPSRepository re = new SPSRepository();

            //2020-02-05 och 2020-02-06
            //List<String> his = re.getBalanceHistoryBetweenTwoDates(1,"2020-02-05","2020-02-06");
            //his.forEach(System.out::println);
            //re.callCreateUserAccountFromDB(1,"SwagMAnJones", 9999);

        //2020-02-05 och 2020-02-06
//        List<String> his = re.getBalanceHistoryBetweenTwoDates(1, 19 ,"2020-02-05","2020-02-06");
//        his.forEach(System.out::println);
//        re.callCreateUserAccountFromDB(1,"SwagMAnJones", 9999);
        System.out.println( re.getBalanceAccountIdByName("Balance_konto1"));

    }

    public String[] listToStringArray(List<String> list) {
        String[] array = new String[list.size()];
        int i = 0;
        for (String account : list) {
            array[i] = account;
            i++;
        }
        return array;
    }

    public Boolean callCreateLoanForUserFromDB(int accountID, int loanAmount, int rateID) throws SQLException {

        String sqlQuery = "call createLoanForUser(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             CallableStatement pstmt = con.prepareCall(sqlQuery)) {

            pstmt.setInt(1, accountID);
            pstmt.setInt(2, loanAmount);
            pstmt.setInt(3, rateID);
            int r = pstmt.executeUpdate();

            System.out.println("rs= " + r);

            if (r == 0)
                return true;
            else
                return false;

        }
    }

}
