package com.example.library.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @CrossOrigin
    @GetMapping("/book")
    public ResponseEntity<String> getBooks() {

        String ret = bookService.findAll().stream().map(Book::getTitle)
                .collect(Collectors.joining(", "));

        return ResponseEntity.ok(ret);
    }

    @CrossOrigin
    @GetMapping("/author")
    public ResponseEntity<String> getAuthorUsingJava(@RequestParam String title) {

        String ret = authorService.findAll().stream()
                .filter(a -> (a.getBooks().stream()
                        .anyMatch(b -> (b.getTitle().toLowerCase().contains(title.toLowerCase())))))
                .map(Author::getName)
                .collect(Collectors.joining(", "));

        return ResponseEntity.ok(ret);
    }

    @CrossOrigin
    @GetMapping("/author2")
    public ResponseEntity<String> getAuthorUsingJPA(@RequestParam String title) {

        String ret = authorService.findByBookTitle(title).stream().map(Author::getName)
                .collect(Collectors.joining(", "));

        return ResponseEntity.ok(ret);
    }

}
