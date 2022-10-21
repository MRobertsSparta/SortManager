package com.sparta.mr.model.util;

import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.sorters.Sorter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortUtils {

    private static final Logger logger = CustomLogger.getLogger();

    public static void swap(int[] array, int first, int second) {
        logger.log(Level.FINEST, "Swapped "
                + array[first] + " (index " + first + ") & "
                + array[second] + " (index " + second + ")");
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static SortResults timeSort(Sorter sorter, int[] ints) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] sortedInts = sorter.sort(ints);
        stopWatch.stop();
        return new SortResults(ints, sortedInts, stopWatch.getTime());
    }

}
