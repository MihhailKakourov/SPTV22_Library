package managers;
import entity.Reader;
import entity.Book;
import entity.History;

import java.util.*;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

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
    public History takeOutBook(List<Book> books, List<Reader> readers) {
        History history = new History();
        bookManager.printListBooks(books);
        System.out.println("Enter number book from list");
        int numberBook = InputProtection.intInput(0, books.size());
        if(books.get(numberBook-1).getCount() > 0){
            books.get(numberBook - 1).setCount(books.get(numberBook - 1).getCount() - 1);
            history.setBook(books.get(numberBook - 1));
            readerManager.printListReader(readers);
            System.out.println("Enter number reader from list");
            int numberReader = InputProtection.intInput(0, readers.size());
            history.setReader(readers.get(numberReader - 1));
            history.setTakeOutBook(new GregorianCalendar().getTime());
            return history;
        }else{
            System.out.println("All books are taken");
            return null;
        }
    }

    public void printListReading(List<History> histories) {
        System.out.println("----- List of reading books ------");

        for (int i = 0; i < histories.size(); i++) {
            History history = histories.get(i);
            Reader reader = history.getReader();
            Book book = history.getBook();
            String fullName = reader.getFirstname() + " " + reader.getLastname();
            String formattedDate = formatDate(history.getTakeOutBook());

            System.out.printf("%d. %s - %s - %s%n",
                    i + 1,
                    fullName,
                    book.getTitle(),
                    formattedDate);
        }
    }

    private String formatDate(java.util.Date date) {
        return java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date.toInstant());
    }

    public void returnBook(List<History> histories) {
        System.out.println("Return book: ");
        printListReading(histories);
        System.out.println("Enter number book from list: ");
        int numberReturnBook = InputProtection.intInput(1, histories.size());
        History history = histories.get(numberReturnBook - 1);
        if (histories.get(numberReturnBook - 1).getBook().getQuantity()
                < histories.get(numberReturnBook - 1).getBook().getQuantity()) {
            histories.get(numberReturnBook - 1).setReturnBook(new GregorianCalendar().getTime());
        } else {
            System.out.println("All books are in stock");
        }
        history.setReturnBook(new GregorianCalendar().getTime());
    }

    public void bookRating(List<History> histories) {
        Map<Book, Integer> mapRatingBook = new HashMap<>();
        for (History history : histories) {
            mapRatingBook.put(history.getBook(), mapRatingBook.getOrDefault(history.getBook(), 0) + 1);
        }

        List<Map.Entry<Book, Integer>> sortedEntries = new ArrayList<>(mapRatingBook.entrySet());
        sortedEntries.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        for (Map.Entry<Book, Integer> entry : sortedEntries) {
            System.out.printf("%s - %d%n", entry.getKey().getTitle(), entry.getValue());
        }
    }
}
