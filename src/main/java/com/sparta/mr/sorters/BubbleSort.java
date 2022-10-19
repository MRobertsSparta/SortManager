package com.sparta.mr.sorters;

import com.sparta.mr.exceptions.NullArraySortException;

import java.util.Arrays;

public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] ints) throws NullArraySortException {
        if (ints == null) {
            throw new NullArraySortException();
        }
        int[] array = Arrays.copyOf(ints, ints.length);
        for (int x = 1; x < array.length; x++) {
            for (int y = 0; y < array.length - x; y++) {
                if (array[y] > array[y + 1]) {
                    SortUtils.swap(array, y, y + 1);
                }
            }
        }
        return array;
    }

}
