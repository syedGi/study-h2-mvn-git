package com.mvn_git.study.StudentTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvn_git.study.controller.StudentController;

@SpringBootTest
public class StudentTesting {
	
	@Autowired
	StudentController sCont;

	@Test
	public void testGetAllStudent() {
		sCont.listAllStudents();
	}
}
