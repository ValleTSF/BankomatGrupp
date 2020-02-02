package Model;

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

    public Map<Integer, Credentials> mapCategoriesFromDb() {
        Map<Integer, Credentials> credentialsHashMap = new HashMap<>();
        String sqlQuery = "select * from bankomat.credentials";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionURL"),
                pro.getProperty("login"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                credentialsHashMap.put(rs.getInt("id"),
                        new Credentials(rs.getString("category_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryHashMap;
    }

    public static void main(String[] args) {
        Repository repo = new Repository();
    }


}