package com.deverything.candidate.productstore.box.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;

public class DimmensionMapperTest {
	
	DimmensionMapper INSTANCE = Mappers.getMapper( DimmensionMapper.class );
	
	ProductDimensionsObject productDimensionsObject;
	@BeforeEach
	public void init() {
		productDimensionsObject=new ProductDimensionsObject(1,7.8,6.3);
	}
	
	@Test
	public void ToDimensionObjectTest() {
		
		
		DimensionObject target = INSTANCE.ToDimensionObject(productDimensionsObject);
		
		Assertions.assertTrue(target.getHeigh()==6.3);
		Assertions.assertTrue(target.getWidth()==7.8);
		
	}
	
	@Test
	public void ToDimensionObjectListTest() {
		 List<DimensionObject> target = INSTANCE.ToDimensionObjectList(List.of(productDimensionsObject));
		 Assertions.assertTrue(target!=null && !target.isEmpty());
		 Assertions.assertTrue(target.get(0).getHeigh()==6.3);
		 Assertions.assertTrue(target.get(0).getWidth()==7.8);
	}

	

}
