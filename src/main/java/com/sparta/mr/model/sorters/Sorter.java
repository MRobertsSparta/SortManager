package com.sparta.mr.model.sorters;

import com.sparta.mr.controller.exceptions.NullArraySortException;

public interface Sorter {
    int[] sort(int[] ints) throws NullArraySortException;
}
