package managers;

import entity.Book;
import entity.History;
import entity.Reader;

import java.io.*;

public class SaveManager {
    public static Book[] loadBooks() {
        Book[] books = new Book[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\books.txt");
            ois = new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File \"books.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while reading \"books.txt\"");
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Book\" not found");
        }
        return books;
    }

    public static Reader[] loadReaders() {
        Reader[] readers = new Reader[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\readers.txt");
            ois = new ObjectInputStream(fis);
            readers = (Reader[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File \"readers.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while reading \"readers.txt\"");
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Reader\" not found");
        }
        return readers;
    }

    public static History[] loadHistories() {
        History[] histories = new History[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("C:\\Users\\golan\\Documents\\NetBeansProjects\\SPTV22\\SPTV22Library\\src\\managers\\histories.txt");
            ois = new ObjectInputStream(fis);
            histories = (History[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File \"histories.txt\" not found");
        } catch (IOException e) {
            System.out.println("I/O error while reading \"histories.txt\"");
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"History\" not found");
        }
        return histories;
    }

    public static void saveBooks(Book[] books) {
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

    public static void saveReaders(Reader[] readers) {
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

    public static void saveHistories(History[] histories) {
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
