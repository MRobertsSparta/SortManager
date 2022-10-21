package com.sparta.mr;

import com.sparta.mr.model.sorters.*;
import com.sparta.mr.model.sorters.tree_sort.BinaryTreeSort;
import org.junit.jupiter.api.Test;
import com.sparta.mr.TestUtils;

import java.text.DecimalFormat;
import java.util.Arrays;

public class PerformanceTest {

    private static final int[] testArray = TestUtils.generateRandomIntArray();;

    @Test
    public void testBubbleSortPerformance() {
        testSorterPerformance(new BubbleSort());
    }

    @Test
    public void testMergeSortPerformance() {
        testSorterPerformance(new MergeSort());
    }

    @Test
    public void testBinaryTreeSortPerformance() {
        testSorterPerformance(new BinaryTreeSort());
    }

    @Test
    public void testQuickSortPerformance() { testSorterPerformance(new QuickSort());}

    @Test
    public void testInsertionSortPerformance() {testSorterPerformance(new InsertionSort());}

    private void testSorterPerformance(Sorter sorter) {
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(testArray);
        long end = System.nanoTime();
        printResults(sorter, end - start, testArray, sortedArray);
    }

    private void printResults(Sorter sorter, long time, int[] unsortedArray, int[] sortedArray) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("");
        System.out.println(sorter + ":");
        System.out.println("Initial: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted: " + Arrays.toString(sortedArray));
        System.out.println("Time Taken: " + (df.format(time)) + " nanoseconds");
    }
}
