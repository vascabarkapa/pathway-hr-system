package com.hrsystem.pathway.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsystem.pathway.exception.UserNotFoundException;
import com.hrsystem.pathway.model.Employee;
import com.hrsystem.pathway.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " wasn't found!"));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
