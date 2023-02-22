package com.deverything.candidate.productstore.products.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;



@ExtendWith(MockitoExtension.class)
public class ProductDimensionsMapperTest {
	
	ProductDimensionsMapper INSTANCE = Mappers.getMapper( ProductDimensionsMapper.class );
	
	
	ProductDomain src= new ProductDomain(1, "XBOX", 123.55, 1.7, 456.9);
	
	
	@Test
	public void toProductDimensionsObjectTest() {
		ProductDimensionsObject target = INSTANCE.toProductDimensionsObject(src);
		Assertions.assertTrue(target.getProdid()==src.getProdid());
		Assertions.assertTrue(target.getProdHeigh()==src.getHeigh());
		Assertions.assertTrue(target.getProdWidth()==src.getWidth());
		
	}

	
	
	@Test
	public void toProductDimensionsListObjectTest() {
		List<ProductDimensionsObject> target = INSTANCE.toProductDimensionsListObject(List.of(src));
		Assertions.assertTrue(target.get(0).getProdid()==src.getProdid());
		Assertions.assertTrue(target.get(0).getProdHeigh()==src.getHeigh());
		Assertions.assertTrue(target.get(0).getProdWidth()==src.getWidth());
		
	}


}
