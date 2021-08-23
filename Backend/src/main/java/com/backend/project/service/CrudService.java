package com.backend.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project.model.Product;
import com.backend.project.repository.CrudRepo;
//service
@Service
public class CrudService {
	
	@Autowired
	private CrudRepo repo;
	public List<Product> fetchProductList(){
	return repo.findAll();	
	}
	public Product addProduct(Product p) {
		return repo.save(p);
	}
	public Optional<Product> getProduct(int p) {
		return repo.findById(p);
	}
	public void deleteProduct(int id) {
		 repo.deleteById(id);
	}

}
