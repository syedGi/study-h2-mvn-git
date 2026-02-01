package com.mvn_git.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvn_git.study.model.ProductDetails;
import com.mvn_git.study.repos.ProductRepositry;

@Service
public class ProductService {
	
	ProductRepositry productRepository;
	
	public ProductService(ProductRepositry productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductDetails> getFullProducts() {
		List<ProductDetails> pds = productRepository.findAll();
		return pds;
	}

	
}
