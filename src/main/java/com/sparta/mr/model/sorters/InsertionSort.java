package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SortUtils;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Insertion sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the insertion sort.");
            throw new NullArraySortException();
        }
        return insertionSort(ints.clone());
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        return SortUtils.timeSort(this, ints);
    }

    private int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = i;
            logger.log(Level.FINER, "Placing "
                    + array[i] + " (index "
                    + i + ") in the correct location.");
            while (index > 0 && array[index] < array[index - 1]) {
                SortUtils.swap(array, index, --index);
            }
            logger.log(Level.FINER, "Placed "
                    + array[index] + " at index " + index);
        }
        return array;
    }
}
