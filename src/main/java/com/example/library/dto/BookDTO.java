package com.example.library.dto;

public class BookDTO {

    private String title;

    private Long Isbn;

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIsbn() {
        return Isbn;
    }

    public void setIsbn(Long isbn) {
        Isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
