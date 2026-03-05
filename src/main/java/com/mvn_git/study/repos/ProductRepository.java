package com.mvn_git.study.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvn_git.study.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	int deleteByProductId(int productId);
}
