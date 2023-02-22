package com.deverything.candidate.productstore.products.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductObject;
import com.deverything.candidate.productstore.products.exception.NoExistProductsException;
import com.deverything.candidate.productstore.products.exception.NoFoundProductException;
import com.deverything.candidate.productstore.products.repository.I_ProductsRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private I_ProductsRepository productsRepository;

	
	@InjectMocks
	ProductService productService;
	
	ProductDomain productDomain;
	ProductDomain productDomain2;
	
	@BeforeEach
	public void init() {
		
		this.productDomain= new ProductDomain(1, "XBOX", 1234.7, 34.8, 45.80);
		
	}
	
	
	@Test
	public void findAllProductsTest() {
		//GIVEN
		Mockito.when(productsRepository.findAll()).thenReturn(List.of(productDomain));
		
		//WHEN
		List<ProductObject> resp = productService.findAllProducts();
		
		//THEN
		Assertions.assertTrue(resp!=null);
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
		Assertions.assertTrue(resp.get(0).getProdDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getProdPrice()==productDomain.getPrice());
		
		
	}
	
	

	@Test
	public void findAllProducts_NoExistsTest() {
		//GIVEN
		Mockito.when(productsRepository.findAll()).thenReturn(null);
		
		//WHEN
		NoExistProductsException exception = assertThrows(NoExistProductsException.class, () -> {
			productService.findAllProducts();
		    });
        
		//THEN
		 assertTrue("There are no products".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void findAllProductsByPriceGreaterthanTest() {
		//GIVEN
		Mockito.when(productsRepository.findByPriceGreaterThan(Mockito.anyDouble())).thenReturn(List.of(productDomain));
		
		//WHEN
		List<ProductObject> resp = productService.findAllProductsByPriceGreaterthan(300D);
		
		//THEN
		Assertions.assertTrue(resp!=null);
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
		Assertions.assertTrue(resp.get(0).getProdDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getProdPrice()==productDomain.getPrice());
		
	}
	
	@Test
	public void findAllProductsByPriceGreaterthanTest_NoExistsTest() {
		//GIVEN
		Mockito.when(productsRepository.findByPriceGreaterThan(Mockito.anyDouble())).thenReturn(null);
		
		//WHEN
		NoExistProductsException exception = assertThrows(NoExistProductsException.class, () -> {
			 productService.findAllProductsByPriceGreaterthan(300D);
		    });
        
		//THEN
		 assertTrue("There are no products".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.NOT_FOUND);
	}
	
	
	@Test
	public void findProductsByIdTest() {
		//GIVEN
		Mockito.when(productsRepository.findByProdidIn(Mockito.anyList())).thenReturn(List.of(productDomain));
		
		//WHEN
		List<ProductDomain> resp = productService.findProductsById(List.of(1));
		
		//THEN
		Assertions.assertTrue(resp!=null);
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
		Assertions.assertTrue(resp.get(0).getDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getPrice()==productDomain.getPrice());
		Assertions.assertTrue(resp.get(0).getWidth()==productDomain.getWidth());
		Assertions.assertTrue(resp.get(0).getHeigh()==productDomain.getHeigh());
		
	}
	
	
	@Test
	public void findProductsById_NoExistsTest() {
		//GIVEN
		Mockito.when(productsRepository.findByProdidIn(Mockito.anyList())).thenReturn(null);
		
		//WHEN
		//WHEN
		NoExistProductsException exception = assertThrows(NoExistProductsException.class, () -> {
			List<ProductDomain> resp = productService.findProductsById(List.of(1));
		    });
		
		//THEN
		 assertTrue("There are no products".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.NOT_FOUND);
		
	}
	
	
	@Test
	public void findProductsById_SomeNoExistsTest() {
		//GIVEN
		Mockito.when(productsRepository.findByProdidIn(Mockito.anyList())).thenReturn(List.of(productDomain));
		
		//WHEN
		//WHEN
		NoFoundProductException exception = assertThrows(NoFoundProductException.class, () -> {
			List<ProductDomain> resp = productService.findProductsById(List.of(1,2));
		    });
		
		//THEN
		 assertTrue("Some product doesn't exist".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.NOT_FOUND);
		
	}

	
	
}
