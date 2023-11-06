package com.sb.webapp.service;

import com.sb.webapp.entity.Author;
import com.sb.webapp.entity.Book;
import com.sb.webapp.repository.AuthorRepository;
import com.sb.webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooksByAuthor(Long id) {
        return bookRepository.findByAuthorId(id);
    }

    public Book createBook(Long author_id, Book book){
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Author id not found - " + author_id));
        return bookRepository.save(book);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found - " + id));
    }

    public Book updateBook(Book book, Long id){
        Book book1 = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found - " + id));
        book1.setIsbn(book.getIsbn());
        book1.setTitle(book.getTitle());
        book1.setPublisher(book.getPublisher());
        book1.setPublishedYear(book.getPublishedYear());
        book1.setAuthor(book.getAuthor());
        return bookRepository.save(book1);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public Book getBookByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

}
