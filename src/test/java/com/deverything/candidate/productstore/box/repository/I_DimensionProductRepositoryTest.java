package com.deverything.candidate.productstore.box.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.deverything.candidate.productstore.box.dto.DimensionObject;

@SpringBootTest(classes = I_DimensionProductRepository.class)
@MockBean(I_DimensionProductRepository.class)
public class I_DimensionProductRepositoryTest {

	@Autowired
	I_DimensionProductRepository repository;
	
	
	DimensionObject dimensionObject;
	@BeforeEach
	public void init() {
		this.dimensionObject= new DimensionObject(12.6, 23.5);
	}
	
	@Test
	public void findDimensionByProdIdTest() {
		//GIVEN
		Mockito.when(this.repository.findDimensionByProdId(Mockito.anyInt())).thenReturn(this.dimensionObject);
		DimensionObject resp = this.repository.findDimensionByProdId(1);
		Assertions.assertTrue(resp.getHeigh()==this.dimensionObject.getHeigh());
		Assertions.assertTrue(resp.getWidth()==this.dimensionObject.getWidth());
		
	}
	
}
