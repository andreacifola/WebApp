package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by andreacifola on 06/09/16.
 */
public class DataSource {

    private static final String JDBC_CONNECTION_URL =
            "jdbc:postgresql://localhost:5432/postgres"; //jdbc:postgresql://localhost:5432/ispw

    private static String user = "postgres",
            password = "r.f.arredamenti";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_CONNECTION_URL, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            getConnection();
    }
}