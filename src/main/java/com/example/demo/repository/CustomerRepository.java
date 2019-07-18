package com.example.demo.repository;

import main.java.com.example.demo.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
// On a indiqué l'héritage (cette interface héritant ses fonctionnalités de JPA Repository)
// On a aussi indiqué les types de cette interface (entité "Custumer" et le type de l'ID)
// Et on importe par la même occasion JPA Respository