package com.sparta.mr.start;

import com.sparta.mr.sorters.BubbleSort;
import com.sparta.mr.sorters.MergeSort;
import com.sparta.mr.sorters.Sorter;
import com.sparta.mr.sorters.tree_sort.BinaryTreeSort;

public class SortFactory {

    public static Sorter getSorter(SorterOption option) {
        return switch(option) {
            case BUBBLE -> new BubbleSort();
            case MERGE -> new MergeSort();
            case TREE -> new BinaryTreeSort();
        };
    }
}
