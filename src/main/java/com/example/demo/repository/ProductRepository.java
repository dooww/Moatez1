package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.java.com.example.demo.model.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
 
}
 // On a indiqué l'héritage (cette interface héritant ses fonctionnalités de JPA Repository)
 // On a aussi indiqué les types de cette interface (entité "Product" et le type de l'ID)
 // Et on importe par la même occasion JPA Respository