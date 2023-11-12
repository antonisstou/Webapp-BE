package com.sb.webapp.service;

import com.sb.webapp.entity.Author;
import com.sb.webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorsById(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author is not found - " + id));
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Author author, Long id){
        Author auth = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author is not found - " + id));
        auth.setFirstName(author.getFirstName());
        auth.setLastName(author.getLastName());
        return authorRepository.save(auth);
    }

}
