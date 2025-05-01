package com.hayder.LibrarySystem.Classes;
// Create a package 

import java.time.LocalDate;

public class BorrowingProcess {
    private Book book;// HAS A
    private Borrower borrower;// HAS A
    private LocalDate borrowDate;// HAS A 
    private LocalDate returnDate;// HAS A

    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        book.returnBook();
        borrower.returnBook(book);
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
