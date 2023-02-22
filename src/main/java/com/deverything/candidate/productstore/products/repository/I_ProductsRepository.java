package com.deverything.candidate.productstore.products.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deverything.candidate.productstore.common.domain.ProductDomain;

@Repository
public interface I_ProductsRepository extends CrudRepository<ProductDomain, Integer> {
	
	  List<ProductDomain> findAll();
	  
	  
	  List<ProductDomain> findByPriceGreaterThan(Double age);
	  
	  
	  
	  List<ProductDomain> findByProdidIn(List<Integer> prodIdList);

}
