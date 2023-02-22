package com.deverything.candidate.productstore.products.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;


@Mapper
public interface ProductDimensionsMapper {

	ProductDimensionsMapper INSTANCE = Mappers.getMapper( ProductDimensionsMapper.class );
	
	 @Mapping(source = "prodid", target = "prodid")
	 @Mapping(source = "width", target = "prodWidth")
	 @Mapping(source = "heigh", target = "prodHeigh")
	ProductDimensionsObject toProductDimensionsObject(ProductDomain productObject);
	 
	 
	 List<ProductDimensionsObject> toProductDimensionsListObject(List<ProductDomain> productObject);
	

}
