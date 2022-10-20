package com.sparta.mr.view;

import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SorterOption;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsolePrinter {

    private static final Logger logger = CustomLogger.getLogger();

    public static void printSorterChoices() {
        logger.log(Level.INFO, "Sorter choice requested from the user.");
        System.out.println("Enter the number for the sorting algorithm you want to use: ");
        SorterOption[] options = SorterOption.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println(" - (" + i + ") " + options[i].getName());
        }
    }

    public static void printArrayLengthMessage() {
        logger.log(Level.INFO, "Random array length requested from the user.");
        System.out.println("Please enter the length of the randomly produced array (max 1000): ");
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("");
            }
        }
    }

    public static void printSortResults(SortResults sortResults) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Before Sorting:");
        printArray(sortResults.getInitialArray());
        System.out.println("After Sorting:");
        printArray(sortResults.getSortedArray());
        System.out.println("Time taken "
                + (df.format(sortResults.getTimeTakenNano()))
                + " nanoseconds.");
    }
}
