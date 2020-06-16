package com.wcs.biblio.model;

import java.util.Objects;

public class Book {
    
    private Long id_book;
    private String title;
    private String author;
    private String description;


    public Book() {
    }

    public Book(Long id_book, String title, String author, String description) {
        this.id_book = id_book;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId_book() {
        return this.id_book;
    }

    public void setId_book(Long id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book id_book(Long id_book) {
        this.id_book = id_book;
        return this;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public Book description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id_book, book.id_book) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_book, title, author, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id_book='" + getId_book() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

}