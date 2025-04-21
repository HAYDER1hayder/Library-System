package com.hayder.LibrarySystem.Classes;

public class EBook extends Book {
    public EBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    @Override
    public String getBookType() {
        return "Electronic";
    }
}