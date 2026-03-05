package com.mvn_git.study.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	private Long pid;

	private Integer productId;
	private LocalDateTime creationDate;
	private Integer serialNumber;
}
