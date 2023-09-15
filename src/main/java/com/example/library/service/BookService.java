package com.example.library.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.library.model.Book;

public interface BookService extends JpaRepository<Book, Integer> {

    @Query("SELECT DISTINCT b FROM Book b WHERE lower(b.title) LIKE %:title%")
    List<Book> findByTitle(String title);

    Book findByIsbn(Long isbn);

}
