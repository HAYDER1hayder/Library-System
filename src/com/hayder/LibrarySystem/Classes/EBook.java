package com.hayder.LibrarySystem.Classes;

public class EBook extends Book {
    public EBook(String title, String author, String isbn) {
        // Constructors avec parameter inheritance Book
        super(title, author, isbn);
    }

    // Override
    public String getBookType() {
        return "Electronic";
    }
}
