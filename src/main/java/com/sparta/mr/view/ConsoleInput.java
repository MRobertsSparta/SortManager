package com.sparta.mr.view;

import com.sparta.mr.controller.exceptions.InvalidInputException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SorterOption;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInput {

    private static final Scanner commandLineIn = new Scanner(System.in);
    private static final Logger logger = CustomLogger.getLogger();

    public static SorterOption getSorterChoice() {
        SorterOption[] options = SorterOption.values();
        int choice = -1;

        try {
            System.out.print(">>> ");
            String choiceString = commandLineIn.nextLine();
            choice = Integer.valueOf(choiceString);
            logger.log(Level.FINE, "User inputted: " + choice);
            if (choice < 0 || choice >= options.length) {
                throw new InvalidInputException();
            }
        } catch (NumberFormatException | InvalidInputException ex) {
            System.out.println("Invalid Option");
            logger.log(Level.WARNING, "User entered invalid input");
            return getSorterChoice();
        }
        return options[choice];
    }

    public static int getArrayLength() {
        int length = -1;
        try {
            System.out.print(">>> ");
            String lengthString = commandLineIn.nextLine();
            length = Integer.valueOf(lengthString);
            logger.log(Level.FINE, "User inputted: " + length);
            if (length < 0 || length > 1000) {
                throw new InvalidInputException();
            }
        } catch (NumberFormatException | InvalidInputException ex) {
            logger.log(Level.WARNING, "User entered invalid input");
            System.err.println("Invalid Option");
            return getArrayLength();
        }
        return length;
    }
}
