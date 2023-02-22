package com.deverything.candidate.productstore;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.deverything.candidate.app.init.AppInitialization;
import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppInitialization.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class RealTest {
	
	
	  
	 @LocalServerPort
	    private int port;

	    TestRestTemplate restTemplate = new TestRestTemplate();
	
	   @Autowired
	   private ObjectMapper objectMapper;
	   
	   HttpHeaders headers = new HttpHeaders();
	   
	   
	   private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	
	 @Test
	   public void getProductsTest() throws Exception {
		   //GIVEN
		 HttpEntity<String> entity = new HttpEntity<>(null, headers);
		 
		 //WHEN
		 ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/getProducts"),
	                HttpMethod.GET, entity, String.class);
		 
		 //THEN
		 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
		 Assertions.assertTrue(response.getStatusCodeValue()== 200);
		
		 
	   }
	   
	 
	
	   
	   @Test
	   public void getGreaterthanTest() throws Exception {
		   //GIVEN
			 HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
			//WHEN
			 ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("/getGreaterthan/300"),
		                HttpMethod.GET, entity, String.class);
			 
			 //THEN
			 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
			 Assertions.assertTrue(response.getStatusCodeValue()== 200);
			 
		 
	   }

	   
	   @Test
	   public void getProductDimensionsTest() throws Exception {
		   //GIVEN
			 HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
			//WHEN
			 ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("/getProductDimensions/1"),
		                HttpMethod.GET, entity, String.class);
			 
			 //THEN
			 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
			 Assertions.assertTrue(response.getStatusCodeValue()== 200);
		   	 
	   }
	   
	   
	   @Test
	   public void getBoxesTest() throws Exception {
		   //GIVEN
			 HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
			//WHEN
			 ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("/getBoxesByProdId/7,3"),
		                HttpMethod.GET, entity, String.class);
			 
			 //THEN
			 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
			 Assertions.assertTrue(response.getStatusCodeValue()== 200);
		   
		
		  
	   }
	   
	   
	   @Test
	   public void getBoxesErrorTest() throws Exception {
		   //GIVEN
			 HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
			//WHEN
			 ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("/getBoxesByProdId/5"),
		                HttpMethod.GET, entity, String.class);
			 
			 //THEN
			 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
			 Assertions.assertTrue(response.getStatusCodeValue()!= 200);
		   
		
		  
	   }
	   
	   
	   @Test
	   public void CheckoutSummaryObjectTest() throws Exception {
		 //GIVEN
		   CheckoutObject ck=new CheckoutObject(List.of(3,7)); 
			 HttpEntity<CheckoutObject> entity = new HttpEntity<CheckoutObject>(ck, headers);
			
			//WHEN
			 ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("//checkout"),
		                HttpMethod.POST, entity, String.class);
			 
			 //THEN
			 log.info("\n\n*****RESULT:\n\n:{}\n\n***********",response.getBody());
			 Assertions.assertTrue(response.getStatusCodeValue()== 200);
		   
		 
	   }

}
