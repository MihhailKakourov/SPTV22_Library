/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
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
        book.setPublishedYear(scanner.nextInt());scanner.nextLine();
        System.out.println("How many authors in book: ");
        int countAuthor = scanner.nextInt(); scanner.nextLine();
        for (int i = 0; i < countAuthor; i++) {
            System.out.println("Enter Author firstname: ");
            String authorFirstname = scanner.nextLine();
            System.out.println("Enter Author lastname: ");
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname, authorLastname));
        }
        System.out.println("Added book: " + book.toString());
        return book; 
    }
}
