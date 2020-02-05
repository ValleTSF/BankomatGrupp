package Model.Repository;

import Pojos.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapRepository {

    private Properties pro = new Properties();

    public MapRepository() {
        try {
            pro.load(new FileInputStream("src/SQL-Info"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, User> mapUserFromDb() {
        Map<Integer, User> userHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.user";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                userHashMap.put(rs.getInt("id"),
                        new User(rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userHashMap;
    }

    public Map<Integer, Rate> mapRateFromDb() {
        Map<Integer, Rate> rateHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.rate";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                rateHashMap.put(rs.getInt("id"),
                        new Rate(
                                rs.getDouble("rate"),
                                rs.getString("rateType"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rateHashMap;
    }

    public Map<Integer, Account_Type> mapAccountTypeFromDb() {
        Map<Integer, Account_Type> accountTypeHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.account_type";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                accountTypeHashMap.put(rs.getInt("id"),
                        new Account_Type(
                                rs.getString("account_type"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountTypeHashMap;
    }

    public Map<Integer, Account> mapAccountFromDb() {
        Map<Integer, Account> accountHashMap = new HashMap<>();
        Map<Integer, User> userHashMap = mapUserFromDb();
        Map<Integer, Account_Type> accountTypeHashMap = mapAccountTypeFromDb();
        String sqlQuery = "select * from bankomat.account";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                accountHashMap.put(rs.getInt("id"),
                        new Account(
                                userHashMap.get(rs.getInt("user_id")),
                                accountTypeHashMap.get(rs.getInt("account_type_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountHashMap;
    }

    public Map<Integer, Account_Loan> mapAccountLoanFromDb() {
        Map<Integer, Account_Loan> accountLoanHashMap = new HashMap<>();
        Map<Integer, Account> accountHashMap = mapAccountFromDb();
        Map<Integer, Rate> rateHashMap = mapRateFromDb();
        String sqlQuery = "select * from bankomat.account_loan";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                accountLoanHashMap.put(rs.getInt("id"),
                        new Account_Loan(
                                accountHashMap.get(rs.getInt("account_id")),
                                rs.getInt("amount"),
                                rs.getInt("amount_payed"),
                                rateHashMap.get(rs.getInt("rate_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountLoanHashMap;
    }

    public Map<Integer, Account_Balance> mapAccountBalanceLoanFromDb() {
        Map<Integer, Account_Balance> accountBalanceHashMap = new HashMap<>();
        Map<Integer, Account> accountHashMap = mapAccountFromDb();
        Map<Integer, Rate> rateHashMap = mapRateFromDb();
        String sqlQuery = "select * from bankomat.account_balance";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                accountBalanceHashMap.put(rs.getInt("id"),
                        new Account_Balance(
                                accountHashMap.get(rs.getInt("account_id")),
                                rs.getInt("amount"),
                                rateHashMap.get(rs.getInt("rate_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountBalanceHashMap;
    }

    public Map<Integer, Credentials> mapCredentialsFromDb() {
        Map<Integer, Credentials> credentialsHashMap = new HashMap<>();
        Map<Integer, Account> accountHashMap = mapAccountFromDb();
        String sqlQuery = "select * from bankomat.credentials";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                credentialsHashMap.put(rs.getInt("id"),
                        new Credentials(
                                accountHashMap.get(rs.getInt("account_id")),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentialsHashMap;
    }

    public Map<Integer, Transactions> mapTransactionsFromDb() {
        Map<Integer, Transactions> transactionsHashMap = new HashMap<>();
        Map<Integer, Account> accountHashMap = mapAccountFromDb();
        Map<Integer, Account_Loan> account_loanMap = mapAccountLoanFromDb();
        Map<Integer, Account_Balance> account_BalanceMap = mapAccountBalanceLoanFromDb();
        String sqlQuery = "select * from bankomat.transactions";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                transactionsHashMap.put(rs.getInt("id"),
                        new Transactions(
                                accountHashMap.get(rs.getInt("account_id")),
                                rs.getInt("amount"),
                                account_loanMap.get(rs.getInt("account_loan_id")),
                                account_BalanceMap.get(rs.getInt("account_balance_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionsHashMap;
    }

    public static void main(String[] args) throws SQLException {
        MapRepository r = new MapRepository();
        Map<Integer, Transactions> transactionsMap = r.mapTransactionsFromDb();

    }

}


