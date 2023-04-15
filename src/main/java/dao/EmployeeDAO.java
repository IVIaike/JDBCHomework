package dao;

import Objects.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    Optional<Employee> findById(int id);
    List<Employee> findAllEmployee();
    Employee addEmployee();
    Employee updateEmployee();
    Employee deleteEmployee();
//    void save (Employee employee);
}
