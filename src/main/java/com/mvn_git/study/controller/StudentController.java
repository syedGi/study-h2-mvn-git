package com.mvn_git.study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
//@RequestMapping("/")
@Slf4j
public class StudentController {

	@GetMapping(
			value = "/list"
			)
	public ResponseEntity<String> listAllStudents(){
		
		log.info("showing-all-H2-student");
		return ResponseEntity.ok().body("");
	}
	
}
