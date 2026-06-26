package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book -> " + bookTitle);
        bookRepository.saveBook(bookTitle);
    }
    public void searchBook(String bookTitle) {
        System.out.println("BookService: Searching for book -> " + bookTitle);
        String result = bookRepository.findBook(bookTitle);
        System.out.println("BookService: " + result);
    }
}
