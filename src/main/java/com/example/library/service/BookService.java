package com.example.library.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;

public interface BookService extends JpaRepository<Book, Integer> {

}
