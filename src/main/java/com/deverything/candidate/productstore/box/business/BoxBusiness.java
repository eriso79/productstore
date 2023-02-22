package com.deverything.candidate.productstore.box.business;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.box.mapper.DimmensionMapper;
import com.deverything.candidate.productstore.box.service.I_BoxService;
import com.deverything.candidate.productstore.common.exceptions.ValidactionException;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.products.service.I_ProductService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BoxBusiness implements I_BoxBusiness{

	
	private I_ProductService  productService;
	private I_BoxService boxService;
	
	
	
	
	@Override
	public BoxListObject findBoxByDimensionsProductList(List<Integer> prodIdList) {
		List<ProductDimensionsObject> dimprodList = productService.findProductsDimensionByIdList(prodIdList);
		return boxService.findBoxListObjectByDimensionList(DimmensionMapper.INSTANCE.ToDimensionObjectList(dimprodList));
     }
	
	
	@Override
	public BoxListObject findBoxByDimensions(List<DimensionObject> dimList) {
		if (dimList== null || dimList.isEmpty()) {
			throw new ValidactionException("parameter invalid", HttpStatus.BAD_REQUEST);
		}
		return boxService.findBoxListObjectByDimensionList(dimList);
     }
	
	
	
	
	
	
}
