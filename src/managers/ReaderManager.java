/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ReaderManager {

    private final Scanner scanner;
    
    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public Reader addReader(){
        System.out.println("-----Add reader-----");
        Reader reader = new Reader();
        System.out.println("Enter first name: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Enter last name: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Enter phone number: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader: " + reader.toString());
        return reader; 
    }
    
    public void printListReader(List<Reader> readers) {
        System.out.println("List of readers:");
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s - %s%n",
                    i + 1,
                    readers.get(i).getFirstname(),
                    readers.get(i).getLastname());
                    readers.get(i).getPhone();
        }
    }

}
