package com.hayder.LibrarySystem.Classes;

// class abstract _ inheritance 
public abstract class Book implements Borrowable {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }

    public abstract String getBookType();
}
