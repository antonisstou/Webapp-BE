package com.sb.webapp.controller;


import com.sb.webapp.entity.Author;
import com.sb.webapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("author/{id}")
    public ResponseEntity<Author> getAuthorsById(@PathVariable("id") Long id){
        Author author = authorService.getAuthorsById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("author/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author auth = authorService.createAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @DeleteMapping("author/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("author/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
        Author auth = authorService.updateAuthor(author, id);
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }

}
