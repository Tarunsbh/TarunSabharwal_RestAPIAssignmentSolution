package com.employeemanagement.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.app.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}