package com.deverything.candidate.productstore.box.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.common.domain.ProductDomain;

@Repository
public interface I_DimensionProductRepository extends CrudRepository<ProductDomain, Integer>{
	
	  @Query("SELECT "
		  		+ " new com.deverything.candidate.productstore.box.dto.DimensionObject("
		  		+ " width"
		  		+ ",heigh"
		  		+ ")"
		  		+ "FROM ProductDomain WHERE prodid=?1"
		  		)
	  DimensionObject findDimensionByProdId(int prodid);

}
