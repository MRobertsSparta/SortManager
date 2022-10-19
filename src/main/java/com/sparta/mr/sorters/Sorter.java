package com.sparta.mr.sorters;

import com.sparta.mr.exceptions.NullArraySortException;

public interface Sorter {
    int[] sort(int[] ints) throws NullArraySortException;
}
