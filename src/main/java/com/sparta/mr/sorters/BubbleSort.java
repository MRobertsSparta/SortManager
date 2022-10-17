package com.sparta.mr.sorters;

import java.util.Arrays;

public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] ints) {
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
