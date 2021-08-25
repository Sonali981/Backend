package com.backend.project.service;

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
import com.backend.project.repository.CrudRepo;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {
	
@InjectMocks
private CrudService crudService;

@Mock
private CrudRepo crudRepo;

@Test
public void fetchProductListTest() {
	List<Product> productList=new ArrayList<Product>();
	Product p1=new Product(1,"sonali","software engineer",30000);
	Product p2=new Product(2,"pranali","civil services",40000);
	productList.add(p1);
	productList.add(p2);
	when(crudRepo.findAll()).thenReturn(productList);
	assertEquals(2,crudService.fetchProductList().size());
}

@Test
public void addProductTest() {
	Product p1=new Product(1,"dubu","software engineer",30000);
	when(crudRepo.save(p1)).thenReturn(p1);
	assertEquals(p1,crudService.addProduct(p1));
}

@Test
public void getProductTest() {
	Optional<Product> p1=Optional.ofNullable(new Product(1,"dubu","software engineer",30000));
	when(crudRepo.findById(1)).thenReturn(p1);
	assertEquals(p1, crudService.getProduct(1));
	
}

@Test
public void deleteProductTest() {
	crudService.deleteProduct(1);
	verify(crudRepo,times(1)).deleteById(1);
}

}
