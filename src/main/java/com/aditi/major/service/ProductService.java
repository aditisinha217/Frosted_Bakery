package com.aditi.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aditi.major.model.Product;
import com.aditi.major.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void addProduct(Product p){
        productRepository.save(p);
    }
    
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> updateProductById(Long id){
        return productRepository.findById(id);
    }


    public List<Product> findProductByCategoryId(int column_id){
        return productRepository.findAllByCategory_Id(column_id);
    }
}