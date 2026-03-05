package com.mvn_git.study.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	private Integer productId;
	private LocalDateTime creationDate;
	private Integer serialNumber;
}
