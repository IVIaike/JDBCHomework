import Objects.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOjdbc;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOjdbc();

                //Задача 2.3
        Employee employee1 = employeeDAO.addEmployee();
        System.out.println(employee1);

//        //Задача 2.4
//        Employee employee2 = employeeDAO.updateEmployee();
//        System.out.println(employee2);


//        //Задача 2.5
//        Employee employee3 = employeeDAO.deleteEmployee();
//        System.out.println(employee3);

        //Задача 2.2
        Employee employee = employeeDAO.findById(5).get();
        System.out.println(employee);

        //Задача 2.1
        List<Employee> employees = employeeDAO.findAllEmployee();
        System.out.println(employees);

//        //Задача 2.3
//        Employee employee1 = employeeDAO.addEmployee();
//        System.out.println(employee);

//        //Задача 2.4
//        Employee employee2 = employeeDAO.updateEmployee();
//        System.out.println(employee2);


//        //Задача 2.5
//        Employee employee3 = employeeDAO.deleteEmployee();
//        System.out.println(employee3);

    }
}
