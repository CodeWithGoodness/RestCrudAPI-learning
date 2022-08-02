package com.goodness.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodness.springweb.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
