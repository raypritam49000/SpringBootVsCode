package com.employee.managment.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.managment.system.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}
