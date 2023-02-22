package com.deverything.candidate.productstore;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deverything.candidate.productstore.box.business.I_BoxBusiness;
import com.deverything.candidate.productstore.box.dto.BoxListObject;
import com.deverything.candidate.productstore.box.service.I_BoxService;
import com.deverything.candidate.productstore.checkout.business.I_CheckOutBussiness;
import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryObject;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.producto.dto.ProductObject;
import com.deverything.candidate.productstore.products.service.I_ProductService;

import lombok.AllArgsConstructor;

@RestController()
@RequestMapping("/")
@AllArgsConstructor
public class ApiServiceImp  implements ApiService<ProductObject, ProductDimensionsObject, BoxListObject, CheckoutObject, CheckoutSummaryObject> {

	
	private  I_ProductService productService;
	
   private I_CheckOutBussiness checkOutBussiness;	
	
	private I_BoxBusiness boxBusiness;
	 
	
	@Override
	@GetMapping(value="/getProducts")
	@ResponseBody public List<ProductObject> getProducts() {
		return this.productService.findAllProducts();
	}

	
	@GetMapping("/getGreaterthan/{price}")
	@Override
	@ResponseBody public List<ProductObject> getGreaterthan(@PathVariable double price) {
		return this.productService.findAllProductsByPriceGreaterthan(price);
	}
	
	
	@Override
	@GetMapping("/getProductDimensions/{productId}")
	@ResponseBody public ProductDimensionsObject getProductDimensions(@PathVariable int productId) {
		return productService.findProductsDimensionById(productId);
	}

	@Override
	@GetMapping("/getBoxesByProdId/{prodIdList}")
	@ResponseBody public BoxListObject getBoxes(@PathVariable List<Integer> prodIdList) {
		return boxBusiness.findBoxByDimensionsProductList(prodIdList);
		
	}

	@Override
	@PostMapping(value ="/checkout", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public CheckoutSummaryObject checkout(@RequestBody CheckoutObject checkoutObject) {
		return checkOutBussiness.doCheckOut(checkoutObject);
		
	}




	
}
