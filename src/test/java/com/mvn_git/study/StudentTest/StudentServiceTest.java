package com.mvn_git.study.StudentTest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mvn_git.study.model.Student;
import com.mvn_git.study.repos.StudentRepository;
import com.mvn_git.study.service.StudentService;

//@SpringBootTest
//@ExtendWith
public class StudentServiceTest {
	
	//@Autowired
//	@Mock
//	StudentController sCont;
	
	@InjectMocks
	private StudentService studentService;
	

	@Mock
	private StudentRepository studentRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	//Want to write @Test case method
	
	public void findAllStudentTest() {
		Student s1 = new Student();
	}
	
}
