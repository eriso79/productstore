package com.deverything.candidate.productstore.products.service;

import java.util.List;

import com.deverything.candidate.productstore.common.domain.ProductDomain;
import com.deverything.candidate.productstore.producto.dto.ProductDimensionsObject;
import com.deverything.candidate.productstore.producto.dto.ProductObject;

public interface I_ProductService {

	List<ProductObject> findAllProducts();

	List<ProductObject> findAllProductsByPriceGreaterthan(double greaterthan);



	ProductDimensionsObject findProductsDimensionById(int prodid);

	List<ProductDimensionsObject> findProductsDimensionByIdList(List<Integer> prodidList);

	List<ProductDomain> findProductsById(List<Integer> prodidList);

}
