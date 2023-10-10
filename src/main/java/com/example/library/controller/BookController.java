package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.BookDTO;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/book")
    public ResponseEntity<List<String>> getBooks() {
        try {
            return ResponseEntity.ok(bookService.getAllTitle());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping("/bookbytitle")
    public ResponseEntity<String> getBooksByTitle(@RequestParam String title) {
        try {
            return ResponseEntity.ok(String.join(",", bookService.getAllTitleByTitle(title)));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping("/bookbyisbn")
    public ResponseEntity<String> getBooksByIsbn(@RequestParam long isbn) {

        String ret = "";

        try {
            ret = bookService.getTitleByIsbn(isbn);

            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @PostMapping("/book")
    public ResponseEntity<Void> createBook(@RequestBody BookDTO bookDTO) {

        try {

            bookService.createBook(bookDTO);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
