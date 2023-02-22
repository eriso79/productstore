package com.deverything.candidate.productstore.box.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.box.exception.NoFoundBoxException;
import com.deverything.candidate.productstore.box.repository.I_DimensionBoxRespository;
import com.deverything.candidate.productstore.box.repository.I_DimensionProductRepository;
import com.deverything.candidate.productstore.common.domain.BoxDomain;

@ExtendWith(MockitoExtension.class)
public class BoxServiceTest {
	
	@Mock
    private I_DimensionBoxRespository  dimensionBoxRespository;
	
	@Mock
	private I_DimensionProductRepository dimensionProductRepository;
	
	@InjectMocks
	BoxService boxService;
	
	BoxDomain boxDomain;
	BoxDomain boxDomain2;
	DimensionObject dimensionObject;
	@BeforeEach
	private void init() {
		this.boxDomain= new BoxDomain(1,6.7,8.9);
		this.boxDomain2= new BoxDomain(2,3.7,7.9);
		this.dimensionObject= new DimensionObject(123, 5.7);
		//
	}
	
	
	@Test
	public void findBoxDomainByDimensionsTest() {
	   //given
		Mockito.when(dimensionBoxRespository.findByBox(Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(List.of(boxDomain));
		
		//when
		BoxDomain resp = this.boxService.findBoxDomainByDimensions(dimensionObject);
		
		//then 
		Assertions.assertTrue(resp!= null);
		Assertions.assertTrue(resp.getBoxid()== boxDomain.getBoxid());
		Assertions.assertTrue(resp.getHeigh()== boxDomain.getHeigh());
		Assertions.assertTrue(resp.getWidth()== boxDomain.getWidth());
	}
	
	
	
	@Test
	public void findBoxDomainByDimensions2Test() {
	   //given
		Mockito.when(dimensionBoxRespository.findByBox(dimensionObject.getWidth()+1, dimensionObject.getWidth()+3, dimensionObject.getHeigh()+1, dimensionObject.getHeigh()+3)).thenReturn(null);
		Mockito.when(dimensionBoxRespository.findByBox(dimensionObject.getHeigh()+1, dimensionObject.getHeigh()+3,dimensionObject.getWidth()+1, dimensionObject.getWidth()+3)).thenReturn(List.of(boxDomain));
		
		//when
		BoxDomain resp = this.boxService.findBoxDomainByDimensions(dimensionObject);
		
		//then 
		Assertions.assertTrue(resp!= null);
		Assertions.assertTrue(resp.getBoxid()== boxDomain.getBoxid());
		Assertions.assertTrue(resp.getHeigh()== boxDomain.getHeigh());
		Assertions.assertTrue(resp.getWidth()== boxDomain.getWidth());
	}
	

	@Test
	public void findBoxDomainByDimensionsWhenNoFoundBoxExceptionThrowTest() {
	   //given
		Mockito.when(dimensionBoxRespository.findByBox(dimensionObject.getWidth()+1, dimensionObject.getWidth()+3, dimensionObject.getHeigh()+1, dimensionObject.getHeigh()+3)).thenReturn(null);
		Mockito.when(dimensionBoxRespository.findByBox(dimensionObject.getHeigh()+1, dimensionObject.getHeigh()+3,dimensionObject.getWidth()+1, dimensionObject.getWidth()+3)).thenReturn(null);

		//when	
		NoFoundBoxException exception = assertThrows(NoFoundBoxException.class, () -> {
			 this.boxService.findBoxDomainByDimensions(dimensionObject);
		    });

		//then
		 assertTrue("Box does not found".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.NOT_FOUND);
		

	}


}
