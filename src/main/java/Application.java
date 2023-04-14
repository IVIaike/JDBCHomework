import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
 //       String query = "SELECT * FROM employee WHERE id=2";
        String query = "SELECT city.city_name, employee.first_name, employee.last_name FROM city JOIN employee ON city.city_id = employee.city_id WHERE id=2";

       try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

           while (resultSet.next()){
               String firstName = resultSet.getString(2);
               String lastName = resultSet.getString(3);
               String gendre = resultSet.getString(4);
               String age = resultSet.getString(5);
               System.out.println((firstName + " " + lastName + " " + gendre + " " + age));
           }
       }catch (SQLException e) {
           System.out.println("Ошибка при подключении к базе данных!");
           e.printStackTrace();
           // Исключение для обработки возможных ошибок при подключении
       }
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/trainingbase";
        final String name = "postgres";
        final String password = "9245";
        return DriverManager.getConnection(url, name, password);
    }

}
