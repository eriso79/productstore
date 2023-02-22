package com.deverything.candidate.productstore.checkout.business;

import java.util.List;

import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deverything.candidate.productstore.box.business.I_BoxBusiness;
import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryObject;
import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.products.service.I_ProductService;

@ExtendWith(MockitoExtension.class)
public class CheckOutBussinessTest {

	@Mock
	private I_ProductService productService;

	@Mock
	private I_BoxBusiness boxBusiness;
	
	@InjectMocks
	CheckOutBussiness  checkOutBussiness;
	
	
	ProductDomain productDomain;
	
	BoxListObject  boxListObject;
	
	BoxObject boxObject;
	@BeforeEach
	public void init() {
		
		this.productDomain= new ProductDomain(1, "XBOX", 123.7, 56.8, 76.9);
		this.boxObject= new BoxObject(1, "plastic box", 58.7, 79.9);
		this.boxListObject= new BoxListObject(List.of(this.boxObject));
		
		
	}
	
	
	@Test
	public void doCheckOutTest() {
		//GIVEN
		Mockito.when(productService.findProductsById(Mockito.anyList())).thenReturn(List.of(productDomain));
		Mockito.when(boxBusiness.findBoxByDimensions(Mockito.anyList())).thenReturn(boxListObject);
		
		//WHEN
		CheckoutSummaryObject summary = checkOutBussiness.doCheckOut(new CheckoutObject(List.of(1)));
		
		//then
		Assertions.assertTrue(summary!= null);
		Assertions.assertTrue(summary.getListCheckoutObject()!= null);
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getProdid()== 1);
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getProdDescription().equals("XBOX"));
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getProdPrice()==123.7);
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getBoixid()==1);
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getBoxHeigh()==79.9);
		Assertions.assertTrue(summary.getListCheckoutObject().get(0).getBoxWidth()==58.7);
		Assertions.assertTrue(summary.getTotal()==123.7);
		
		
		
	}

}
