package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Merge sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the merge sort.");
            throw new NullArraySortException();
        }
        if (ints.length < 2) {
            return ints;
        } else {

            int[] intsLeft = Arrays.copyOfRange(ints, 0, ints.length / 2);
            int[] intsRight = Arrays.copyOfRange(ints, ints.length / 2, ints.length);
            logger.log(Level.FINE, "Array Split into " + Arrays.toString(intsLeft)
                    + " & " + Arrays.toString(intsRight));
            return merge(sort(intsLeft), sort(intsRight));
        }
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] sortedInts = sort(ints);
        stopWatch.stop();
        return new SortResults(ints, sortedInts, stopWatch.getTime());
    }

    private int[] merge(int[] left, int[] right) {
        logger.log(Level.FINE, "Merging arrays " + Arrays.toString(left)
                + " & " + Arrays.toString(right));
        int[] merge = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                logger.log(Level.FINER, "Adding " + left[leftIndex]
                        + " to index " + mergeIndex);
                merge[mergeIndex++] = left[leftIndex++];
            } else {
                logger.log(Level.FINER, "Adding " + right[rightIndex]
                        + " to index " + mergeIndex);
                merge[mergeIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            logger.log(Level.FINER, "Adding " + left[leftIndex]
                    + " to index " + mergeIndex);
            merge[mergeIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            logger.log(Level.FINER, "Adding " + right[rightIndex]
                    + " to index " + mergeIndex);
            merge[mergeIndex++] = right[rightIndex++];
        }

        return merge;
    }

}
