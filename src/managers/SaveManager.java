package managers;

import entity.Book;
import entity.History;
import entity.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    public static List<Book> loadBooks() {
        List<Book> books;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\books.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading \"books.txt\": " + e.getMessage());
            books = new ArrayList<>();
        }
        return books;
    }

    public static List<Reader> loadReaders() {
        List<Reader> readers = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("C:/Users/golan/Documents/NetBeansProjects/SPTV22/SPTV22Library/src/managers/readers.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            readers = (List<Reader>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading readers: " + e.getMessage());
        }
        return readers;
    }

    public static List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\histories.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
             histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: histories.txt");
        } catch (IOException e) {
            System.out.println("I/O error while reading histories.txt");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: History");
        }
        return histories;
    }

    public static void saveBooks(List<Book> books) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\books.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
        } catch (FileNotFoundException e) {
            System.out.println("File \"books.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while writing \"books.txt\"");
        }
    }

    public static void saveReaders(List<Reader> readers) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\readers.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
        } catch (FileNotFoundException e) {
            System.out.println("File \"readers.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while writing \"readers.txt\"");
        }
    }

    public static void saveHistories(List<History> histories) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\histories.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
        } catch (FileNotFoundException e) {
            System.out.println("File \"histories.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while writing \"histories.txt\"");
        }
    }


}
