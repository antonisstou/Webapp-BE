package com.sb.webapp.repository;

import com.sb.webapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long author_id);
    Book findByIsbn(String isbn);
}
