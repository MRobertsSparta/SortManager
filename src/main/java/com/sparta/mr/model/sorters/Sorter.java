package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.model.util.SortResults;

public interface Sorter {
    int[] sort(int[] ints) throws NullArraySortException;
    SortResults timedSort(int[] ints) throws NullArraySortException;
}
