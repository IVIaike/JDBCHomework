package dao;
import Objects.Employee;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class EmployeeDAOjdbc implements EmployeeDAO{

    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Employee findById(int id) {
 //       EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return entityManager.createQuery("SELECT e FROM Employee as e", Employee.class).getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.persist(employee);
        transaction.commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.merge(employee);
        transaction.commit();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.remove(employee);
        transaction.commit();
    }
}
