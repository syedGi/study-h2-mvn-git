package com.mvn_git.study.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
 /* 
 * @RequiredArgsConstructor
 */
@Entity
@Table(name="studentInfo")
public class Student {

	@Id
	@GeneratedValue
	private Long sId;
	
	private String sName;
	
	//private LocalDate sDob;
	
	private int sAge;
	
}
