package com.example.library.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dto.BookDTO;
import com.example.library.model.Author;
import com.example.library.model.Book;

import jakarta.transaction.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<String> getAllTitle() {
        return bookRepository.findAll().stream().map(Book::getTitle).collect(Collectors.toList());
    }

    public List<String> getAllTitleByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(Book::getTitle).collect(Collectors.toList());
    }

    public String getTitleByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn).getTitle();
    }

    @Transactional
    public void createBook(BookDTO bookDTO) {
        Book b = new Book();

        // get author
        Optional<Author> author = authorRepository.findByName(bookDTO.getAuthor());

        if (author.isPresent()) {
            b.setAuthor(author.get());
        } else {
            Author a = new Author();
            a.setName(bookDTO.getAuthor());
            authorRepository.save(a);
            b.setAuthor(a);
        }

        b.setTitle(bookDTO.getTitle());
        b.setIsbn(bookDTO.getIsbn());
        bookRepository.save(b);
    }

}
