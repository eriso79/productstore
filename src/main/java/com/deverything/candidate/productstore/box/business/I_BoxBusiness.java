package com.deverything.candidate.productstore.box.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.BoxObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;

@Component
public interface I_BoxBusiness {

	

	BoxListObject findBoxByDimensionsProductList(List<Integer> prodIdList);

	BoxListObject findBoxByDimensions(List<DimensionObject> dimList);

}
