package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SortUtils;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectionSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Selection sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the selection sort.");
            throw new NullArraySortException();
        }

        return selectionSort(ints.clone());
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        return SortUtils.timeSort(this, ints);
    }

    private int[] selectionSort(int[] ints) {
        for (int x = 0; x < ints.length; x++) {
            logger.log(Level.FINE, "Placing the correct value at index " + x);
            int minIndex = x;
            for (int y = x; y < ints.length; y++) {
                if (ints[y] < ints[minIndex]) {
                    logger.log(Level.FINER, ints[y] + " is less than " + ints[minIndex]
                            + " it has been set as the new lowest remaining value.");
                    minIndex = y;
                }
            }
            SortUtils.swap(ints, x, minIndex);
            logger.log(Level.FINER, ints[x] + " has been placed at index " + x);
        }
        return ints;
    }
}
