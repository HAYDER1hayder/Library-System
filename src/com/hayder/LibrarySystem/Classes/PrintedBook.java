package com.hayder.LibrarySystem.Classes;
public class PrintedBook extends Book {
    public PrintedBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    @Override
    public String getBookType() {
        return "Printed";
    }
}