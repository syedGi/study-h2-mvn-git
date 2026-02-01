package com.mvn_git.study.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvn_git.study.model.ProductDetails;

@Repository
public interface ProductRepositry extends JpaRepository<ProductDetails, Long>{

}
