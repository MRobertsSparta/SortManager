package com.sparta.mr.display;

import com.sparta.mr.exceptions.InvalidInputException;
import com.sparta.mr.start.SorterOption;

import java.util.Scanner;

public class DisplayManager {

    private static Scanner commandLineIn = new Scanner(System.in);

    public static SorterOption getSorterChoice() {
        System.out.println("Enter the number for the sorting algorithm you want to use: ");
        SorterOption[] options = SorterOption.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println(" - (" + i + ") " + options[i].getName());
        }
        int choice = -1;
        do {
            try {
                System.out.print(">>> ");
                choice = commandLineIn.nextInt();
                if (choice < 0 || choice >= options.length) {
                    throw new InvalidInputException();
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                System.err.println("Invalid Option");
            }
        } while (choice < 0 || choice >= options.length);

        return options[choice];
    }

    public static int getArrayLength() {
        System.out.println("Please enter the length of the randomly produced array (max 1000): ");
        int length = -1;
        do {
            try {
                System.out.print(">>> ");
                length = commandLineIn.nextInt();
                if (length < 0 || length > 1000) {
                    throw new InvalidInputException();
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                System.err.println("Invalid Option");
            }
        } while (length < 0 || length > 1000 );
        return length;
    }

    public static void printSortResults() {

    }
}
