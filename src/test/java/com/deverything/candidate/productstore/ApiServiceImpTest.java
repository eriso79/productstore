package com.deverything.candidate.productstore;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.deverything.candidate.productstore.ApiServiceImp;
import com.deverything.candidate.productstore.box.business.I_BoxBusiness;
import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.checkout.business.I_CheckOutBussiness;
import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryObject;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.producto.dto.ProductObject;
import com.deverything.candidate.productstore.products.service.I_ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc(addFilters = false)
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@WebMvcTest
@ContextConfiguration(classes = {ApiServiceImp.class,I_ProductService.class,I_CheckOutBussiness.class,I_BoxBusiness.class})
public class ApiServiceImpTest {
	
   @MockBean
	private  I_ProductService productService;
	
   @MockBean
   private I_CheckOutBussiness checkOutBussiness;	
	
   @MockBean
	private I_BoxBusiness boxBusiness;
   
   @Autowired
   private MockMvc mockMvc;
   
   @Autowired
   private ObjectMapper objectMapper;
   
   
   ProductObject productObject;
   
   @BeforeEach
   public void init() {
	   productObject= new ProductObject(1, "XBOX", 1234.77);
   }
   
   @Test
   public void getProductsTest() throws Exception {
	   //GIVEN
	   Mockito.when(productService.findAllProducts()).thenReturn(List.of(productObject));
	  ResultActions result= this.mockMvc.perform(MockMvcRequestBuilders.get("/getProducts").contentType(MediaType.ALL));
	  result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
   }
   
   
   @Test
   public void getGreaterthanTest() throws Exception {
	   //GIVEN
	   Mockito.when(productService.findAllProductsByPriceGreaterthan(Mockito.anyDouble())).thenReturn(List.of(productObject));
	  ResultActions result= this.mockMvc.perform(MockMvcRequestBuilders.get("/getGreaterthan/300").contentType(MediaType.ALL));
	  result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
   }

   
   @Test
   public void getProductDimensionsTest() throws Exception {
	   //GIVEN
	   ProductDimensionsObject dim= new ProductDimensionsObject(1, 34.9, 66.0);
	   Mockito.when(productService.findProductsDimensionById(Mockito.anyInt())).thenReturn(dim);
	  ResultActions result= this.mockMvc.perform(MockMvcRequestBuilders.get("/getProductDimensions/1").contentType(MediaType.ALL));
	  result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
   }
   
   
   @Test
   public void getBoxesTest() throws Exception {
	   //GIVEN
	   
	   BoxListObject boxListObject= new BoxListObject(List.of(new BoxObject(1,"plastic box",123.66,56.99)));
	   Mockito.when(boxBusiness.findBoxByDimensionsProductList(Mockito.anyList())).thenReturn(boxListObject);
	  ResultActions result= this.mockMvc.perform(MockMvcRequestBuilders.get("/getBoxesByProdId/1,2,4").contentType(MediaType.ALL));
	  result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
   }
   
   
   @Test
   public void CheckoutSummaryObjectTest() throws Exception {
	   //GIVEN
	   
	   CheckoutObject ch=new CheckoutObject(List.of(1,2,3));
	   
	   Mockito.when(checkOutBussiness.doCheckOut(Mockito.any(CheckoutObject.class))).thenReturn(new CheckoutSummaryObject());
	  ResultActions result= this.mockMvc.perform(MockMvcRequestBuilders.post("/checkout")
			  .content(this.objectMapper.writeValueAsString(ch))
			  .contentType(MediaType.APPLICATION_JSON));
	  result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
   }
   
   
  
  
}
