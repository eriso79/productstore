package com.deverything.candidate.productstore.products.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.deverything.candidate.productstore.common.domain.BoxDomain;
import com.deverything.candidate.productstore.common.domain.ProductDomain;

@SpringBootTest(classes = I_ProductsRepository.class)
@MockBean(I_ProductsRepository.class)
public class I_ProductsRepositoryTest {
	
	@Autowired
	I_ProductsRepository repository;
	
	ProductDomain productDomain;
	
	@BeforeEach
	public void init() {
		productDomain= new ProductDomain(1, "XBOX", 1233.66, 34.6, 54.6);
		
	}
	
	
	@Test
	public void findAllTest() {
		//GIVEN
 	    Mockito.when(repository.findAll()).thenReturn(List.of(productDomain));
 	    
 	    //WHEN
 	    List<ProductDomain> resp = repository.findAll();
 	    
 	    
 		Assertions.assertTrue(resp!= null && !resp.isEmpty());
		Assertions.assertTrue(resp.get(0).getDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getHeigh()==productDomain.getHeigh());
		Assertions.assertTrue(resp.get(0).getWidth()==productDomain.getWidth());
		Assertions.assertTrue(resp.get(0).getPrice()==productDomain.getPrice());
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
	}
	
	
	@Test
	public void findByPriceGreaterThanTest() {
		//GIVEN
 	    Mockito.when(repository.findByPriceGreaterThan(Mockito.anyDouble())).thenReturn(List.of(productDomain));
 	    
 	    //WHEN
 	    List<ProductDomain> resp = repository.findByPriceGreaterThan(300D);
 	    
 	    
 		Assertions.assertTrue(resp!= null && !resp.isEmpty());
		Assertions.assertTrue(resp.get(0).getDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getHeigh()==productDomain.getHeigh());
		Assertions.assertTrue(resp.get(0).getWidth()==productDomain.getWidth());
		Assertions.assertTrue(resp.get(0).getPrice()==productDomain.getPrice());
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
	}
	
	
	@Test
	public void findByProdidInTest() {
		//GIVEN
 	    Mockito.when(repository.findByProdidIn(Mockito.anyList())).thenReturn(List.of(productDomain));
 	    
 	    //WHEN
 	    List<ProductDomain> resp = repository.findByProdidIn(List.of(1));
 	    
 	    
 		Assertions.assertTrue(resp!= null && !resp.isEmpty());
		Assertions.assertTrue(resp.get(0).getDescription()==productDomain.getDescription());
		Assertions.assertTrue(resp.get(0).getHeigh()==productDomain.getHeigh());
		Assertions.assertTrue(resp.get(0).getWidth()==productDomain.getWidth());
		Assertions.assertTrue(resp.get(0).getPrice()==productDomain.getPrice());
		Assertions.assertTrue(resp.get(0).getProdid()==productDomain.getProdid());
	}
	

	
}
