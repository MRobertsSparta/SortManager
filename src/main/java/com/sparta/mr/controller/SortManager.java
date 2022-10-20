package com.sparta.mr.controller;

import com.sparta.mr.model.sorters.Sorter;
import com.sparta.mr.model.util.IntArrayGenerator;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SorterOption;
import com.sparta.mr.view.ConsoleInput;
import com.sparta.mr.view.ConsolePrinter;

public class SortManager {

    public static void start() {
        ConsolePrinter.printSorterChoices();
        SorterOption sorterOption = ConsoleInput.getSorterChoice();
        Sorter sorter = SortFactory.getSorter(sorterOption);

        ConsolePrinter.printArrayLengthMessage();
        int length = ConsoleInput.getArrayLength();
        int[] unsortedArray = IntArrayGenerator.generateRandomIntArray(length);

        SortResults results = sorter.timedSort(unsortedArray);
        ConsolePrinter.printSortResults(results);
    }
}
