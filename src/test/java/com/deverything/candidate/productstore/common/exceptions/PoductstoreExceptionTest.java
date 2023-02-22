package com.deverything.candidate.productstore.common.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.box.exception.NoFoundBoxException;


@ExtendWith(MockitoExtension.class)
public class PoductstoreExceptionTest {

	
	 @Test
	 public void poductstoreException_Test() {
		 PoductstoreException exception = assertThrows(PoductstoreException.class, () -> {
			 throw new PoductstoreException("message in exception", HttpStatus.BAD_REQUEST);
		    });

		 assertTrue("message in exception".equals(exception.getMessage()) && exception.getHttpStatus()==HttpStatus.BAD_REQUEST);
	 }
}
