import Objects.Employee;
import config.HibernateConfig;
import dao.EmployeeDAO;
import dao.EmployeeDAOjdbc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOjdbc();
        employeeDAO.findAllEmployee().forEach(System.out::println);
    }
}
