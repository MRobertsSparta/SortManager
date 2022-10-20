package com.sparta.mr.model.sorters.tree_sort;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.model.sorters.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTreeSort implements Sorter {

    private static final Logger logger = CustomLogger.getLogger();

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        logger.log(Level.INFO, "Binary tree sort started. Initial Array: " + Arrays.toString(ints));
        if (ints == null) {
            logger.log(Level.SEVERE, "Null array passed to the binary tree sort.");
            throw new NullArraySortException();
        }

        BinaryTree tree = new BinaryTree();
        logger.log(Level.FINE, "Binary tree created.");
        tree.add(ints);
        return tree.getOrderedArray();
    }
}
