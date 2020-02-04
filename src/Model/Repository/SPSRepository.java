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
