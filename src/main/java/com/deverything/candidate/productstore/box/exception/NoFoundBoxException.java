package com.deverything.candidate.productstore.box.exception;

import org.springframework.http.HttpStatus;

import com.deverything.candidate.productstore.common.exceptions.PoductstoreException;

public class NoFoundBoxException  extends PoductstoreException {

	public NoFoundBoxException(String message, HttpStatus httpStatus) {
		super(message, httpStatus);
		// TODO Auto-generated constructor stub
	}


}
