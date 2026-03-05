package com.mvn_git.study.service.impl;

import com.mvn_git.study.repos.ProductRepository;
import com.mvn_git.study.request.ProductRequest;
import com.mvn_git.study.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public int deleteProductByProductId(ProductRequest request) {
		int result = productRepository.deleteByProductId(request.getProductId());
		return result;
	}

}
