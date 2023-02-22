package com.deverything.candidate.productstore.box.service;

import java.util.List;

import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.common.domain.BoxDomain;

public interface I_BoxService {

	BoxDomain findBoxDomainByDimensions(DimensionObject dim);

	BoxListObject findBoxListObjectByDimensionList(List<DimensionObject> dimList);



	

}
