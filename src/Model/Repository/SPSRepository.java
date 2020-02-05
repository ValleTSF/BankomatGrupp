package Model.Repository;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SPSRepository {

    private Properties pro = new Properties();

    public SPSRepository() {
        try {
            pro.load(new FileInputStream("src\\SQL-Info"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // User Methods

    public void callCreateUserFromDB(String user_first_name, String user_last_name, String user_mail) throws SQLException {

        String sqlQuery = "call create_User(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setString(1, user_first_name);
            pstmt.setString(2, user_last_name);
            pstmt.setString(3, user_mail);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }

    }

    public void callDeleteUserFromDB(int user_id) throws SQLException {

        String sqlQuery = "call delete_User(?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, user_id);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }

    }

    public void callUpdateUserFromDB(int user_id, String user_first_name, String user_last_name, String user_mail) throws SQLException {

        String sqlQuery = "call create_User(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1,user_id);
            pstmt.setString(2, user_first_name);
            pstmt.setString(3, user_last_name);
            pstmt.setString(4, user_mail);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }

    }

    // Account Methods

    public void callCreateUserAccountFromDB(int userID, String newUserName, int newPassword) throws SQLException {

        String sqlQuery = "call createUserAccount(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, userID);
            pstmt.setString(2, newUserName);
            pstmt.setInt(3, newPassword);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }

    }

    public void callDeleteUserAccountFromDB(int userID) throws SQLException {

        String sqlQuery = "call deleteUserAccount(?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();

            System.out.println(rs);

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

    public String callBalanceChangeFromDB(int accountID, String amountToInsert, int rateID) throws SQLException {

        String sqlQuery = "call balanceChange(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, accountID);
            pstmt.setInt(2, Integer.parseInt(amountToInsert));
            pstmt.setInt(3,rateID);
            rs = pstmt.executeQuery();

            return rs+"";

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

    // Currency methods

    public String callBalanceChangeFromDB(int accountID, String amountToInsert, int rateID) throws SQLException {

        String sqlQuery = "call balanceChange(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setInt(1, accountID);
            pstmt.setInt(2, Integer.parseInt(amountToInsert));
            pstmt.setInt(3, rateID);
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

    public List<String> callGetBalanceHistoryForCurrentMonth(int account_id) throws SQLException {
        List<String> his = new ArrayList<>();
        String sqlQuery = " select concat(account_balance.createdOn,' ',account_balance.amount) as balance" +
                " from account_balance" +
                " inner join account on account_balance.account_id = account.id" +
                " inner join user on account.user_id = user.id" +
                " where account.id = ?" +
                " and month(account_balance.createdOn) = month(now())";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareCall(sqlQuery)) {
            stmt.setInt(1, account_id);
            ResultSet rss;
            rss = stmt.executeQuery();

            while (rss.next()){
                his.add(rss.getString("balance"));
            }
        }
        return his;
    }


    public static void main(String[] args) throws SQLException {
        SPSRepository re = new SPSRepository();
      //  re.callGetBalanceHistoryForCurrentMonth(1);
        List<String> ee = re.callGetBalanceHistoryForCurrentMonth(1);
        ee.forEach(System.out::println);


    }
}
