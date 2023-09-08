package com.learnspringboot.courseproject.config;

import com.learnspringboot.courseproject.dto.course.CourseDto;
import com.learnspringboot.courseproject.dto.course.CourseGetDto;
import com.learnspringboot.courseproject.entity.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Course, CourseGetDto>() {

            @Override
            protected void configure() {
                map().setAuthorName(source.getAuthor().getName());
            }
        });
        return modelMapper;
    }
}
