package com.deverything.candidate.productstore.box.dto;

import com.deverything.candidate.productstore.common.domain.ProductDomain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BoxObject {
	
	@EqualsAndHashCode.Include
	private int boxid;
	
	private String boxdescription;
	
    private double boxwidth; 
	
	private double boxheigh;
	


}
