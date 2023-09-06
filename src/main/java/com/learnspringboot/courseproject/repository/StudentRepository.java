package com.learnspringboot.courseproject.repository;

import com.learnspringboot.courseproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
