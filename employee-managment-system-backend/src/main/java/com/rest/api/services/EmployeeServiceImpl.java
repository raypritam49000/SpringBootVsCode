package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Employee;
import com.rest.api.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Boolean deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateEmployee(int id, Employee updateEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).get();
        if (existingEmployee != null) {
            existingEmployee.setCity(updateEmployee.getCity());
            existingEmployee.setName(updateEmployee.getName());
            existingEmployee.setSalary(updateEmployee.getSalary());
            employeeRepository.save(existingEmployee);
            return true;
        } else {
            return false;
        }
    }

}
