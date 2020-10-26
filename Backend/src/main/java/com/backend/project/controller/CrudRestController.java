package com.backend.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.model.Product;
import com.backend.project.service.CrudService;

@RestController
public class CrudRestController {
	@Autowired
	private CrudService service;
	
	@GetMapping("/getproductlist")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> fetchProductList(){
		List<Product> products=new ArrayList<Product>();
		products=service.fetchProductList();
		return products;
	}
	
	@PostMapping("/addproduct")
	@CrossOrigin(origins="http://localhost:4200")
	public Product addProduct(@RequestBody Product p){
		Product product=service.addProduct(p);
		return product;
	}
	
	@GetMapping("/getproduct/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Product getProduct(@PathVariable int id){
		return service.getProduct(id).get();
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public void deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
	}


}
