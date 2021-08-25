package com.backend.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.backend.project.model.Product;
import com.backend.project.service.CrudService;

@ExtendWith(MockitoExtension.class)
public class CrudRestControllerTest {
	
   @InjectMocks
   private CrudRestController crudRestController;
   
   @Mock
   private CrudService crudService;
   
   @Test
   public void fetchProductListTest() {
	   List<Product> productList=new ArrayList<Product>();
		Product p1=new Product(1,"sonali","software engineer",30000);
		Product p2=new Product(2,"pranali","civil services",40000);
		productList.add(p1);
		productList.add(p2);
		when(crudService.fetchProductList()).thenReturn(productList);
		assertEquals(2, crudRestController.fetchProductList().size());
   }
   
   @Test
   public void addProductTest() {
		Product p1=new Product(1,"sonali","software engineer",30000);
		when(crudService.addProduct(p1)).thenReturn(p1);
		assertEquals(p1,crudRestController.addProduct(p1));
  
   }
   
   @Test
   public void getProductTest() {
		Optional<Product> p1=Optional.ofNullable(new Product(1,"sonali","software engineer",30000));
		when(crudService.getProduct(1)).thenReturn(p1);
		assertEquals(p1.get(),crudRestController.getProduct(1));

   }
   
   @Test
   public void deleteProductTest() {
	   crudRestController.deleteProduct(1);
	   verify(crudService,times(1)).deleteProduct(1);
   }

}
