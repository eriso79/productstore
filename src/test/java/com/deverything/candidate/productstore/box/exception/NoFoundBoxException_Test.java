package com.deverything.candidate.productstore.box.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class NoFoundBoxException_Test {

	
	 @Test
	 public void NoFoundBoxExceptionThrown_Test() {
		 NoFoundBoxException exception = assertThrows(NoFoundBoxException.class, () -> {
			 throw new NoFoundBoxException("message in exception", HttpStatus.BAD_REQUEST);
		    });

		 assertTrue("message in exception".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.BAD_REQUEST);
	 }
}
