package com.deverything.candidate.productstore.box.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import com.deverything.candidate.productstore.common.domain.BoxDomain;

@SpringBootTest(classes = I_DimensionBoxRespository.class)
@MockBean(I_DimensionBoxRespository.class)
public class I_DimensionBoxRespositoryTest {
	
	 	
	@Autowired
	I_DimensionBoxRespository repository;
	
	 
	
	private BoxDomain boxDomain;
	
	@BeforeEach
	public void init() {
		boxDomain= new BoxDomain(1, 3.5, 6.7);
		
	}
	
	@Test
	public void findByBoxTest() {
 		//GIVEN
		Mockito.when(repository.findByBox(Mockito.anyDouble(),Mockito.anyDouble(),Mockito.anyDouble(),Mockito.anyDouble())).thenReturn(List.of(boxDomain));

		//WHEN 
		List<BoxDomain> resp = repository.findByBox(1.3, 2.3, 4.5, 5.5);
		
		//THEN 
		Assertions.assertTrue(resp!= null && !resp.isEmpty());
		Assertions.assertTrue(resp.get(0).getBoxid()==boxDomain.getBoxid());
		Assertions.assertTrue(resp.get(0).getHeigh()==boxDomain.getHeigh());
		Assertions.assertTrue(resp.get(0).getWidth()==boxDomain.getWidth());
		
	}
	
}
