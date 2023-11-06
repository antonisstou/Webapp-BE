package com.sb.webapp.controller;

import com.sb.webapp.entity.Book;
import com.sb.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("authors/{authorId}/books")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable("authorId") Long author_id){
        List<Book> books = bookService.getAllBooksByAuthor(author_id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("authors/{authorId}/book/create")
    public ResponseEntity<Book> createBook(@PathVariable("authorId") Long author_id, @RequestBody Book book){
        Book book1 = bookService.createBook(author_id, book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("book/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book){
        Book book1 = bookService.updateBook(book, id);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @DeleteMapping("book/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("book/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") String isbn){
        Book book = bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
