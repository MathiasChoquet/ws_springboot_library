package com.example.library.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Author;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService() {
        System.out.println("===> Constructor AuthorService Thread ID=[" + Thread.currentThread().getId()
                + "] instance de classe=[" + this.hashCode() + "]");
    }

    public String containsTitleUsingJava(String title) {
        System.out.println(" => AuthorService::getAuthorUsingJava Thread ID=[" + Thread.currentThread().getId()
                + "] instance de classe=[" + this.hashCode() + "]");
        return authorRepository.findAll().stream()
                .filter(a -> (a.getBooks().stream()
                        .anyMatch(b -> (b.getTitle().toLowerCase().contains(title.toLowerCase())))))
                .map(Author::getName)
                .collect(Collectors.joining(", "));
    }

    public String containsTitleUsingJPA(String title) {
        return authorRepository.findByBookTitlePart(title.toLowerCase()).stream().map(Author::getName)
                .collect(Collectors.joining(", "));
    }

}
