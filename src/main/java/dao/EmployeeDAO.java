package dao;

import Objects.Employee;

import java.util.List;

public interface EmployeeDAO {


    Employee findById(int id);
    List<Employee> findAllEmployee();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
//    void save (Employee employee);
}
