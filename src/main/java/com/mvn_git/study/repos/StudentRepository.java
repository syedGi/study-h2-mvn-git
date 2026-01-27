package com.mvn_git.study.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvn_git.study.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
