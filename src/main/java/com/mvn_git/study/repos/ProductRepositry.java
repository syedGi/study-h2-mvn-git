package com.mvn_git.study.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvn_git.study.model.ProductDetails;

@Repository
public interface ProductRepositry extends JpaRepository<ProductDetails, Long>{

//	@Query("SELECT * FROM PRODUCTDETAILS P WHERE "
//			+ "P.QUANTITY > (:NO) AND CATEGORY IN (:LIST)")
//	List<ProductDetails> findMyProds();
}
