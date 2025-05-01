package com.hayder.LibrarySystem.Classes;

import java.util.*;

public class LibrarySystem {
    private List<Book> books;    //HAS A
    private List<Borrower> borrowers;   //HAS A
    private List<BorrowingProcess> borrowings;    //HAS A
    private Scanner scanner;

    public LibrarySystem() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        borrowings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n-----library management system-----");
            System.out.println("1_ add Book ");
            System.out.println("2_add Borrower");
            System.out.println("3_borrow Book");
            System.out.println("4_return Book");
            System.out.println("5_search Book");
            System.out.println("6_search Borrower");
            System.out.println("7_show Borrowed Books");
            System.out.println(" exit : 0");

            System.out.print("only one choice ... : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // استهلاك السطر

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addBorrower();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    searchBorrower();
                    break;
                case 7:
                    showBorrowedBooks();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("error in selection ...");
            }
        }
    }

    private void addBook() {
        System.out.print("Title :");
        String title = scanner.nextLine();
        System.out.print("Name author :");
        String author = scanner.nextLine();
        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        System.out.print("1_Paper ...2_EPook :");
        int type = scanner.nextInt();
        scanner.nextLine();

        Book book = (type == 1) ? new PrintedBook(title, author, isbn) : new EBook(title, author, isbn);
        books.add(book);
        System.out.println("The book has been added ...");
    }

    private void addBorrower() {
        System.out.print("Borrower's name :");
        String name = scanner.nextLine();
        System.out.print("University number :");
        String id = scanner.nextLine();
        borrowers.add(new Borrower(name, id));
        System.out.println("Borrower added ...");
    }

    private void borrowBook() {
        System.out.print("Enter the book number(ISBN) :");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book == null || !book.isAvailable()) {
            System.out.println("The book is not available");
            return;
        }

        System.out.print("Enter your university number :");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("Borrower not present...");
            return;
        }

        book.borrow();
        borrower.borrowBook(book);
        borrowings.add(new BorrowingProcess(book, borrower));
        System.out.println("The book has been loaned ...");
    }

    private void returnBook() {
        System.out.print("Enter the number of the book you want to return(ISBN) :");
        String isbn = scanner.nextLine();
        for (BorrowingProcess bp : borrowings) {
            if (bp.getBook().getIsbn().equals(isbn) && bp.getReturnDate() == null) {
                bp.returnBook();
                System.out.println("The book has been retrieved ....");
                return;
            }
        }
        System.out.println("No loan found for this book....");
    }

    private void searchBook() {
        System.out.print("Enter the book number (ISBN) :");
        String key = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.getIsbn().equals(key)) {
                System.out.printf("Title: %s - Author: %s - Type: %s - Available: %s\n", book.getTitle(), book.getAuthor(), book.getBookType(), book.isAvailable());
                found = true;
            }
        }

        if (!found) {
            System.out.println("ERROR: Book not found.");
        }
    }


    private void searchBorrower() {
        System.out.print("Enter your university number :");
        String key = scanner.nextLine();
        boolean found = false;
        for (Borrower b : borrowers) {
            if (b.getStudentId().equals(key)) {
                System.out.printf("Borrower's name: %s - university number: %s\n", b.getName(), b.getStudentId());
                found = true;
            }
        }

        if (!found) {
            System.out.println("ERROR: Borrower not found.");
        }
    }

    private void showBorrowedBooks() {
        System.out.print("Enter your university number :");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("Borrower not present...");
            return;
        }
        List<Book> borrowed = borrower.getBorrowedBooks();
        if (borrowed.isEmpty()) {
            System.out.println("No borrowed books...");
        } else {
            for (Book book : borrowed) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    private Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    private Borrower findBorrower(String id) {
        for (Borrower b : borrowers) {
            if (b.getStudentId().equals(id)) return b;
        }
        return null;
    }
}
