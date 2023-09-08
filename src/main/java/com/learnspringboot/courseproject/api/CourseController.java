package com.learnspringboot.courseproject.api;

import com.learnspringboot.courseproject.dto.course.CourseDto;
import com.learnspringboot.courseproject.dto.course.CourseGetDto;
import com.learnspringboot.courseproject.entity.Course;
import com.learnspringboot.courseproject.service.AuthorService;
import com.learnspringboot.courseproject.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {

    private CourseService courseService;
    private ModelMapper mapper;
    private AuthorService authorService;

    @Autowired
    public CourseController(CourseService courseService, AuthorService authorService ,ModelMapper mapper){
        this.courseService = courseService;
        this.authorService = authorService;
        this.mapper = mapper;
    }

    @PostMapping
    public CourseGetDto createCourse(@RequestBody CourseDto courseDto){
        Course course = convertToEntity(courseDto);
        course.setAuthor(authorService.getAuthor(courseDto.getAuthor_id()));
        var result = convertToDto(courseService.createCourse(course));
        result.setAuthorName(course.getAuthor().getName());
        return result;
    }

    @GetMapping
    public List<CourseGetDto> getListOfCourses(){
        List<Course> courses = courseService.getListOfCourse();
        return courses.stream()
                .map(course -> mapper.map(course, CourseGetDto.class)).collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public CourseGetDto getCourseById(@PathVariable("id") long id){
        var course = courseService.getCourseById(id);
        var result = convertToDto(course);
        result.setAuthorName(course.getAuthor().getName());
        return result;
    }

    @PutMapping(path = "{id}")
    public CourseGetDto updateCourse(@PathVariable("id") long id, @RequestBody CourseDto courseDto){
        var course = convertToEntity(courseDto);
        var result = convertToDto(courseService.updateCourse(id, course));
        result.setAuthorName(course.getAuthor().getName());
        return result;
    }

    @DeleteMapping
    public void deleteAllCourse(){
        courseService.deleteAllCourses();
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable("id") long id){
        courseService.deleteCourseById(id);
    }

    public Course convertToEntity(CourseDto courseDto){
        return mapper.map(courseDto, Course.class);
    }

    public CourseGetDto convertToDto(Course course){
        return mapper.map(course, CourseGetDto.class);
    }
}
