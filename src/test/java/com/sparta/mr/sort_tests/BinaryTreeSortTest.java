package com.sparta.mr.sort_tests;

import com.sparta.mr.exceptions.NullArraySortException;
import com.sparta.mr.sorters.BubbleSort;
import com.sparta.mr.sorters.tree_sort.BinaryTreeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

public class BinaryTreeSortTest {
    private BinaryTreeSort sorter = new BinaryTreeSort();

    @ParameterizedTest
    @MethodSource("com.sparta.mr.sort_tests.TestUtils#getRandomIntArrayAsStream")
    @DisplayName("Test if an unordered list is ordered")
    void TestUnorderedList(int[] unordered) {
        int[] ordered = Arrays.copyOf(unordered, unordered.length);
        Arrays.sort(ordered);

        Assertions.assertArrayEquals(ordered, sorter.sort(unordered));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.sort_tests.TestUtils#getRandomOrderedIntArrayAsStream")
    @DisplayName("Test if an reverse ordered list is ordered")
    void TestReverseOrderedList(int[] ordered) {
        int[] unordered = Arrays.copyOf(ordered, ordered.length);
        TestUtils.reverseArray(unordered);

        Assertions.assertArrayEquals(ordered, sorter.sort(unordered));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.sort_tests.TestUtils#getRandomOrderedIntArrayAsStream")
    @DisplayName("Test if an ordered list remains ordered")
    void TestOrderedList(int[] ordered) {
        Arrays.sort(ordered);

        Assertions.assertArrayEquals(ordered, sorter.sort(ordered));
    }

    @ParameterizedTest
    @MethodSource("com.sparta.mr.sort_tests.TestUtils#getRandomIntArrayAsStream")
    @DisplayName("Test if the input list is unchanged")
    void TestInputListUnchanged(int[] inputList) {
        int[] compareList = Arrays.copyOf(inputList, inputList.length);
        sorter.sort(inputList);

        Assertions.assertArrayEquals(compareList, inputList);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Test if an empty list is returned empty")
    void TestIfEmptyListIsReturned(int[] empty) {
        Assertions.assertArrayEquals(empty, sorter.sort(empty));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Test if a null list throws an exception")
    void TestNullList(int[] empty) {
        Assertions.assertThrows(NullArraySortException.class, () -> {sorter.sort(empty);});
    }
}
