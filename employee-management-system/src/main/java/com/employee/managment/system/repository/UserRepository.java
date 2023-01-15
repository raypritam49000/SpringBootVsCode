package com.employee.managment.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.managment.system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
