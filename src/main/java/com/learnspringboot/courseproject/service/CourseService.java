package com.learnspringboot.courseproject.service;

import com.learnspringboot.courseproject.entity.Course;
import com.learnspringboot.courseproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository){
        this.repository = repository;
    }

    public Course createCourse(Course course){
        return repository.save(course);
    }

    public List<Course> getListOfCourse(){
        return repository.findAll();

    }

    public Course getCourseById(long id){
        return repository.findById(id).orElse(null);
    }

    public Course updateCourse(long id, Course course){
        getCourseById(id);
        return repository.save(course);
    }

    public void deleteAllCourses(){
        repository.deleteAll();
    }

    public void deleteCourseById(long id){
        repository.deleteById(id);
    }
}
