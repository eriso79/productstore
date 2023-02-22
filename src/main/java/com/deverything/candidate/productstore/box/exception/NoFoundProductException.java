package com.deverything.candidate.productstore.box.exception;

import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.common.exceptions.PoductstoreException;

public class NoFoundProductException  extends PoductstoreException {

	public NoFoundProductException(String message, HttpStatus httpStatus) {
		super(message, httpStatus);
		// TODO Auto-generated constructor stub
	}


}
