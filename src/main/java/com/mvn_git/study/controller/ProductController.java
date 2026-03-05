package com.mvn_git.study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvn_git.study.request.ProductRequest;
import com.mvn_git.study.service.ProductService;

@RestController
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/deleteById")
	public ResponseEntity<Void> deleteById(@RequestBody ProductRequest prodRequest){
		int status = productService.deleteProductByProductId(prodRequest);
		if(status>0)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}
}
