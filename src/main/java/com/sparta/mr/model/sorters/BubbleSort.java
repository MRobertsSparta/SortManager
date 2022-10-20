package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.SortUtils;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Bubble sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the bubble sort.");
            throw new NullArraySortException();
        }
        int[] array = Arrays.copyOf(ints, ints.length);
        for (int x = 1; x < array.length; x++) {
            for (int y = 0; y < array.length - x; y++) {
                logger.log(Level.FINER, "Comparing "
                        + array[y] + " (index " + y + ") & "
                        + array[y + 1] + " (index " + (y + 1) + ")");
                if (array[y] > array[y + 1]) {
                    SortUtils.swap(array, y, y + 1);
                }
            }
        }
        return array;
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] sortedInts = sort(ints);
        stopWatch.stop();
        return new SortResults(ints, sortedInts, stopWatch.getTime());
    }

}
