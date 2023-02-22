package com.deverything.candidate.productstore.products.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductObject;

@Mapper
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );
	
	
	 @Mapping(source = "prodid", target = "prodid")
	 @Mapping(source = "description", target = "prodDescription")
	 @Mapping(source = "price", target = "prodPrice")
	 
	 ProductObject toProductObject(ProductDomain productObject); 
	 
	 
	 default List<ProductObject> toProductObjectList(List<ProductDomain> productDomainList){
		 if (productDomainList==null) {
			 return new ArrayList<>();
		 }
		 
		 return productDomainList.stream().map(p-> this.toProductObject(p) ).collect(Collectors.toList());
	 }
	 
	 
	 @InheritInverseConfiguration
	 ProductDomain toProductDomain(ProductObject productObject);
	 
	 
	 default List<ProductDomain> toProductDomainList(List<ProductObject> productObjectList) {
		 if (productObjectList== null) {
			 return new ArrayList<>();
		 }
		 
		 return productObjectList.stream().map(p-> this.toProductDomain(p)).collect(Collectors.toList());
	 }
	 
	 
	 

	 
	 

	

}
