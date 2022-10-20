package com.sparta.mr.view;

import com.sparta.mr.controller.exceptions.InvalidInputException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SorterOption;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayManager {

    private static final Scanner commandLineIn = new Scanner(System.in);
    private static final Logger logger = CustomLogger.getLogger();

    public static SorterOption getSorterChoice() {
        logger.log(Level.INFO, "Sorter choice requested from the user.");
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
                logger.log(Level.FINE, "User inputted: " + choice);
                if (choice < 0 || choice >= options.length) {
                    throw new InvalidInputException();
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                System.err.println("Invalid Option");
                logger.log(Level.WARNING, "User entered invalid input");
            }
        } while (choice < 0 || choice >= options.length);

        return options[choice];
    }

    public static int getArrayLength() {
        logger.log(Level.INFO, "Random array length requested from the user.");
        System.out.println("Please enter the length of the randomly produced array (max 1000): ");
        int length = -1;
        do {
            try {
                System.out.print(">>> ");
                length = commandLineIn.nextInt();
                logger.log(Level.FINE, "User inputted: " + length);
                if (length < 0 || length > 1000) {
                    throw new InvalidInputException();
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                logger.log(Level.WARNING, "User entered invalid input");
                System.err.println("Invalid Option");
            }
        } while (length < 0 || length > 1000 );
        return length;
    }

    public static void printSortResults() {

    }
}
