package com.example.library.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/library")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @CrossOrigin
    @GetMapping("/author")
    public ResponseEntity<String> getAuthorUsingJava(@RequestParam String title) {

        String ret = "";

        try {
            ret = authorService.findAll().stream()
                    .filter(a -> (a.getBooks().stream()
                            .anyMatch(b -> (b.getTitle().toLowerCase().contains(title.toLowerCase())))))
                    .map(Author::getName)
                    .collect(Collectors.joining(", "));

            return ResponseEntity.ok(ret);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping("/author2")
    public ResponseEntity<String> getAuthorUsingJPA(@RequestParam String title) {

        String ret = "";

        try {

            ret = authorService.findByBookTitlePart(title.toLowerCase()).stream().map(Author::getName)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}