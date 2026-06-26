package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("=== Library Management System Started ===");
        bookService.addBook("The Great Gatsby");
        bookService.addBook("Clean Code");
        bookService.searchBook("The Great Gatsby");
        System.out.println("=== Done ===");
        ((ClassPathXmlApplicationContext) context).close();
    }
}
