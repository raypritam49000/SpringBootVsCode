package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Employee;

public interface EmployeeService {
    public abstract void addEmployee(Employee employee);
    public abstract List<Employee> getAllEmployees();
    public abstract Employee getEmployee(int id);
    public abstract Boolean deleteEmployee(int id);
    public abstract Boolean updateEmployee(int id,Employee updateEmployee);
}
