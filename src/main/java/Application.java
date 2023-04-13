import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
       try (Connection connection = getConnection()) {

       }
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/trainingbase";
        final String name = "postgres";
        final String password = "9245";
        return DriverManager.getConnection(url, name, password);
    }

}
