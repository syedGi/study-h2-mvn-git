package com.mvn_git.study.service;

import org.springframework.stereotype.Service;

import com.mvn_git.study.request.ProductRequest;

@Service
public interface ProductService {

	public int deleteProductByProductId(ProductRequest request);
}
