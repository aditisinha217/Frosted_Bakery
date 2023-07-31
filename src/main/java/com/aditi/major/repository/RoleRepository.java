package com.aditi.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.major.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
