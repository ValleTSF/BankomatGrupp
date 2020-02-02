package Model;

import Model.Pojos.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Repository {

    private Properties pro = new Properties();

    public Repository() {
        try {
            pro.load(new FileInputStream("src\\SQL-Info"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Credentials> mapCredentialsFromDb() {
        Map<Integer, Credentials> credentialsHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.credentials";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                credentialsHashMap.put(rs.getInt("id"),
                        new Credentials(rs.getString("admin_username"),
                                        rs.getString("admin_password"),
                                        rs.getTimestamp("createdOn"),
                                        rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentialsHashMap;
    }

    public Map<Integer, TypeOfUser> mapTypeOfUserFromDb() {
        Map<Integer, TypeOfUser> typeOfUserHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.credentials";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                typeOfUserHashMap.put(rs.getInt("id"),
                        new TypeOfUser(rs.getString("userType"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfUserHashMap;
    }

    public Map<Integer, BankUser> mapBankUserFromDb() {
        Map<Integer, BankUser> bankUserHashMap = new HashMap<>();
        Map<Integer, TypeOfUser> typeOfUserHashMap = mapTypeOfUserFromDb();
        String sqlQuery = "select * from bankomat.bank_user";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                bankUserHashMap.put(rs.getInt("id"),
                        new BankUser(rs.getString("first_name"),
                                rs.getString("last_name"),
                                typeOfUserHashMap.get(rs.getInt("userRole")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankUserHashMap;
    }

    public Map<Integer, AdminAccount> mapAdminAccountFromDb() {
        Map<Integer, AdminAccount> adminAccountHashMap = new HashMap<>();
        Map<Integer, BankUser> bankUserHashMap = mapBankUserFromDb();
        Map<Integer, Credentials> credentialsHashMap = mapCredentialsFromDb();

        String sqlQuery = "select * from bankomat.admin_account";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                adminAccountHashMap.put(rs.getInt("id"),
                        new AdminAccount(bankUserHashMap.get(rs.getInt("user_id")),
                                credentialsHashMap.get(rs.getInt("credential_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminAccountHashMap;
    }

    public Map<Integer, UserAccount> mapUserAccountFromDb() {
        Map<Integer, UserAccount> userAccountHashMap = new HashMap<>();
        Map<Integer, BankUser> bankUserHashMap = mapBankUserFromDb();
        Map<Integer, Credentials> credentialsHashMap = mapCredentialsFromDb();

        String sqlQuery = "select * from bankomat.user_account";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                userAccountHashMap.put(rs.getInt("id"),
                        new UserAccount(bankUserHashMap.get(rs.getInt("user_id")),
                                credentialsHashMap.get(rs.getInt("credential_id")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAccountHashMap;
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
                        new Rate(rs.getInt("rate"),
                                rs.getString("rateType"),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rateHashMap;
    }

    public Map<Integer, Savings> mapSavingsFromDb() {
        Map<Integer, Savings> savingsHashMap = new HashMap<>();
        Map<Integer, UserAccount> userAccountHashMap = mapUserAccountFromDb();
        Map<Integer, Rate> rateHashMap = mapRateFromDb();

        String sqlQuery = "select * from bankomat.user_account";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                savingsHashMap.put(rs.getInt("id"),
                        new Savings(
                                userAccountHashMap.get(rs.getInt("user_account")),
                                rs.getInt("amount"),
                                rateHashMap.get(rs.getInt("rate")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savingsHashMap;
    }

    public Map<Integer, Loan> mapLoanFromDb() {
        Map<Integer, Loan> loanHashMap = new HashMap<>();
        Map<Integer, UserAccount> userAccountHashMap = mapUserAccountFromDb();
        Map<Integer, Rate> rateHashMap = mapRateFromDb();

        String sqlQuery = "select * from bankomat.loan";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                loanHashMap.put(rs.getInt("id"),
                        new Loan(
                                userAccountHashMap.get(rs.getInt("user_account")),
                                rs.getInt("amount"),
                                rs.getInt("amount_payed"),
                                rateHashMap.get(rs.getInt("rate")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loanHashMap;
    }

    public Map<Integer, Transactions> mapTransactionsFromDb() {
        Map<Integer, Transactions> transactionsHashMap = new HashMap<>();
        Map<Integer, UserAccount> userAccountHashMap = mapUserAccountFromDb();
        Map<Integer,Savings> savingsHashMap = mapSavingsFromDb();
        Map<Integer, Loan> loanHashMap = mapLoanFromDb();

        String sqlQuery = "select * from bankomat.transactions";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                transactionsHashMap.put(rs.getInt("id"),
                        new Transactions(
                                userAccountHashMap.get(rs.getInt("user_account")),
                                rs.getInt("amount"),
                                loanHashMap.get(rs.getInt("loan")),
                                savingsHashMap.get(rs.getInt("saving")),
                                rs.getTimestamp("createdOn"),
                                rs.getTimestamp("lastUpdated")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionsHashMap;
    }

    public static void main(String[] args) {
        Repository repo = new Repository();
    }


}