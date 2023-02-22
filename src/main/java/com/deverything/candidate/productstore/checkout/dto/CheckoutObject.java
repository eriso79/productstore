package com.deverything.candidate.productstore.checkout.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CheckoutObject {
	
	@EqualsAndHashCode.Include
	private List<Integer> prodIdList;
	
	
	
	
	

}
