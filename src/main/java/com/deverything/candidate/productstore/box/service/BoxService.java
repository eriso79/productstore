package com.deverything.candidate.productstore.box.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.box.exception.NoFoundBoxException;
import com.deverything.candidate.productstore.box.mapper.BoxMapper;
import com.deverything.candidate.productstore.box.repository.I_DimensionBoxRespository;
import com.deverything.candidate.productstore.box.repository.I_DimensionProductRepository;
import com.deverything.candidate.productstore.common.domain.BoxDomain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class BoxService implements I_BoxService{
	
	
	private static final  int MAX=3;
	private static final int MIN=1;
	
	private final BoxMapper mapper=Mappers.getMapper(BoxMapper.class);
	
	private I_DimensionBoxRespository  dimensionBoxRespository;
	
	private I_DimensionProductRepository dimensionProductRepository;
	
	
	
	@Override
	public  BoxDomain findBoxDomainByDimensions(DimensionObject dim) {
		double widthMin=dim.getWidth()+MIN;
		double widthMax=dim.getWidth()+MAX;
		double heighMin=dim.getHeigh()+MIN;
		double heigMax=dim.getHeigh()+MAX;
		List<BoxDomain> listBoxes = dimensionBoxRespository.findByBox(widthMin, widthMax, heighMin, heigMax);
		if (listBoxes== null || listBoxes.isEmpty()) {
			listBoxes = dimensionBoxRespository.findByBox( heighMin, heigMax,widthMin, widthMax);
		}
		if (listBoxes==null || listBoxes.isEmpty()) {
			throw new NoFoundBoxException("Box does not found",HttpStatus.NOT_FOUND);
		}
	  
		 return listBoxes.get(0);
		
	}

	@Override
	@Transactional(readOnly = true)
	public BoxListObject  findBoxListObjectByDimensionList(List<DimensionObject> dimList) {
		List<BoxDomain> list = dimList.stream().map(dim-> this.findBoxDomainByDimensions(dim)).collect(Collectors.toList());
		return new BoxListObject(list.stream().map(b-> mapper.ToBoxObject(b)).collect(Collectors.toList()));
	}

}