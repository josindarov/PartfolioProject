package com.learnspringboot.courseproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "authors")
    private List<Student> students = new ArrayList<>();

}
