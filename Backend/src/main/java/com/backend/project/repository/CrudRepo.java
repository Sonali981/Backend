package com.backend.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.model.Product;

public interface CrudRepo extends JpaRepository<Product, Integer> {

}
