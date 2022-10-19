package com.sparta.mr.sorters.tree_sort;

import com.sparta.mr.exceptions.NullArraySortException;
import com.sparta.mr.sorters.Sorter;

public class BinaryTreeSort implements Sorter {
    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        if (ints == null) {
            throw new NullArraySortException();
        }

        BinaryTree tree = new BinaryTree();
        tree.add(ints);
        return tree.getOrderedArray();
    }
}
