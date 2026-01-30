package com.mvn_git.study.service;

import java.sql.Timestamp;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvn_git.study.model.Student;
import com.mvn_git.study.repos.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student savingStudent(Student stude) {
		return studentRepository.save(stude);
	}
	
	public void caalingCustomQuery() {
		Pageable pg = null;
		Timestamp ts = null;
		studentRepository.findTheQueryGiven(ts, pg);
	}

}
