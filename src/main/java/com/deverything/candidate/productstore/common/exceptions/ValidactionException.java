package com.deverything.candidate.productstore.common.exceptions;

import org.springframework.http.HttpStatus;

public class ValidactionException extends RuntimeException{

	
	private HttpStatus httpStatus;
	
	
	public ValidactionException(String message, HttpStatus httpStatus ) {
		super(message);
		this.httpStatus=httpStatus;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	
	
	
	
	
	
	


	
	

}
