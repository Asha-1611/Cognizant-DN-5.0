package com.exercise2.documents;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        System.out.println("Is WordDocument? " + (wordDoc instanceof WordDocument));

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        System.out.println("Is PdfDocument? " + (pdfDoc instanceof PdfDocument));

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        System.out.println("Is ExcelDocument? " + (excelDoc instanceof ExcelDocument));
    }
}
