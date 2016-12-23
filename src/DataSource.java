import bean.BeanUser;
import payment.IBANCredentialNotValid;
import querySQL.Query;
import sun.text.normalizer.Utility;

import java.sql.*;

public class DataSource {

    private static Connection getConnection(){
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "postgres";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static BeanUser searchUser(String username, String password) {
        try{
            PreparedStatement ps = getConnection().prepareStatement(Query.findRegisteredUser);
            ps.setString(1, username);
            ps.setString(2, UtilityMD5.stringByHashingPassword(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new BeanUser(rs.getString("name"),rs.getString("surname"), rs.getString("city"),
                        rs.getString("address"), rs.getDate("birthdate"), rs.getString("email"),
                        rs.getString("username"), rs.getString("password"), rs.getString("iban"),
                        rs.getInt("scout"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IBANCredentialNotValid ibanCredentialNotValid) {
            ibanCredentialNotValid.printStackTrace();
        }
        return null;
    }
}
