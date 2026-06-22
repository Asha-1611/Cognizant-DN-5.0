package com.exercise2.documents;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }

    public void save() {
        System.out.println("Saving PDF document...");
    }
}
