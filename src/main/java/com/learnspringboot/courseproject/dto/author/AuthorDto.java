package com.learnspringboot.courseproject.dto.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AuthorDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

}
