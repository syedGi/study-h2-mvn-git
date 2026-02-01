package com.mvn_git.study.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mvn_git.study.model.ProductDetails;
import com.mvn_git.study.service.ProductService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@RestController("/productdetails")
@RestController
@Slf4j
public class ProductController {
	
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<ProductDetails>> getAllProducts() {
		List<ProductDetails>pdList = productService.getFullProducts();
		log.info("=>GET ALL PRODUCT DETAILS DONE<=::", pdList);
		return ResponseEntity.ok().body(pdList);
	}
	
}
