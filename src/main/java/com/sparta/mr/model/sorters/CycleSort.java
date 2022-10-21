package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SortUtils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CycleSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Cycle sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the cycle sort.");
            throw new NullArraySortException();
        }
        int[] array = ints.clone();
        for (int i = 0; i < array.length; i++) {
            logger.log(Level.FINE, "Starting cycle at index " + i);
            cycleSort(array, i);
        }
        return array;
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        return SortUtils.timeSort(this, ints);
    }

    public static void cycleSort(int[] ints, int index) {
        int position = 0;
        for (int i: ints) {
            if (i < ints[index]) {
                position++;
            }
        }
        logger.log(Level.FINER, "Position for element " + ints[index]
                + " determined to be " + position);
        while (position != index && ints[index] == ints[position]) {
            position++;
            logger.log(Level.FINEST, "Duplicate found, new position is " + position);
        }
        if (position != index) {
            SortUtils.swap(ints, index, position);
            logger.log(Level.FINEST, "Continuing Cycle");
            cycleSort(ints, index);
        } else {
            logger.log(Level.FINER, "Element is in starting index, cycle finished.");
        }
    }
}
