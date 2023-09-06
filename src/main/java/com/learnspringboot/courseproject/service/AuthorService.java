package com.learnspringboot.courseproject.service;

import com.learnspringboot.courseproject.entity.Author;
import com.learnspringboot.courseproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }
    public Author createAuthor(Author author){
        return repository.save(author);
    }

    public List<Author> getListOfAuthor(){
        return repository.findAll();
    }

    public Author getAuthor(long id){
        return repository.findById(id).orElse(null);
    }

    public Author updateAuthor(long id, Author author){
        getAuthor(id);
        repository.save(author);
        return author;
    }

    public void deleteAuthor(long id){
        repository.deleteById(id);
    }

    public void deleteAllAuthor(){
        repository.deleteAll();
    }


}
