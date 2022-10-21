package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SortUtils;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Quick sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the quick sort.");
            throw new NullArraySortException();
        }
        return quickSort(ints.clone(), 0, ints.length - 1);
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        return SortUtils.timeSort(this, ints);
    }

    private int partition(int ints[], int start, int end) {
        int pivot = ints[end];
        int x = start;
        logger.log(Level.FINE, "Pivot set to " + pivot);

        for (int y = start; y < end; y++) {
            logger.log(Level.FINER, "Compared " + ints[y]
                    + " at index " + y + " to pivot " + pivot);
            if (ints[y] < pivot) {
                SortUtils.swap(ints, x++, y);
            }
        }
        logger.log(Level.FINER, "Moving pivot to right place.");
        SortUtils.swap(ints, x, end);
        return x;
    }

    private int[] quickSort(int ints[], int start, int end) {
        if (start < end) {
            logger.log(Level.FINE, "Quick sorting array "
                    + Arrays.toString(ints) + " from index "
                    + start + " to index " + end);
            int partition = partition(ints, start, end);
            quickSort(ints, start, partition - 1);
            quickSort(ints, partition + 1, end);
        }
        return ints;
    }
}
