package Model.Repository;

import Model.Model;

import java.io.FileInputStream;
import java.sql.*;
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

    public void callCreateUserFromDB(String user_first_name, String user_last_name, int user_userRoler) throws SQLException {

        String sqlQuery = "call createUser(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
            ResultSet rs;
            pstmt.setString(1, user_first_name);
            pstmt.setString(2, user_last_name);
            pstmt.setInt(3, user_userRoler);
            rs = pstmt.executeQuery();

            System.out.println(rs);

        }

    }

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

        String sqlQuery = "call createUserAccount(?)";
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


    public static void main(String[] args) throws SQLException {

        SPSRepository sps = new SPSRepository();
        System.out.println(sps.callSpVerifyCredentialsFromDB("userName1","12345"));
        System.out.println(sps.callSpVerifyCredentialsPasswordFromDB("12345"));

    }
}
