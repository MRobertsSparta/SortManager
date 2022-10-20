package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.model.util.SortResults;

public class InsertionSort implements Sorter {
    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        return new int[0];
    }

    @Override
    public SortResults timedSort(int[] ints) throws NullArraySortException {
        return null;
    }
}
