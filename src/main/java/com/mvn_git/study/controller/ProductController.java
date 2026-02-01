package com.mvn_git.study.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mvn_git.study.model.ProductDetails;
import com.mvn_git.study.service.ProductService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController("/productdetails")
@Slf4j
public class ProductController {
	
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping()
	public ResponseEntity<ProductDetails> getAllProducts() {
		productService.getFullProducts();
		log.info("=>GET ALL PRODUCT DETAILS DONE<=");
		return ResponseEntity.ok().body(null);
	}
	
}
