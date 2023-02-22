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
public class CheckoutSummaryObject {
	
	List<CheckoutSummaryElementObject> listCheckoutObject;
	
	
	private double total;

}
