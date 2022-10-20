package com.sparta.mr.view;

import com.sparta.mr.controller.exceptions.InvalidInputException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SorterOption;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInput {

    private static final Scanner commandLineIn = new Scanner(System.in);
    private static final Logger logger = CustomLogger.getLogger();

    public static SorterOption getSorterChoice() {
        logger.log(Level.INFO, "Sorter choice requested from the user.");
        SorterOption[] options = SorterOption.values();
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
}
