package com.mvn_git.study.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="productdetails")
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
public class ProductDetails {

	@Id
	private Long id;
	
	private String category;
	private String grouping;
	private String itemid;
	private String itemname;
	private BigDecimal normalprice;
	private Integer quantity;
}
