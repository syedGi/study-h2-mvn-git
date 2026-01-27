package com.mvn_git.study.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvn_git.study.model.Student;
import com.mvn_git.study.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
//@RequestMapping("/")
@Slf4j
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(
			value = "/list"
			)
	public ResponseEntity<List<Student>> listAllStudents(){
		
		List<Student> stud = studentService.getAllStudents();
		log.info("showing-all-H2-student");
		return ResponseEntity.ok().body(stud);
	}
	
	@PostMapping(
			value = "save"
			)
	public ResponseEntity<Student> saveStudent(@RequestBody Student stude) {
		log.info("======>SaVe STUDENT");
		return ResponseEntity.ok().body(studentService.savingStudent(stude));
	}
	
}
