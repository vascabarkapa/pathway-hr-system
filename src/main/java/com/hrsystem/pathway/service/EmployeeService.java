package com.hrsystem.pathway.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsystem.pathway.exception.UserNotFoundException;
import com.hrsystem.pathway.model.Employee;
import com.hrsystem.pathway.repo.EmployeeRepo;

@Service
public class EmployeeService {
    private final EmployeeRepo employee_repo;

    @Autowired
    public EmployeeService(EmployeeRepo employee_repo) {
        this.employee_repo = employee_repo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setCode(UUID.randomUUID().toString());
        return employee_repo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employee_repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employee_repo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employee_repo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " wasn't found!"));
    }

    public void deleteEmployee(Long id) {
        employee_repo.deleteEmployeeById(id);
    }
}
