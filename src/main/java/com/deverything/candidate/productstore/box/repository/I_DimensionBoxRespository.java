package com.deverything.candidate.productstore.box.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deverything.candidate.productstore.common.domain.BoxDomain;

@Repository
public interface I_DimensionBoxRespository extends CrudRepository<BoxDomain, Integer>{
	
	@Query("SELECT B FROM BoxDomain B  "
		  + "WHERE "
		  + " (width BETWEEN ?1 AND ?2) " 
	      + " AND (heigh BETWEEN ?3 AND ?4) "
	      + "ORDER BY width,heigh")
	List<BoxDomain> findByBox(double widthMin,double widthMax, double heighMin, double heigMax);
      
}
