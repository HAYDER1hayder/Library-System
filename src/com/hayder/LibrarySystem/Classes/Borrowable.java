package com.hayder.LibrarySystem.Classes;

public interface Borrowable {
    void borrow();
    void returnBook();
    boolean isAvailable();
}
