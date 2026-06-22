package com.exercise2.documents;

public abstract class DocumentFactory {
    public abstract Document createDocument();

    public Document openDocument() {
        Document document = createDocument();
        document.open();
        return document;
    }
}
