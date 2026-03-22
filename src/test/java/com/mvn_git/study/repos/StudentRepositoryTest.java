package com.mvn_git.study.repos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mvn_git.study.model.Student;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository.deleteAll();
        // Insert 10 sample students
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Student s = new Student();
            s.setSName("Student " + i);
            s.setSAge(20 + i);
            studentRepository.save(s);
        });
    }

    @Test
    void testFindAllUsersPagedNative_firstPage() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Student> page = studentRepository.findAllUsersPagedNative(pageable);

        assertThat(page).isNotNull();
        assertThat(page.getTotalElements()).isEqualTo(10);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(5);
        assertThat(page.getContent()).hasSize(5);

        // verify order by sid ascending
        assertThat(page.getContent().get(0).getSName()).isEqualTo("Student 1");
    }

    @Test
    void testFindAllUsersPagedNative_secondPage() {
        Pageable pageable = PageRequest.of(1, 5);
        Page<Student> page = studentRepository.findAllUsersPagedNative(pageable);

        assertThat(page).isNotNull();
        assertThat(page.getTotalElements()).isEqualTo(10);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.getNumber()).isEqualTo(1);
        assertThat(page.getSize()).isEqualTo(5);
        assertThat(page.getContent()).hasSize(5);

        // verify first element on second page is Student 6
        assertThat(page.getContent().get(0).getSName()).isEqualTo("Student 6");
    }
}
