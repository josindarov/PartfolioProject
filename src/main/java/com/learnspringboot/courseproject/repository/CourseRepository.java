package com.learnspringboot.courseproject.repository;

import com.learnspringboot.courseproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
