package com.deverything.candidate.productstore.box.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.common.domain.BoxDomain;

@Mapper
public interface BoxMapper {
	
	BoxMapper INSTANCE = Mappers.getMapper( BoxMapper.class );
	
	 @Mapping(source = "boxid", target = "boxid")
	 @Mapping(source = "width", target = "boxwidth")
	 @Mapping(source = "heigh", target = "boxheigh")
	BoxObject ToBoxObject(BoxDomain domain);
	 
	 

}
