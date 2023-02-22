package com.deverything.candidate.productstore.box.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.common.domain.BoxDomain;

@ExtendWith(MockitoExtension.class)
public class BoxMapperTest {

	
	@Test
	public void ToBoxObject_Test() {
		
		BoxMapper INSTANCE = Mappers.getMapper( BoxMapper.class );
		BoxObject target = INSTANCE.ToBoxObject(new BoxDomain(1,6.7,7.9));
		
		Assertions.assertTrue(target.getBoxheigh()==7.9);
		Assertions.assertTrue(target.getBoxwidth()==6.7);
		Assertions.assertTrue(target.getBoxid()==1);
		
	}
}
