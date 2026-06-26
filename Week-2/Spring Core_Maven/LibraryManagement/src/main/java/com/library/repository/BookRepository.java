package com.library.repository;

public class BookRepository {
    public void saveBook(String bookTitle) {
        System.out.println("BookRepository: Saving book -> " + bookTitle);
    }
    public String findBook(String bookTitle) {
        System.out.println("BookRepository: Finding book -> " + bookTitle);
        return "Book found: " + bookTitle;
    }
}
