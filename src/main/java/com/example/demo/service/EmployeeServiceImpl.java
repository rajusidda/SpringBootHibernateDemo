package com.example.demo.service;

import com.example.demo.com.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Transactional
    @Override
    public Employee saveEmp(Employee employee) {

        return employeeRepository.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }
    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployeeByID(id);
    }
    @Transactional
    @Override
    public Employee findByEmployeeID(int id) {

       return  employeeRepository.findEmployeeByID(id);
    }

}
