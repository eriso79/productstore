package com.deverything.candidate.productstore.checkout.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.deverything.candidate.productstore.box.business.I_BoxBusiness;
import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.dto.DimensionObject;
import com.deverything.candidate.productstore.box.mapper.DimmensionMapper;
import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryElementObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryObject;
import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.products.mapper.ProductDimensionsMapper;
import com.deverything.candidate.productstore.products.service.I_ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CheckOutBussiness implements I_CheckOutBussiness {

	
	
	private I_ProductService  productService;
	
	private I_BoxBusiness boxBusiness;
	
	


	@Override
	public CheckoutSummaryObject  doCheckOut(CheckoutObject checkoutObject) {
		
		List<ProductDomain> prodlist = this.productService.findProductsById(checkoutObject.getProdIdList());
		List<ProductDimensionsObject> dimProdList = ProductDimensionsMapper.INSTANCE.toProductDimensionsListObject(prodlist);
		List<DimensionObject> dim = DimmensionMapper.INSTANCE.ToDimensionObjectList(dimProdList);
	    BoxListObject boxing = this.boxBusiness.findBoxByDimensions(dim);
	    List<CheckoutSummaryElementObject> elemtList = IntStream.range(0,prodlist.size())
	    .mapToObj(idx-> new CheckoutSummaryElementObject(prodlist.get(idx).getProdid(),prodlist.get(idx).getDescription(),prodlist.get(idx).getPrice()
	    		,boxing.getListBoxes().get(idx).getBoxid(),boxing.getListBoxes().get(idx).getBoxwidth(),boxing.getListBoxes().get(idx).getBoxheigh())).collect(Collectors.toList());
	    Double total = elemtList.stream().collect(Collectors.summingDouble(o -> o.getProdPrice()));
	    CheckoutSummaryObject summary= new CheckoutSummaryObject();
	    summary.setListCheckoutObject(elemtList);
	    summary.setTotal(total);
	    
	    return summary;
	    
	    
	}

	
}
