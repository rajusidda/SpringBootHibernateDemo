package com.example.demo.repository;

import com.example.demo.com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    public List<Employee> findAllEmployees();
    public Employee saveEmployee(Employee employee);
    public Employee findEmployeeByID(int id) ;
    public Employee updateEmployee(Employee employee) ;
    public void deleteEmployeeByID(int id) ;

}
