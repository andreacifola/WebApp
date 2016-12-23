package dataSource;

import bean.BeanUser;
import bean.IBANCredentialNotValid;
import querySQL.Query;

import java.sql.*;

public class DataSource {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection connection = null;
    private static String username = "postgres";
    private static String password = "r.f.arredamenti";

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static BeanUser searchUser(String name) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(Query.countUsername);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                try {
                    return new BeanUser(rs.getString("name"), rs.getString("surname"), rs.getString("city"),
                            rs.getString("address"), rs.getDate("birthdate"), rs.getString("email"),
                            rs.getString("username"), rs.getString("password"), rs.getString("iban"), rs.getInt("scout"));
                } catch (IBANCredentialNotValid ibanCredentialNotValid) {
                    ibanCredentialNotValid.printStackTrace();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
