package com.hayder.LibrarySystem.Classes;

import java.util.ArrayList;
import java.util.List;

public class Borrower{
    private String name;// Attribute _ Encapsulation 
    private String studentId;
    private List<Book> borrowedBooks;
    
    // Constructors avec parameter
    public Borrower(String name, String studentId) { 
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {// Function of type List<Book> 
        return borrowedBooks;
    }
}
