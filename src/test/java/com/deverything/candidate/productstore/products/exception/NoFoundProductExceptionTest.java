package com.deverything.candidate.productstore.products.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.common.exceptions.ValidactionException;





@ExtendWith(MockitoExtension.class)
public class NoFoundProductExceptionTest {

	
	 @Test
	 public void NoFoundBoxExceptionThrown_Test() {
		 NoFoundProductException exception = assertThrows(NoFoundProductException.class, () -> {
			 throw new NoFoundProductException("message in exception", HttpStatus.BAD_REQUEST);
		    });

		 assertTrue("message in exception".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.BAD_REQUEST);
	 }
}
