package com.sparta.mr.sort_tests;

import com.sparta.mr.TestUtils;
import com.sparta.mr.controller.exceptions.NullArraySortException;
import com.sparta.mr.model.sorters.QuickSort;
import com.sparta.mr.model.util.SortResults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

public class QuickSortTest {

    private QuickSort sorter = new QuickSort();

    @ParameterizedTest
    @MethodSource("com.sparta.mr.TestUtils#getRandomIntArrayAsStream")
    @DisplayName("Test if an unsorted array is sorted")
    void TestUnsortedArray(int[] unsorted) {
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);

        Assertions.assertArrayEquals(sorted, sorter.sort(unsorted));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.TestUtils#getRandomSortedIntArrayAsStream")
    @DisplayName("Test if a reverse sorted array is sorted")
    void TestReverseSortedArray(int[] sorted) {
        int[] unsorted = sorted.clone();
        TestUtils.reverseArray(unsorted);

        Assertions.assertArrayEquals(sorted, sorter.sort(unsorted));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.TestUtils#getRandomSortedIntArrayAsStream")
    @DisplayName("Test if a sorted array remains sorted")
    void TestSortedArray(int[] sorted) {
        Arrays.sort(sorted);

        Assertions.assertArrayEquals(sorted, sorter.sort(sorted));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.TestUtils#getRandomIntArrayAsStream")
    @DisplayName("Test if the input array is unchanged")
    void TestInputArrayUnchanged(int[] inputArray) {
        int[] compareArray = Arrays.copyOf(inputArray, inputArray.length);
        sorter.sort(inputArray);

        Assertions.assertArrayEquals(compareArray, inputArray);
    }

    @Test
    @DisplayName("Test if an array with duplicates is sorted")
    void TestArrayWithDuplicates() {
        int[] unsorted = {10, 5, 2, 7, 5, 1, 5, 1};
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);
        Assertions.assertArrayEquals(sorted, sorter.sort(unsorted));
    }

    @Test
    @DisplayName("Test if an array with negative numbers is sorted")
    void TestArrayWithNegatives() {
        int[] unsorted = {-10, -5, -2, -7, -3, -1, 5, 1};
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);
        Assertions.assertArrayEquals(sorted, sorter.sort(unsorted));
    }

    @Test
    @DisplayName("Test if an array with an odd number of elements is sorted")
    void TestOddLengthArray() {
        int[] unsorted = {-10, -5, -2, -7, -3, -1, 5};
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);
        Assertions.assertArrayEquals(sorted, sorter.sort(unsorted));
    }

    @Test
    @DisplayName("Test if an array with one element is returned unchanged")
    void TestSingleElement() {
        int[] ints = {0};
        Assertions.assertArrayEquals(ints, sorter.sort(ints));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Test if an empty array is returned empty")
    void TestIfEmptyArrayIsReturned(int[] empty) {
        Assertions.assertArrayEquals(empty, sorter.sort(empty));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Test if a null array throws an exception")
    void TestNullArray(int[] empty) {
        Assertions.assertThrows(NullArraySortException.class, () -> {sorter.sort(empty);});
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.TestUtils#getRandomIntArrayAsStream")
    @DisplayName("Test if the sorter can be timed")
    void TestSorterCanBeTimed(int[] unsorted) {
        SortResults results = sorter.timedSort(unsorted);
        Assertions.assertNotEquals(0l, results.getTimeTakenNano());
    }
}