package dao;
import Objects.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOjdbc implements EmployeeDAO{

    @Override
    public Optional<Employee> findById(int id) {
        final String query = "SELECT * FROM employee WHERE id=?";

        try (Connection connection = getConnection()){
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1,id);
             ResultSet resultSet = statement.executeQuery();
             resultSet.next();
             String first_name = resultSet.getString(2);
             String last_name = resultSet.getString(3);
             String gender = resultSet.getString(4);
             Integer age = resultSet.getInt(5);
             Employee employee = new Employee(id, first_name, last_name, gender, age);

             return Optional.ofNullable(employee);

        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        final String query = "SELECT * FROM employee";

        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer age = resultSet.getInt(5);
                employees.add(new Employee(id, firstName, lastName, gender, age));
            }

        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee addEmployee() {
        final String query = "INSERT INTO employee VALUES (1, 'Mikhail', 'Ivanov', 'Man', 42)";

        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeLargeUpdate(query);
        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee updateEmployee() {
        final String query = "UPDATE employee SET first_name = 'Valery', last_name = 'Chkalov', age = 27 WHERE id = 1";

        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeLargeUpdate(query);
        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee deleteEmployee() {
        final String query = "DELETE FROM employee WHERE ID = 1";

        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeLargeUpdate(query);
        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/trainingbase";
        final String name = "postgres";
        final String password = "9245";
        return DriverManager.getConnection(url, name, password);
    }
}
