package com.deverything.candidate.productstore.box.business;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.box.service.I_BoxService;
import com.deverything.candidate.productstore.common.exceptions.ValidactionException;
import com.deverything.candidate.productstore.products.service.I_ProductService;

@ExtendWith(MockitoExtension.class)
public class BoxBusinessTest {
	
	@Mock
	private I_ProductService  productService;
	
	@Mock
	private I_BoxService boxService;
	
	
	 @InjectMocks 
	 private BoxBusiness boxBusiness;
	 
	 
	 
	
	 @Test
	 public void findBoxByDimensionsProductList_Test() {
		 //GIVEN
		 List<Integer> prodIdList= List.of(1,2); 
		 
		 Mockito.when(productService.findProductsDimensionByIdList(Mockito.anyList())).thenReturn(new ArrayList<>());
		 Mockito.when(boxService.findBoxListObjectByDimensionList(Mockito.anyList())).thenReturn(new BoxListObject(List.of(new BoxObject(1,"cardboard box",5.6,6.8),new BoxObject(1,"plastic box",5.6,6.8))));
		 
		 //WHEN 
		 BoxListObject response = boxBusiness.findBoxByDimensionsProductList(prodIdList);
		 
		 //THEN
		 assertTrue(response!=null && response.getListBoxes()!=null && response.getListBoxes().size()>0);
		 
	 }
	 
	 
	 
	 @Test
	 public void findBoxByDimensions_whenExceptionThrown_Test() {
		 ValidactionException exception = assertThrows(ValidactionException.class, () -> {
			 boxBusiness.findBoxByDimensions(null);
		    });

		 assertTrue("parameter invalid".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 
	 @Test
	 public void findBoxByDimensions_Test() {
		//GIVEN
		 
		 List<DimensionObject> dimList= List.of(new DimensionObject());
		 Mockito.when(boxService.findBoxListObjectByDimensionList(Mockito.anyList())).thenReturn(new BoxListObject(List.of(new BoxObject(1,"cardboard box",5.6,6.8),new BoxObject(1,"plastic box",5.6,6.8))));
		 
		 //WHEN
		BoxListObject response = this.boxBusiness.findBoxByDimensions(dimList);
		 
		 
		 //THEN
		 assertTrue(response!=null && response.getListBoxes()!=null && response.getListBoxes().size()>0);
	 }

	 
	
	
	
	
}
