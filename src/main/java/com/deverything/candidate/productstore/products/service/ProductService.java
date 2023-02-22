package com.deverything.candidate.productstore.products.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.producto.dto.ProductObject;
import com.deverything.candidate.productstore.products.exception.NoExistProductsException;
import com.deverything.candidate.productstore.products.exception.NoFoundProductException;
import com.deverything.candidate.productstore.products.mapper.ProductDimensionsMapper;
import com.deverything.candidate.productstore.products.mapper.ProductMapper;
import com.deverything.candidate.productstore.products.repository.I_ProductsRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService implements I_ProductService{
	
	private I_ProductsRepository productsRepository;
	
	
	private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

	@Override
	@Transactional(readOnly = true)
	public List<ProductObject> findAllProducts() {
		var resp=this.productsRepository.findAll();
	   List<ProductObject> list = productMapper.toProductObjectList( resp );
	   if (list.isEmpty()) {
		   throw new NoExistProductsException("There are no products", HttpStatus.NOT_FOUND);
	   }  
	  return list;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductObject> findAllProductsByPriceGreaterthan( double greaterthan ) {
		var resp=this.productsRepository.findByPriceGreaterThan(greaterthan);
		   List<ProductObject> list = productMapper.toProductObjectList( resp );
		   if (list.isEmpty()) {
			   throw new NoExistProductsException("There are no products", HttpStatus.NOT_FOUND);
		   }  
		  return list;
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductDimensionsObject> findProductsDimensionByIdList( List<Integer>  prodidList ) {
		 List<ProductDomain> prodList=this.productsRepository.findByProdidIn(prodidList);
		  
		   
		   if (prodList == null || prodList.isEmpty()) {
			   throw new NoExistProductsException("There are no products", HttpStatus.NOT_FOUND);
		   }  
		  return  ProductDimensionsMapper.INSTANCE.toProductDimensionsListObject(prodList);
	}

	
	
	@Override
	public ProductDimensionsObject findProductsDimensionById( int  prodid ) {
		 List<ProductDomain> prodList=this.productsRepository.findByProdidIn(List.of(prodid));
		  
		   
		   if (prodList == null || prodList.isEmpty()) {
			   throw new NoExistProductsException("There are no products", HttpStatus.NOT_FOUND);
		   }  
		  return  ProductDimensionsMapper.INSTANCE.toProductDimensionsListObject(prodList).get(0);
	}
	
	
	
	@Override
	public List<ProductDomain> findProductsById( List<Integer>  prodidList  ) {
		 List<ProductDomain> prodList=this.productsRepository.findByProdidIn(prodidList);
		  
		   
		   if (prodList == null || prodList.isEmpty()) {
			   throw new NoExistProductsException("There are no products", HttpStatus.NOT_FOUND);
		   }  else if (prodList.size()!= prodidList.size()){
			   throw new NoFoundProductException("Some product doesn't exist", HttpStatus.NOT_FOUND);
		   }
		  return  prodList; 
	}

	

	

}
