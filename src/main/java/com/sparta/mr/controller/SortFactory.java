package com.sparta.mr.controller;

import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.sorters.*;
import com.sparta.mr.model.sorters.tree_sort.BinaryTreeSort;
import com.sparta.mr.model.util.SorterOption;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortFactory {

    private static final Logger logger = CustomLogger.getLogger();

    public static Sorter getSorter(SorterOption option) {
        logger.log(Level.INFO, option.getName() + " requested from sort factory.");
        return switch(option) {
            case BUBBLE -> new BubbleSort();
            case MERGE -> new MergeSort();
            case TREE -> new BinaryTreeSort();
            case QUICK -> new QuickSort();
            case INSERTION -> new InsertionSort();
            case CYCLE -> new CycleSort();
            case SELECTION -> new SelectionSort();
        };
    }
}
