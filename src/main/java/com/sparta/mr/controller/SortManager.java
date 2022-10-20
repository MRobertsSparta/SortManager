package com.sparta.mr.controller;

import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.sorters.Sorter;
import com.sparta.mr.model.util.IntArrayGenerator;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SorterOption;
import com.sparta.mr.view.ConsoleInput;
import com.sparta.mr.view.ConsolePrinter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortManager {

    private static final Logger logger = CustomLogger.getLogger();

    public static void start() {
        logger.log(Level.INFO, "Sort Manager application started.");
        ConsolePrinter.printSorterChoices();
        SorterOption sorterOption = ConsoleInput.getSorterChoice();
        Sorter sorter = SortFactory.getSorter(sorterOption);

        ConsolePrinter.printArrayLengthMessage();
        int length = ConsoleInput.getArrayLength();
        int[] unsortedArray = IntArrayGenerator.generateRandomIntArray(length);

        SortResults results = sorter.timedSort(unsortedArray);
        logger.log(Level.INFO, "Array sorted in " + results.getTimeTakenNano()
                +" nanoseconds, final array: " + results.getSortedArray());
        ConsolePrinter.printSortResults(results);
        logger.log(Level.INFO, "Process finished.");
    }
}
