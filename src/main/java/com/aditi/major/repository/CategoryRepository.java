package com.aditi.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.major.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
