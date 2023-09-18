package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/library")
public class AuthorController {

    public AuthorController() {
        System.out.println("===>  AuthorController");
    }

    @Autowired
    AuthorService authorService;

    @CrossOrigin
    @GetMapping("/author")
    public ResponseEntity<String> getAuthorUsingJava(@RequestParam String title) {

        String ret = "";

        try {
            ret = authorService.containsTitleUsingJava(title);
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
            ret = authorService.containsTitleUsingJPA(title);
            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
