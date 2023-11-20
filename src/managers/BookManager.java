/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import tools.InputProtection;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BookManager {

    private final Scanner scanner;
    
    public BookManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public Book addBook(){
        System.out.println("-----Add book-----");
        Book book = new Book();
        System.out.println("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Enter published year: ");
        book.setPublishedYear(InputProtection.intInput(1000,2030));
        System.out.println("How many authors in book: ");
        int countAuthor = InputProtection.intInput(1,4);
        for (int i = 0; i < countAuthor; i++) {
            System.out.println("Enter Author (%d) firstname: ");
            String authorFirstname = scanner.nextLine();
            System.out.println("Enter Author (%d) lastname: ");
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname, authorLastname));
        }
        System.out.println("Added book: " + book.toString());
        return book; 
    }

    public void printListBooks(Book[] books) {
        System.out.println("list books:");
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%d. %s%n",
                    i+1,
                    books[i].getTitle());
        }
    }
}
