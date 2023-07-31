package com.aditi.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.major.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory_Id(int column_id);
}
