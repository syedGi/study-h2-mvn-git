package com.mvn_git.study.StudentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvn_git.study.controller.StudentController;

@SpringBootTest
@ExtendWith
public class StudentTesting {
	
	//@Autowired
	@Mock
	StudentController sCont;

	@Test
	public void testGetAllStudent() {
		sCont.listAllStudents();
	}
}
