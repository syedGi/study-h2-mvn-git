package com.mvn_git.study.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvn_git.study.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	int deleteByProductId(int productId);
}
