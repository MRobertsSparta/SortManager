package com.sparta.mr.sorters;

import java.util.Arrays;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] ints) {
        if (ints.length < 2) {
            return ints;
        } else {
            int[] intsLeft = Arrays.copyOfRange(ints, 0, ints.length / 2);
            int[] intsRight = Arrays.copyOfRange(ints, ints.length / 2, ints.length);
            return merge(sort(intsLeft), sort(intsRight));
        }
    }

    private int[] merge(int[] left, int[] right) {
        int[] merge = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merge[mergeIndex++] = left[leftIndex++];
            } else {
                merge[mergeIndex++] = right[rightIndex++];
            }
        }
        while(leftIndex < left.length) {
            merge[mergeIndex++] = left[leftIndex++];
        }
        while(rightIndex < right.length) {
            merge[mergeIndex++] = right[rightIndex++];
        }

        return merge;
    }

}
