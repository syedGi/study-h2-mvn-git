package com.mvn_git.study.service.impl;

import org.springframework.stereotype.Service;

import com.mvn_git.study.repos.ProductRepository;
import com.mvn_git.study.request.ProductRequest;
import com.mvn_git.study.service.ProductService;

@Service
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
