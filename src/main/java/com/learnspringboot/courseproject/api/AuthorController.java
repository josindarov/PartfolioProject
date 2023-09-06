package com.learnspringboot.courseproject.api;

import com.learnspringboot.courseproject.dto.author.AuthorDto;
import com.learnspringboot.courseproject.entity.Author;
import com.learnspringboot.courseproject.service.AuthorService;
import org.modelmapper.ModelMapper; // Import ModelMapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/author") // Correct the path attribute
public class AuthorController {

    private AuthorService authorService;
    private ModelMapper mapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper mapper){
        this.authorService = authorService;
        this.mapper = mapper;
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        var author = convertToEntity(authorDto);
        var entity = authorService.createAuthor(author);
        return convertToDto(entity);
    }

    @GetMapping
    public List<AuthorDto> getListOfAuthor(){
        var authorList = authorService.getListOfAuthor();
        return authorList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public AuthorDto getAuthorById(@PathVariable long id){
        Author author = authorService.getAuthor(id);
        return convertToDto(author);

    }

    @PutMapping(path = "{id}")
    public AuthorDto updateAuthor(@PathVariable long id, @RequestBody AuthorDto authorDto){
        var entity = convertToEntity(authorDto);
        return convertToDto(authorService.updateAuthor(id, entity));
    }

    @DeleteMapping
    public void deleteAllAuthor(){
        authorService.deleteAllAuthor();
    }

    @DeleteMapping(path = "{id}")
    public void deleteAuthor(@PathVariable long id){
        authorService.deleteAuthor(id);
    }

    public AuthorDto convertToDto(Author author){
        return mapper.map(author, AuthorDto.class);
    }

    public Author convertToEntity(AuthorDto authorDto){
        return mapper.map(authorDto, Author.class);
    }
}
