package com.sparta.mr.model.sorters.tree_sort;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.sorters.Sorter;
import com.sparta.mr.model.util.SortResults;
import com.sparta.mr.model.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTreeSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Binary tree sort started. Initial Array: " + Arrays.toString(ints));
        validateInput(ints);

        BinaryTree tree = buildBinaryTree(ints);
        return tree.getOrderedArray();
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Binary tree sort started. Initial Array: " + Arrays.toString(ints));
        validateInput(ints);

        BinaryTree tree = buildBinaryTree(ints);
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int[] sorted = tree.getOrderedArray();
        stopWatch.stop();
        return new SortResults(ints, sorted, stopWatch.getTime());
    }

    private BinaryTree buildBinaryTree(int[] ints) {
        BinaryTree tree = new BinaryTree();
        logger.log(Level.FINE, "Binary tree created.");
        tree.add(ints);
        return tree;
    }

    private void validateInput(int[] ints) throws NullArraySortException {
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the binary tree sort.");
            throw new NullArraySortException();
        }
    }
}
