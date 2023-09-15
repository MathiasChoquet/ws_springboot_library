package com.example.library.controller;

import java.util.Optional;
import java.util.stream.Collectors;

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

import com.example.library.controller.dto.BookDTO;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @CrossOrigin
    @GetMapping("/book")
    public ResponseEntity<String> getBooks() {

        String ret = "";

        try {
            ret = bookService.findAll().stream().map(Book::getTitle)
                    .collect(Collectors.joining(", "));

            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping("/bookbytitle")
    public ResponseEntity<String> getBooksByTitle(@RequestParam String title) {

        String ret = "";

        try {
            ret = bookService.findByTitle(title).stream().map(Book::getTitle)
                    .collect(Collectors.joining(", "));

            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping("/bookbyisbn")
    public ResponseEntity<String> getBooksByIsbn(@RequestParam long isbn) {

        String ret = "";

        try {
            ret = bookService.findByIsbn(isbn).getTitle();

            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @PostMapping("/book")
    public ResponseEntity<Void> createBook(@RequestBody BookDTO bookDTO) {

        try {

            Book b = new Book();

            // get author
            Optional<Author> author = authorService.findByName(bookDTO.getAuthor());

            if (author.isPresent()) {
                b.setAuthor(author.get());
            } else {
                Author a = new Author();
                a.setName(bookDTO.getAuthor());
                authorService.save(a);
                b.setAuthor(a);
            }

            b.setTitle(bookDTO.getTitle());
            bookService.save(b);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
