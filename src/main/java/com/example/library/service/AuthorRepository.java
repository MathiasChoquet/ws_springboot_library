package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT DISTINCT a FROM Author a JOIN a.books b WHERE lower(b.title) LIKE %:title%")
    List<Author> findByBookTitlePart(String title);

    Optional<Author> findByName(String name);

}
