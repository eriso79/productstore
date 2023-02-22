package com.deverything.candidate.productstore.products.exception;

import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.common.exceptions.PoductstoreException;

public class NoExistProductsException  extends PoductstoreException {

	public NoExistProductsException(String message, HttpStatus httpStatus) {
		super(message, httpStatus);
		// TODO Auto-generated constructor stub
	}


}
