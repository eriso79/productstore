package com.deverything.candidate.productstore.producto.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class ProductObject {
	
		
	@EqualsAndHashCode.Include
	private int  prodid;
	private String prodDescription;
	private double prodPrice;
	
	
	
}
