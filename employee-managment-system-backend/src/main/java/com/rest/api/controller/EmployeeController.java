package com.rest.api.controller;

import java.util.List;
import java.util.Map;

import com.rest.api.entity.Employee;
import com.rest.api.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            if (employees != null && employees.size() > 0) {
                return new ResponseEntity<>(employees, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "DATA_NOT_FOUND", "status", 404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage(), "status", 501),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            if (employee != null && !employee.getName().equals("")) {
                this.employeeService.addEmployee(employee);
                return new ResponseEntity<>(Map.of("message", "Create Employee Successfully", "status", "201"),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "BAD_REQUEST", "status", "201"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage(), "status", 501),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
        try {
            Employee employee = employeeService.getEmployee(id);
            if (employee != null && !employee.getName().equals("")) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "DATA_NOT_FOUND", "status", 404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage(), "status", 501),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        try {
            Boolean result = employeeService.deleteEmployee(id);
            if (result) {
                return new ResponseEntity<>(Map.of("message", "Delete Employee Successfully", "status", 204), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "DATA_NOT_DELETE", "status", 502), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage(), "status", 501),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") int id,@RequestBody Employee updateEmployee) {
        try {
            Boolean result = employeeService.updateEmployee(id, updateEmployee);
            if (result) {
                return new ResponseEntity<>(Map.of("message", "Update Employee Successfully", "status", 204), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "DATA_NOT_UPDATE", "status", 502), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage(), "status", 501),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
