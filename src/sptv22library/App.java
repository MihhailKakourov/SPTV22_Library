package sptv22library;

import entity.Book;
import entity.Reader;
import entity.History;
import managers.ReaderManager;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;
import managers.HistoryManager;
import tools.InputProtection;
import managers.SaveManager;


public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    
    public App(){
        this.books = SaveManager.loadBooks();
        this.readers = SaveManager.loadReaders();
        this.histories = SaveManager.loadHistories();
        this.scanner = new Scanner(System.in);
        this.bookManager = new BookManager(scanner);
        this.readerManager = new ReaderManager(scanner);
        this.historyManager = new HistoryManager(scanner, readerManager, bookManager);
    }
    
    
    void run() {
        boolean repeat = true;
        System.out.println("-----Library-----");
        do {
            System.out.println("List tasks");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Print list books");
            System.out.println("3. Add new reader");
            System.out.println("4. Print list readers");
            System.out.println("5. Take out book");
            System.out.println("6. Print list reading books");
            System.out.println("7. Return book");
            System.out.println("Enter task number: ");
            int task = InputProtection.intInput(0, 7);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length - 1] = bookManager.addBook();
                    SaveManager.saveBooks(this.books);
                    break;
                case 2:
                    bookManager.printListBooks(books);
                    
                    break;
                case 3:
                    this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
                    this.readers[this.readers.length - 1] = readerManager.addReader();
                    SaveManager.saveReaders(readers);
                    break;
                case 4:
                    readerManager.printListReader(readers);
                    break;
                case 5:
                    this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
                    this.histories[this.histories.length - 1] = historyManager.takeOutBook(books, readers);
                    SaveManager.saveHistories(histories);
                    break;
                case 6:
                    historyManager.printListReading(histories);
                    break;
                case 7:
                    historyManager.returnBook(histories);
                    SaveManager.saveHistories(histories);
                    break;
                default:
                    System.out.println("Select task from list");
            }
            System.out.println("-----------------------");
        } while (repeat);
        System.out.println("Bye-bye");
    }
}