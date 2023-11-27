package managers;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.GregorianCalendar;

import java.util.List;
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
    public History takeOutBook(List<Book> books, List<Reader>  readers) {
        History history = new History();

        bookManager.printListBooks(books);
        int numberBook = InputProtection.intInput(0, books.size());
        history.setBook(books.get(numberBook - 1));

        readerManager.printListReader(readers);
        int numberReader = InputProtection.intInput(0, readers.size());
        history.setReader(readers.get(numberReader - 1));

        history.setTakeOutBook(new GregorianCalendar().getTime());

        return history;
    }

    public void printListReading(List<History> histories) {
        System.out.println("----- List of reading books ------");

        for (int i = 0; i < histories.size(); i++) {
            Reader reader = histories.get(i).getReader();
            Book book = histories.get(i).getBook();
            String fullName = reader.getFirstname() + " " + reader.getLastname();
            String formattedDate = formatDate(histories.get(i).getTakeOutBook());

            System.out.printf("%d. %s - %s - %s%n",
                    i + 1,
                    fullName,
                    book.getTitle(),
                    formattedDate);
        }
    }
    
    private String formatDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public void returnBook(List<History> histories) {
        System.out.println("Return book: ");
        this.printListReading(histories);
        System.out.println("Enter number book from list: ");
        int numberReturnBook = InputProtection.intInput(1, histories.size());
        histories.get(numberReturnBook - 1).setReturnBook(new GregorianCalendar().getTime());
    }
}
