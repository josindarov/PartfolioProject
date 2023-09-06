package com.learnspringboot.courseproject.repository;

import com.learnspringboot.courseproject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
