package com.sparta.mr;

import com.sparta.mr.sorters.BubbleSort;
import com.sparta.mr.sorters.Sorter;

public class SortFactory {

    public static Sorter getSorter(SorterOption option) {
        return switch(option) {
            case BUBBLE_SORT -> new BubbleSort();
        };
    }
}
