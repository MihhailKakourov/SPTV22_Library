package managers;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.GregorianCalendar;
import managers.BookManager;
import managers.ReaderManager;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import tools.InputProtection;

public class HistoryManager {
    private final Scanner scanner;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    public HistoryManager(Scanner scanner, ReaderManager readerManager, BookManager bookManager){
        this.scanner = scanner;
        this.bookManager = bookManager;
        this.readerManager = readerManager;
    }
    public History takeOutBook(Book[] books, Reader[] readers){
        History history = new History();
        bookManager.printListBooks(books);
        System.out.println("Enter number book from list: ");
        int numberBook = InputProtection.intInput(0, books.length);
        history.setBook(books[numberBook - 1]);
        readerManager.printListReader(readers);
        System.out.println("Enter number reader from list: ");
        int numberReader = InputProtection.intInput(0, readers.length);
        history.setReader(readers[numberReader - 1]);
        history.setTakeOutBook(new GregorianCalendar().getTime());
        
        return history;
    }

    public void printListReading(History[] histories) {
        System.out.println("----- List of reading books ------");

        for (int i = 0; i < histories.length; i++) {
            System.out.printf("%d. %s - %s - %s%n",
                    i + 1,
                    histories[i].getReader().getFirstname() + " " + histories[i].getReader().getLastname(),
                    histories[i].getBook().getTitle(),
                    formatDate(histories[i].getTakeOutBook()));
        }
    }
    
    private String formatDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
