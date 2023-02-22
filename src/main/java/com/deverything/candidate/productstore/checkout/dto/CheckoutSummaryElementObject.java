package com.deverything.candidate.productstore.checkout.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CheckoutSummaryElementObject {
	
	private int  prodid;
	
	private String prodDescription;
	
	private double prodPrice;
	
	private int boixid;
	
	private double boxWidth;
	private double boxHeigh;

}
