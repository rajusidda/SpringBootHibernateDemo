package com.example.demo.repository;

import com.example.demo.com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllEmployees() {
      Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
      //session.saveOrUpdate(employee);
        Object merge = session.merge(employee);
        System.out.println("merge = " + merge);
        Employee emp = (Employee) merge;
        return emp;
    }

    @Override
    public Employee findEmployeeByID(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.update(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeByID(int id) {

        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);

    }
}
