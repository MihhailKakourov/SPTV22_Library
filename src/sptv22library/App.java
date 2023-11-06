package sptv22library;

import entity.Author;
import entity.Book;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;


public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[0];
    void run() {
        boolean repeat = true;
        System.out.println("-----Library-----");
        do {
            System.out.println("List tasks");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("Enter task number: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                
                    break;
                case 1:
                    BookManager bookManager = new BookManager(scanner);
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length - 1] = bookManager.addBook();
                    bookManager.addBook();
                    break;
                default:
                    System.out.println("Select task from list");
            }
            System.out.println("-----------------------");
        } while (repeat);
        System.out.println("Bye-bye");
    }
}