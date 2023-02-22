package com.deverything.candidate.productstore.box.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;


@Mapper
public interface DimmensionMapper {
	
	DimmensionMapper INSTANCE = Mappers.getMapper( DimmensionMapper.class );
	
	 @Mapping(target = "width", source = "prodWidth")
	 @Mapping(target = "heigh", source = "prodHeigh")
	DimensionObject ToDimensionObject(ProductDimensionsObject prodDim);
	 
	 
	 List<DimensionObject> ToDimensionObjectList(List<ProductDimensionsObject> prodDim);

}
